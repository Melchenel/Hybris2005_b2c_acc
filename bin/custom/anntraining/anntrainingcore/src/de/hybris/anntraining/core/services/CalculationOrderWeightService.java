package de.hybris.anntraining.core.services;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.OrderModel;

public interface CalculationOrderWeightService {

    /**
     * Посчитать вес одной позиуии заказа
     */
    void calculateCartEntryWeight(AbstractOrderEntryModel orderEntryModel);

    /**
     * Посчитать вес заказа
     */
    void calculateCartWeight(CartModel cartModel);


}
