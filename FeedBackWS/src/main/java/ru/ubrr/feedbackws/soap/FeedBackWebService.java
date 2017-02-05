package ru.ubrr.feedbackws.soap;

import ru.ubrr.feedbackws.model.ProcessingRequest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;

/**
 * Created by elgin on 22.01.17.
 */

@WebService
public interface FeedBackWebService {

    @WebMethod
    ProcessingRequest getNewAnswer(@WebParam(name = "theme_id") Long themeID,
                                   @WebParam(name = "message_id") Long messageID,
                                   @WebParam(name = "answer_date") Date answerDate,
                                   @WebParam(name = "answer_text") String answerText);

    @WebMethod
    String askQuestions(@WebParam(name = "theme_id") Long themeID,
                        @WebParam(name = "message_id") Long messageID,
                        @WebParam(name = "message_text") String messText,
                        @WebParam(name = "question_date") Date questionDate);
}
