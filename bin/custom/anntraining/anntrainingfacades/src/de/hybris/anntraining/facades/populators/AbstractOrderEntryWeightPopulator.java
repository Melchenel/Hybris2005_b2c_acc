package de.hybris.anntraining.facades.populators;

import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;

import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.spockframework.util.Assert;

public class AbstractOrderEntryWeightPopulator implements Populator<AbstractOrderEntryModel, OrderEntryData> {

    @Override
    public void populate(AbstractOrderEntryModel source, OrderEntryData target) throws ConversionException {
        Assert.notNull(source, "source must not be null");
        Assert.notNull(target, "target must not be null");

        target.setWeight(source.getWeight());


    }
}
