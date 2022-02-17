package de.hybris.anntraining.core.search.solrfacetsearch.provider.impl;

import de.hybris.anntraining.core.enums.DiscontinuedStatus;
import de.hybris.platform.core.HybrisEnumValue;

import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractFacetValueDisplayNameProvider;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;
import org.springframework.beans.factory.annotation.Required;

import java.util.Locale;

public class DiscontinuedStatusDisplayNameProvider extends AbstractFacetValueDisplayNameProvider {

    private EnumerationService enumerationService;
    private I18NService i18nService;
    private CommonI18NService commonI18NService;

    @Override
    public String getDisplayName(final SearchQuery query, final IndexedProperty property, final String facetValue)
    {
        if (facetValue == null)
        {
            return "";
        }

        final HybrisEnumValue discontinuedStatusValue = getEnumerationService().getEnumerationValue(DiscontinuedStatus.class, facetValue);

        Locale queryLocale = null;
        if (query == null || query.getLanguage() == null || query.getLanguage().isEmpty())
        {
            queryLocale = getI18nService().getCurrentLocale();
        }

        if (queryLocale == null && query != null)
        {
            queryLocale = getCommonI18NService().getLocaleForLanguage(getCommonI18NService().getLanguage(query.getLanguage()));
        }


        String name = getEnumerationService().getEnumerationName(discontinuedStatusValue, queryLocale);

        if (name == null || name.isEmpty())
        {
            switch (facetValue){
                case "D0":
                    name = "Product is available for sale";
                    break;
                case "D1":
                    name = "Sale remainders";
                    break;
                case "D2":
                    name = "Product is available for booking";
                    break;
                default:
                    name = "Product is available for sale";
                    break;
            }

        }

        return name;
    }

    protected EnumerationService getEnumerationService()
    {
        return enumerationService;
    }

    @Required
    public void setEnumerationService(final EnumerationService enumerationService)
    {
        this.enumerationService = enumerationService;
    }

    protected I18NService getI18nService()
    {
        return i18nService;
    }

    @Required
    public void setI18nService(final I18NService i18nService)
    {
        this.i18nService = i18nService;
    }

    protected CommonI18NService getCommonI18NService()
    {
        return commonI18NService;
    }

    @Required
    public void setCommonI18NService(final CommonI18NService commonI18NService)
    {
        this.commonI18NService = commonI18NService;
    }
}
