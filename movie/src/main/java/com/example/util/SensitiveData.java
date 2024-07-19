package com.example.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SensitiveData {
    private Map<String, SensitiveFieldsType> fields;

    public SensitiveData(@Value("#{${application.sensitive.fields}}") Map<String, SensitiveFieldsType> fields) {
        this.fields = fields;
    }

    private static String mask(String field, SensitiveFieldsType type, String data) {
        String regex;
        if (type.equals(SensitiveFieldsType.NUMERIC))
            regex = field + "\":(\\w+)";
        else
            regex = field + "\":\"([^\"]*)\"";

        Matcher matcher = Pattern.compile(regex).matcher(data);
        if (matcher.find())
            return matcher.replaceAll(String.format("\\" + field + "\":\"(%dx)\"", matcher.group(1).length()));
        else return data;
    }

    public String mask(String data) {
        for (Map.Entry<String, SensitiveFieldsType> entry : fields.entrySet()) {
            data = mask(entry.getKey(), entry.getValue(), data);
        }
        return data;
    }
}

