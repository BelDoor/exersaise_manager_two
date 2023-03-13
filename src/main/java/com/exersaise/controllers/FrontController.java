package com.exersaise.controllers;

import com.exersaise.domain.Users;
import com.exersaise.service.UsersService;
import com.exersaise.service.UsersServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class FrontController extends HttpServlet {

    private final UsersService usersService = new UsersServiceImpl();

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
