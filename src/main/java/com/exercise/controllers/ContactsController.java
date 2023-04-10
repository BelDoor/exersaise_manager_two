package com.exercise.controllers;

import com.exercise.domain.Contacts;
import com.exercise.service.contacts_ser.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ContactsController extends HttpServlet {

    @Autowired
    private ContactsService contactsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);;
    }

    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/contact");
        if(requestDispatcher != null){
            Contacts contacts = contactsService.getRandomContacts();

            req.setAttribute("randomContact", contacts);

            requestDispatcher.forward(req,resp);
        }
    }
}