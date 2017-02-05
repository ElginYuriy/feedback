package ru.ubrr.feedback.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.ubrr.feedback.model.Message;

import ru.ubrr.feedback.service.MessageService;


/**
 * Created by elgin on 08.01.17.
 */
@Component
public class MessageValidator implements Validator {
    @Autowired
    private MessageService messageService;

    public boolean supports(Class<?> aClass) {
        return Message.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Message theme = (Message) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageText", "Required");

    }
}
