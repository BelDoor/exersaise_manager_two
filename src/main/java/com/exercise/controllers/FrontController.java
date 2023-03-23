package com.exercise.controllers;

import com.exercise.domain.Users;
import com.exercise.service.UsersService;
import com.exercise.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FrontController extends HttpServlet {

    @Autowired
    private  UsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/hello");
        if (dispatcher != null) {
            System.out.println("Forward will be done!");
            System.out.println("We are processing user request");

           List<Users> users = usersService.findAll();
            String collect = users.stream().map(Users::getName).collect(Collectors.joining(","));
            req.setAttribute("usersName", collect);
            req.setAttribute("users", users);
            dispatcher.forward(req, resp);
        }
    }
}
