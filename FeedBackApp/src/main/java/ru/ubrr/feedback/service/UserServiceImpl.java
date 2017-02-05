package ru.ubrr.feedback.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ubrr.feedback.model.Role;
import ru.ubrr.feedback.model.User;
import ru.ubrr.feedback.repository.RoleRepo;
import ru.ubrr.feedback.repository.UserRepo;

import java.util.Calendar;

import java.util.HashSet;
import java.util.Set;


/**
 * Implementation of {@link UserService}
 *
 * @author Yuriy Elgin
 * @version 1.0.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private BCryptPasswordEncoder bcEncoder;

    private static final Logger logger  = LoggerFactory.getLogger(UserServiceImpl.class);


    public void saveUser(User user) {


        user.setUserPassword(bcEncoder.encode(user.getUserPassword()));
        user.setCreationDate(Calendar.getInstance().getTime());
        user.setLastVisitDate(Calendar.getInstance().getTime());
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleRepo.findOne(1L));
        user.setUserRoles(roles);
        userRepo.save(user);

    }

    public User findByUserName(String userName) {
        User user = userRepo.findByUserName(userName);
        if(user == null) {
            logger.error("UserServiceImp => findByUserName: User not found ");
        } else {
            logger.info("UserServiceImp => findByUserName: Find user = " + user.getUserName());
        }
        return user;
    }

    @Transactional
    public void updateUserLastVisitDate(User user) {
        userRepo.updateLastVisitDate(user.getLastVisitDate(), user.getUserID());
    }
}
