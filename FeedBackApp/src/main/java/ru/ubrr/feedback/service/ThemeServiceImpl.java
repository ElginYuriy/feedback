package ru.ubrr.feedback.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ubrr.feedback.model.Theme;
import ru.ubrr.feedback.model.User;
import ru.ubrr.feedback.repository.ThemeRepo;

import java.util.Calendar;
import java.util.List;

/**
 * Created by elgin on 07.01.17.
 */
@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeRepo themeRepo;


    public List<Theme> findAllUserTheme(User user) {
        return themeRepo.findByThemeAuthor(user.getUserID());
    }

    public Long saveTheme(Theme newTheme) {
        newTheme.setThemeDate(Calendar.getInstance().getTime());
        newTheme.setThemeStatus("open");

        themeRepo.save(newTheme);
        return newTheme.getThemeID();
    }

    public void deleteThemeByID(Long themeID) {
        themeRepo.delete(themeID);
    }

    public Theme findThemeByID(Long themeID) {
        return themeRepo.findOne(themeID);
    }
}
