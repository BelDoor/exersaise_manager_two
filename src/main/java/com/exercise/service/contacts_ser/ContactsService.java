package com.exercise.service.contacts_ser;

import com.exercise.domain.Contacts;

import java.util.List;

public interface ContactsService {
    Contacts findOne(Long id);
    List<Contacts> findAll();
    Contacts create(Contacts object);
    Contacts update(Contacts object);
    void delete(Long id);
    Contacts getRandomContacts();
}
