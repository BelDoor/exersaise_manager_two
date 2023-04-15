package com.exersaise.controllers.mvc;

import com.exersaise.domain.Contacts;
import com.exersaise.service.contacts.ContactsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactsService contactsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAllContact(){

        List<Contacts> allContacts = contactsService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contact", allContacts);

        modelAndView.setViewName("contacts");

        return modelAndView;
    }

}
