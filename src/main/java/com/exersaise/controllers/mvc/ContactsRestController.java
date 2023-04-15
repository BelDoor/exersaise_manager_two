package com.exersaise.controllers.mvc;

import com.exersaise.controllers.requests.ContactsCreateRequest;
import com.exersaise.domain.Contacts;
import com.exersaise.service.contacts.ContactsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/contacts")
@RequiredArgsConstructor
public class ContactsRestController {

private final ContactsService contactsService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<Contacts> listContact = contactsService.findAll();
        return new ResponseEntity<>(listContact, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contacts> createContact(@RequestBody ContactsCreateRequest contactsCreateRequest){
        Contacts contacts = Contacts.builder()
                .userId(contactsCreateRequest.getUserId())
                .phoneNumber(contactsCreateRequest.getPhoneNumber())
                .email(contactsCreateRequest.getEmail())
                .city(contactsCreateRequest.getCity())
                .country(contactsCreateRequest.getCountry())
                .street(contactsCreateRequest.getStreet())
                .houseNumber(contactsCreateRequest.getHouseNumber())
                .flat(contactsCreateRequest.getFlat())
                .build();

        Contacts createContacts = contactsService.create(contacts);
        return new ResponseEntity<>(createContacts, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/true", method = RequestMethod.GET)
    public ResponseEntity<Object> checkId() {
       Boolean valid = contactsService.checkId(3L);
        return new ResponseEntity<>(valid, HttpStatus.OK);
    }


}
