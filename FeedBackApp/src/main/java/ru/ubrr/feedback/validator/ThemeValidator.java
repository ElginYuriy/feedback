package ru.ubrr.feedback.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.ubrr.feedback.model.Theme;
import ru.ubrr.feedback.service.ThemeService;

/**
 * Created by elgin on 08.01.17.
 */
@Component
public class ThemeValidator implements Validator {

   @Autowired
    private ThemeService themeService;

    public boolean supports(Class<?> aClass) {
        return Theme.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Theme theme = (Theme) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "themeText", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstMessage", "Required");

    }
}
