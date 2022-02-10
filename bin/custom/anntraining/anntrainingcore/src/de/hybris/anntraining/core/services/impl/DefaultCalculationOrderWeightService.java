package de.hybris.anntraining.core.services.impl;

import de.hybris.anntraining.core.services.CalculationOrderWeightService;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.spockframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DefaultCalculationOrderWeightService implements CalculationOrderWeightService {
    private static final Logger LOG = Logger.getLogger(DefaultCalculationOrderWeightService.class);
    private static final Double NULL_WEIGHT = 0.0;

    @Autowired
    private ModelService modelService;

    @Override
    public void calculateCartEntryWeight(AbstractOrderEntryModel orderEntryModel) {
        Assert.notNull(orderEntryModel);

        Double weight = recalculateCartEntryWeight(orderEntryModel);

        LOG.debug("Entry weight " +  weight);
        orderEntryModel.setWeight(weight);

        modelService.save(orderEntryModel);

    }

    @Override
    public void calculateCartWeight(CartModel cartModel) {
        Assert.notNull(cartModel);
        List<AbstractOrderEntryModel> entryModels = cartModel.getEntries();
        Double weight;

        if (CollectionUtils.isNotEmpty(entryModels)) {
            weight = sumWeightOfEntries(entryModels);
        }
        else {
            weight = NULL_WEIGHT;
        }

        LOG.debug("Order weight " +  weight);
        cartModel.setWeight(weight);

        modelService.save(cartModel);
    }

    private Double recalculateCartEntryWeight(AbstractOrderEntryModel orderEntryModel){

        ProductModel product =  orderEntryModel.getProduct();
        if (product != null && product.getWeight() != null) {

            BigDecimal productWeight = new BigDecimal(product.getWeight());
            BigDecimal quantity = new BigDecimal(orderEntryModel.getQuantity());
            BigDecimal entryWeight = productWeight.multiply(quantity).setScale(2, RoundingMode.HALF_UP);

            return entryWeight.doubleValue();
        }

        return NULL_WEIGHT;
    }

    private Double sumWeightOfEntries(List<AbstractOrderEntryModel> entryModels){

        BigDecimal newWeight = new BigDecimal(entryModels
                .stream()
                .mapToDouble(this::recalculateCartEntryWeight)
                .sum()).setScale(2, RoundingMode.HALF_UP);

        return newWeight.doubleValue();
    }
}
