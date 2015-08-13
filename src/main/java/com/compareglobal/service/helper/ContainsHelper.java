package com.compareglobal.service.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ContainsHelper implements Helper<Object> {

    public static final Helper<Object> INSTANCE = new ContainsHelper();
    /**
     * The Handlebars helper
     */
    public static final String NAME = "contains";
    private static final String KEYWORDS = "keyword";

    @Override
    public CharSequence apply(Object context, Options options) throws IOException {
        if (options.isFalsy(context)) {
            return options.inverse();
        } else {
            String keywords =  String.valueOf(options.hash.get(KEYWORDS))
                                     .toUpperCase();
            if (StringUtils.isNotBlank(keywords)) {
                String stringContext = context.toString().toUpperCase();
                List<String> keywordsList = Arrays.asList(keywords.split(","));
                for (String keyword : keywordsList) {
                    if (StringUtils.contains(stringContext, keyword.trim())) {
                        return options.fn();
                    }
                }
            }
            return options.inverse();
        }
    }
}