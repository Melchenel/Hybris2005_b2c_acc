package de.hybris.anntraining.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.spockframework.util.Assert;

public class DiscontinuesStatusProductPopulator implements Populator<ProductModel, ProductData> {


    @Override
    public void populate(ProductModel source, ProductData target) throws ConversionException {
        Assert.notNull(source);
        Assert.notNull(target);

        target.setDiscontinuedStatus(source.getDiscontinuedStatus());

    }
}