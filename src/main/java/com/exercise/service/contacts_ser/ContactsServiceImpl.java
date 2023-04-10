package com.exercise.service.contacts_ser;

import com.exercise.domain.Contacts;
import com.exercise.repository.contacts_rep.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    @Override
    public Contacts findOne(Long id) {
        if (id > 0) {
            return contactsRepository.findOne(id);
        } else {
            System.err.println("id < 0");
            return null;
        }
    }

    @Override
    public List<Contacts> findAll() {
        return contactsRepository.findAll();
    }

    @Override
    public Contacts create(Contacts object) {
        return null;
    }

    @Override
    public Contacts update(Contacts object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public Contacts getRandomContacts() {
        return contactsRepository.getRandomContacts();
    }
}
