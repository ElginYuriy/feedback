package ru.ubrr.feedback.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by elgin on 06.01.17.
 */
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @Column(name = "theme_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long themeID;
    @Column(name = "theme_text")
    private String themeText;
    @Column(name = "theme_date")
    private Date themeDate;
    @Column(name = "theme_status")
    private String themeStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "author_id", nullable = false)
    private User themeAuthor;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "messageTheme")
    private Set<Message> themeMessages;
    @Transient
    private String firstMessage;
    @Transient
    private int countNewMessages;

    public Theme() {
    }

    public Long getThemeID() {
        return themeID;
    }

    public void setThemeID(Long themeID) {
        this.themeID = themeID;
    }

    public String getThemeText() {
        return themeText;
    }

    public void setThemeText(String themeText) {
        this.themeText = themeText;
    }

    public Date getThemeDate() {
        return themeDate;
    }

    public void setThemeDate(Date themeDate) {
        this.themeDate = themeDate;
    }

    public String getThemeStatus() {
        return themeStatus;
    }

    public void setThemeStatus(String themeStatus) {
        this.themeStatus = themeStatus;
    }

    public User getThemeAuthor() {
        return themeAuthor;
    }

    public void setThemeAuthor(User themeAuthor) {
        this.themeAuthor = themeAuthor;
    }

    public Set<Message> getThemeMessages() {
        return themeMessages;
    }

    public void setThemeMessages(Set<Message> themeMessages) {
        this.themeMessages = themeMessages;
    }

    public String getFirstMessage() {
        return firstMessage;
    }

    public void setFirstMessage(String firstMessage) {
        this.firstMessage = firstMessage;
    }

    public int getCountNewMessages() {
        return countNewMessages;
    }

    public void setCountNewMessages(int countNewMessages) {
        this.countNewMessages = countNewMessages;
    }
}
