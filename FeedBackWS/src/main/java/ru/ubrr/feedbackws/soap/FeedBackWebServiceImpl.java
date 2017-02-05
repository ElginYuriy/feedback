package ru.ubrr.feedbackws.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.ubrr.feedbackws.model.ProcessingRequest;
import ru.ubrr.feedbackws.repository.ProcessingRequestRepo;

import javax.jws.WebService;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by elgin on 22.01.17.
 */

@WebService(endpointInterface = "ru.ubrr.feedbackws.soap.FeedBackWebService",
 serviceName = "FeedBackWebServiceImp")
public class FeedBackWebServiceImpl implements FeedBackWebService {

    @Autowired
    private ProcessingRequestRepo processing;


    @Override
    public ProcessingRequest getNewAnswer(Long themeID, Long messageID, Date answerDate, String answerText) {

        return null;
    }

    @Override
    @Transactional
    public String askQuestions(Long themeID, Long messageID, String messText, Date questionDate) {
        ProcessingRequest pr = new ProcessingRequest();
        pr.setThemeID(themeID);
        pr.setMessageID(messageID);
        pr.setQuestion(messText);
        pr.setProcessStatus("new");

        pr.setDateRequest(questionDate);
        processing.save(pr);
        return pr.getRequestID().toString();
    }
}
