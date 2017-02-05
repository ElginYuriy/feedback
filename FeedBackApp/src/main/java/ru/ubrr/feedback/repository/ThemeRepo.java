package ru.ubrr.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ubrr.feedback.model.Theme;
import ru.ubrr.feedback.model.User;

import java.util.List;

/**
 * Created by elgin on 07.01.17.
 */
public interface ThemeRepo extends JpaRepository<Theme, Long> {
    @Query("select t from Theme t where t.themeAuthor.userID = :userID ")
    List<Theme> findByThemeAuthor(@Param("userID") Long id);
}
