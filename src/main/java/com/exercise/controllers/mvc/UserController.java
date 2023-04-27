package com.exercise.controllers.mvc;

import com.exercise.domain.Users;
import com.exercise.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//@Controller
@RequiredArgsConstructor
//@RequestMapping( "users")
public class UserController {

    private final UsersService usersService;

    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAllUsers() {

        List<Users> users = usersService.findAll();

        String collect = users.stream().map(Users::getName).collect(Collectors.joining(","));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", collect);
        modelAndView.addObject("users", users);

        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findUserId(@PathVariable String id) {

        Long personId;

        try {
            personId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            logger.error("User id: " + id + " cannot be parsed to Long", e);
            personId = 1L;
        }

        Users users = usersService.findOne(personId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", users.getName() + " " + users.getSurname());
        modelAndView.addObject("users", Collections.singletonList(users));

        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchUserByParam(@RequestParam("query") String query,
                                          @RequestParam("height") String height) {

        Integer parsedHeight;

        try {
            parsedHeight = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            logger.error("User height: " + height + " cannot be parsed to Long", e);
            parsedHeight = 300;
        }

      List<Users> usersList = usersService.searchUsers(query, parsedHeight);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", usersList.get(1).getName());
        modelAndView.addObject("users", usersList);

        modelAndView.setViewName("hello");

        return modelAndView;
    }


}
