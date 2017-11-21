package com.web.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.security.service.UserService;

/**
 * @author Matyas_Perneky
 */
@Controller
@Service
@Transactional
public class RegistrationController {
    private final String CREATE_USER_QUERY = "INSERT INTO Users(sso_id, password, first_name, last_name, email, state) VALUES('%s', '%s', '%s', '%s', '%s', 'Active')";
    private final String USER_PROFILE_QUERY = "INSERT INTO UsersProfile(user_id, user_profile_id) SELECT user.id, profile.id FROM Users user, Roles"
        + " profile where user.sso_id='%s' and profile.type='USER';";

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationForm(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(
        @RequestParam(value = "ssoId", required = true) final String username,
        @RequestParam(value = "password", required = true) final String password,
        @RequestParam(value = "firstName", required = true) final String firstName,
        @RequestParam(value = "lastName", required = true) final String lastName,
        @RequestParam(value = "email", required = true) final String email,
        Model model) {
        String result;
        if(userService.findBySso(username) != null){
            result = "redirect:/registration?error";
        } else {
            Session session = sessionFactory.getCurrentSession();
            Query userQuery = session.createSQLQuery(String.format(CREATE_USER_QUERY, username, password, firstName, lastName, email));
            Query profileQuery = session.createSQLQuery(String.format(USER_PROFILE_QUERY, username));
            userQuery.executeUpdate();
            profileQuery.executeUpdate();
            result = "redirect:/login";
        }


        return result;
    }
}
