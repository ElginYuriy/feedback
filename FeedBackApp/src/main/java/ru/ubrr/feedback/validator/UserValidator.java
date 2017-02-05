package ru.ubrr.feedback.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.ubrr.feedback.model.User;
import ru.ubrr.feedback.service.UserService;

/**
 *  Validator for {@link ru.ubrr.feedback.model.User} class
 *
 *  @author Yuriy Elgin
 *  @version 1.0.
 *
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Required");

        if(userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "Required");

        if(!user.getConfirmUserPassword().equals(user.getUserPassword())) {
            errors.rejectValue("confirmUserPassword", "Different.userForm.password");

        }


    }
}
