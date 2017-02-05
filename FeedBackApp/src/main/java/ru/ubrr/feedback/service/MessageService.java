package ru.ubrr.feedback.service;

import ru.ubrr.feedback.model.Message;
import ru.ubrr.feedback.model.Theme;

import java.util.Date;
import java.util.List;

/**
 * Created by elgin on 07.01.17.
 */
public interface MessageService {
    List<Message> findAllThemeMessage(Long theme);
    int countNewMessage(Date lastVisit, Long userID);
    void saveMessage(Message message);
}
