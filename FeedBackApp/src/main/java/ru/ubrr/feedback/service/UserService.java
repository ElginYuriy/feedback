package ru.ubrr.feedback.service;

import ru.ubrr.feedback.model.User;

/**
 *   Service class for {@link ru.ubrr.feedback.model.User}
 *
 * @author Yuriy Elgin
 * @version 1.0.
*/
public interface UserService{

    void saveUser(User user);

    User findByUserName(String userName);

    void updateUserLastVisitDate(User user);
}
