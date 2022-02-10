package de.hybris.anntraining.facades.populators;

import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.spockframework.util.Assert;

public class CartWeightPopulator implements Populator<CartModel, CartData> {

    @Override
    public void populate(CartModel source, CartData target) throws ConversionException {
        Assert.notNull(source, "source must not be null");
        Assert.notNull(target, "target must not be null");

        target.setWeight(source.getWeight());
    }
}
