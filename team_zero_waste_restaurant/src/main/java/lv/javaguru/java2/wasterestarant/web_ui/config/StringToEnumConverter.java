package lv.javaguru.java2.wasterestarant.web_ui.config;

import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, UserRole> {

    @Override
    public UserRole convert(String source) {
        return UserRole.valueOf(source.toUpperCase());
    }
}
