package ru.ubrr.feedback.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by elgin on 07.01.17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageID;
    @Column(name = "message_text")
    private String messageText;
    @Column(name = "message_date")
    private Date messageDate;
    @Column(name = "message_direction")
    private String messageDirection;
    @Column(name = "message_status")
    private String messageStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "parent_theme", nullable = false)
    private Theme messageTheme;

    public Message() {
    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageDirection() {
        return messageDirection;
    }

    public void setMessageDirection(String messageDirection) {
        this.messageDirection = messageDirection;
    }

    public Theme getMessageTheme() {
        return messageTheme;
    }

    public void setMessageTheme(Theme messageTheme) {
        this.messageTheme = messageTheme;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
}
