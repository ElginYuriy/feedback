package ru.ubrr.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ubrr.feedback.model.Message;
import ru.ubrr.feedback.model.Theme;
import ru.ubrr.feedback.model.User;
import ru.ubrr.feedback.service.MessageService;
import ru.ubrr.feedback.service.SecurityService;
import ru.ubrr.feedback.service.ThemeService;
import ru.ubrr.feedback.service.UserService;
import ru.ubrr.feedback.validator.MessageValidator;
import ru.ubrr.feedback.validator.ThemeValidator;
import ru.ubrr.feedback.validator.UserValidator;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Yuriy Elgin
 * @version 1.0.
 */
@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private ThemeService themeService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ThemeValidator themeValidator;

    @Autowired
    private MessageValidator messageValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(userForm);
        securityService.autoLogin(userForm.getUserName(), userForm.getConfirmUserPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Username or passowrd is incorrect.");
        }

        if(logout != null){
            model.addAttribute("message", "Logout successfully");
        }

        return "/login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, HttpSession session) {
         User currentUser = userService.findByUserName(securityService.findLoggedInUserName());
        if(currentUser == null) {
            return "redirect:/login";
        }
        int count = messageService.countNewMessage(currentUser.getLastVisitDate(), currentUser.getUserID());
        if(session.getAttribute("currentUser") == null) {
            session.setAttribute("currentUser", currentUser);
            session.setAttribute("lastVisit", currentUser.getLastVisitDate().toString());
            currentUser.setLastVisitDate(Calendar.getInstance().getTime());
            userService.updateUserLastVisitDate(currentUser);
        }
        model.addAttribute("newMessages", count);
        return "welcome";
    }
    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String feedback(Model model) {
        User currentUser = userService.findByUserName(securityService.findLoggedInUserName());
        if(currentUser == null) {
            return "redirect:/login";
        }
        List<Theme> themeList = themeService.findAllUserTheme(currentUser);
        model.addAttribute("themeForm",   new Theme());
        model.addAttribute("themeList", themeList);
        return "feedback";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public String feedback(@ModelAttribute("themeForm") Theme themeForm,BindingResult bindingResult, Model model) {
        User currentUser = userService.findByUserName(securityService.findLoggedInUserName());
        if(currentUser == null) {
            return "redirect:/login";
        }
        themeValidator.validate(themeForm, bindingResult);
        if(bindingResult.hasErrors()) {
            return "feedback";
        }
        themeForm.setThemeAuthor(currentUser);
        themeService.saveTheme(themeForm);
        Message newMessage = new Message();
        newMessage.setMessageTheme(themeForm);
        newMessage.setMessageText(themeForm.getFirstMessage());
        newMessage.setMessageDate(Calendar.getInstance().getTime());
        newMessage.setMessageDirection("out");
        newMessage.setMessageStatus("send");
        messageService.saveMessage(newMessage);

        return "redirect:/feedback";
    }

    @RequestMapping(value = "/messages-{themeID}", method = RequestMethod.GET)
    public String messages(@PathVariable("themeID")  Long themeID, Model model) {
        User currentUser = userService.findByUserName(securityService.findLoggedInUserName());
        if(currentUser == null) {
            return "redirect:/login";
        }
        List<Message> messageList = messageService.findAllThemeMessage(themeID);
        model.addAttribute("messageForm", new Message());
        model.addAttribute("messageList", messageList);
        return "messages";
    }

    @RequestMapping(value = "/messages-{themeID}", method = RequestMethod.POST)
    public String messages(@PathVariable("themeID")  Long themeID, @ModelAttribute("messageForm") Message messageForm,
                                                     BindingResult bindingResult, Model model) {
        User currentUser = userService.findByUserName(securityService.findLoggedInUserName());
        if(currentUser == null) {
            return "redirect:/login";
        }

        messageValidator.validate(messageForm, bindingResult);
        if(bindingResult.hasErrors()) {
            return "messages";
        }


        messageForm.setMessageTheme(themeService.findThemeByID(themeID));
        messageForm.setMessageDate(Calendar.getInstance().getTime());
        messageForm.setMessageDirection("out");
        messageForm.setMessageStatus("send");
        messageService.saveMessage(messageForm);


        return "redirect:/messages-" + themeID.toString();
    }


    @RequestMapping(value = {"/messages"}, method = RequestMethod.GET)
    public String messages(Model model) {
       model.addAttribute("messageForm", new Message());
       return "messages";
    }

    @RequestMapping(value = "/delete-{themeID}", method = RequestMethod.GET)
    public String delete(@PathVariable("themeID")  Long themeID, Model model) {
        themeService.deleteThemeByID(themeID);
        return "redirect:/feedback";
    }



}
