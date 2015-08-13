package com.compareglobal.service.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IsInHelper implements Helper<Object> {

    public static final Helper<Object> INSTANCE = new IsInHelper();
    /**
     * TThe Handlebars helper
     */
    public static final String NAME = "isIn";
    private static final String FILTER = "filter";

    @Override
    public CharSequence apply(Object context, Options options) throws IOException {
        if (options.isFalsy(context)) {
            return options.inverse();
        } else {
            String filter =  String.valueOf(options.hash.get(FILTER));
            if (StringUtils.isNotBlank(filter)) {
                List<String> filters = Arrays.asList(StringUtils.split(filter,","));
                List<String> sanitizedFilters = new ArrayList<>();
                for (String filterString : filters) {
                    sanitizedFilters.add(StringUtils.trim(filterString));
                }

                if (CollectionUtils.isNotEmpty(filters)
                        && sanitizedFilters.contains(context)) {
                    return options.fn();
                }
            }

            return options.inverse();
        }
    }
}
