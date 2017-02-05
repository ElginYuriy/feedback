package ru.ubrr.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ubrr.feedback.model.Message;
import ru.ubrr.feedback.model.Theme;
import ru.ubrr.feedback.repository.MessageRepo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by elgin on 07.01.17.
 */
@Service
public class MessgeServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public List<Message> findAllThemeMessage(Long theme) {
        return messageRepo.findByMessageTheme(theme);
    }

    public int countNewMessage(Date lastVisit, Long userID) {
       return messageRepo.countAllNewMessageByDate(lastVisit, userID);
    }

    public void saveMessage(Message message) {
       messageRepo.save(message);
    }
}
