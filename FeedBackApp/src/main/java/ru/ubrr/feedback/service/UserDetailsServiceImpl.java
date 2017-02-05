package ru.ubrr.feedback.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ubrr.feedback.model.Role;
import ru.ubrr.feedback.model.User;
import ru.ubrr.feedback.repository.UserRepo;

import java.util.HashSet;
import java.util.Set;

/**
 *  Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService}.
 *
 *  @author Yuriy Elgin
 *  @version 1.0.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(userName);
         if(user != null) {
             Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
             for (Role role : user.getUserRoles()) {
                 grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
             }
             return new org.springframework.security.core.userdetails.User(user.getUserName(),
                     user.getUserPassword(), grantedAuthorities);
         } else {
             logger.error("User: " + userName + " not found in DB");
             return null;
         }
    }

}
