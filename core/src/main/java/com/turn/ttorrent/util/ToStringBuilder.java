package com.turn.ttorrent.util;

import java.util.Collection;

/**
 * Created by jurgen on 6/03/15.
 */
public class ToStringBuilder {

    private final StringBuilder sb;

    public ToStringBuilder(Class c) {
        this.sb = new StringBuilder(c.getSimpleName());
    }

    public ToStringBuilder newLine(String key, Object value) {
        sb.append("\n")
                .append(key)
                .append("=")
                .append(safeToString(value));
        return this;
    }

    private String safeToString(Object value) {
        if (value == null)
            return null;
        if (value instanceof String)
            return (String) value;
        if (value instanceof Collection)
            return buildString((Collection) value);
        return value.toString();
    }

    private String buildString(Collection values) {
        String result = "[(#" + values.size() + ")";
        for (Object value : values) {
            result += "  " + value;
        }
        result += "]";
        return result;
    }

    public String buildString() {
        return sb.toString();
    }
}
