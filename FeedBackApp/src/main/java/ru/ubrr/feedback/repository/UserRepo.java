package ru.ubrr.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ubrr.feedback.model.User;

import java.util.Date;

/**
 * @author Yuriy Elgin
 * @version 1.0.
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    @Modifying
    @Query("update User set lastVisitDate = :lastVisit where userID = :userID")
    void updateLastVisitDate(@Param("lastVisit")Date lastVisit, @Param("userID") Long userID);
}
