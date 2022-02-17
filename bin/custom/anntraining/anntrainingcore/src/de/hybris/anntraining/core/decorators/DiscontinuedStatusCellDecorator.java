package de.hybris.anntraining.core.decorators;

import de.hybris.platform.util.CSVCellDecorator;
import io.netty.util.internal.StringUtil;


import java.util.Map;

public class DiscontinuedStatusCellDecorator implements CSVCellDecorator {

    private static final String PREFIX = "D";

    @Override
    public String decorate(int i, Map<Integer, String> map) {
        final String csvCell = map.get(i);
        if (StringUtil.isNullOrEmpty(csvCell) || csvCell.contains(PREFIX)) {
            return csvCell;
        }

        return PREFIX + csvCell;
    }
}
