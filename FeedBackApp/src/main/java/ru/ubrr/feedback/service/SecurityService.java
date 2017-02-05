package ru.ubrr.feedback.service;

/**
 *  Service for Security
 *
 *  @author Yuriy Elgin
 *  @version 1.0.
 */
public interface SecurityService {

    String findLoggedInUserName();

    void autoLogin(String userName, String userPassword);
}
