package ru.ubrr.feedbackws.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by elgin on 22.01.17.
 */
@Entity
@Table(name = "processing")
@XmlRootElement(name = "answer")
public class ProcessingRequest {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestID;
    @Column(name = "theme_id", nullable = false)
    private Long themeID;
    @Column(name = "message_id", nullable = false)
    private Long messageID;
    @Column(name = "date_request")
    private Date dateRequest;
    @Column(name = "process_status")
    private String processStatus;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;
    @Column(name = "answer_date")
    private Date answerDate;

    public ProcessingRequest() {
    }

    public ProcessingRequest(Long requestID, Long themeID, Long messageID, Date dateRequest, String processStatus, String question, String answer, Date answerDate) {
        this.requestID = requestID;
        this.themeID = themeID;
        this.messageID = messageID;
        this.dateRequest = dateRequest;
        this.processStatus = processStatus;
        this.question = question;
        this.answer = answer;
        this.answerDate = answerDate;
    }

    public Long getRequestID() {
        return requestID;
    }

    public void setRequestID(Long requestID) {
        this.requestID = requestID;
    }

    public Long getThemeID() {
        return themeID;
    }

    public void setThemeID(Long themeID) {
        this.themeID = themeID;
    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }
}
