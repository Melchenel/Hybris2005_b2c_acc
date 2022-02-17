package de.hybris.anntraining.facades.storefinder.populators;

import de.hybris.anntraining.core.enums.DiscontinuedStatus;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

import java.util.ArrayList;
import java.util.Optional;

public class SearchResultDiscontinuedStatusPopulator extends SearchResultVariantProductPopulator {

    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        super.populate(source, target);

        final String status = Optional.ofNullable(((ArrayList<String>)this.getValue(source, "discontinuedStatus")).get(0)).orElse("D0");
        target.setDiscontinuedStatus(DiscontinuedStatus.valueOf(status));

    }
}
