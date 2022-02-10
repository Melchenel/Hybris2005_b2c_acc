package de.hybris.anntraining.core.services.impl;

import de.hybris.anntraining.core.services.CalculationOrderWeightService;
import de.hybris.platform.commerceservices.order.CommerceCartModification;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.commerceservices.order.impl.DefaultCommerceAddToCartStrategy;
import de.hybris.platform.commerceservices.order.impl.DefaultCommerceCartService;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import org.springframework.beans.factory.annotation.Autowired;

public class AnnaDefaultCommerceCartService extends DefaultCommerceCartService {

    @Autowired
    private CalculationOrderWeightService calculationOrderWeightService;

    @Override
    public CommerceCartModification addToCart(final CommerceCartParameter parameter) throws CommerceCartModificationException
    {
        final CommerceCartModification modification = super.addToCart(parameter);
        calculationOrderWeightService.calculateCartEntryWeight(modification.getEntry());
        calculationOrderWeightService.calculateCartWeight(parameter.getCart());
        return modification;
    }
}
