package ru.ubrr.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ubrr.feedback.model.Message;

import java.util.Date;
import java.util.List;

/**
 * Created by elgin on 07.01.17.
 */
public interface MessageRepo extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.messageTheme.themeID = :themeID order by m.messageDate desc")
    List<Message> findByMessageTheme(@Param("themeID") Long themeID);

    @Query("select count(m) from Message m  where m.messageDate > :lastDate" +
            " and m.messageTheme.themeID in (select t from Theme t where t.themeAuthor.userID = :userID)")
    int countAllNewMessageByDate(@Param("lastDate")Date lastVisit, @Param("userID") Long userID);
}
