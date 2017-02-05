package ru.ubrr.feedback.service;

import ru.ubrr.feedback.model.Theme;
import ru.ubrr.feedback.model.User;

import java.util.List;

/**
 * Created by elgin on 07.01.17.
 */

public interface ThemeService {

    List<Theme> findAllUserTheme(User user);

    Long saveTheme(Theme newTheme);

    void deleteThemeByID(Long themeID);

    Theme findThemeByID(Long themeID);
}

