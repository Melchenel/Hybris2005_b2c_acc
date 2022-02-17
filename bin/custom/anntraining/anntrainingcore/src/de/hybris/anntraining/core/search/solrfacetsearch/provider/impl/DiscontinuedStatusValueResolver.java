package de.hybris.anntraining.core.search.solrfacetsearch.provider.impl;

import de.hybris.anntraining.core.enums.DiscontinuedStatus;
import de.hybris.platform.core.enums.Gender;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;

import de.hybris.platform.solrfacetsearch.provider.impl.AbstractValueResolver;

public class DiscontinuedStatusValueResolver extends AbstractValueResolver<ProductModel, Object, Object> {

    @Override
    protected void addFieldValues(final InputDocument inputDocument, final IndexerBatchContext indexerBatchContext,
                                  final IndexedProperty indexedProperty, final ProductModel product,
                                  final ValueResolverContext<Object, Object> resolverContext) throws FieldValueProviderException {

        inputDocument.addField(indexedProperty, product.getDiscontinuedStatus().toString(), resolverContext.getFieldQualifier());
    }

}
