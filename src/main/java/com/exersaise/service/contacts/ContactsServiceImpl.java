package com.exersaise.service.contacts;

import com.exersaise.domain.Contacts;
import com.exersaise.repository.contacts.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService{

    private final ContactsRepository contactsRepository;

    @Override
    public Contacts findOne(Long id) {
        if(contactsRepository.checkId(id)){
            return contactsRepository.findOne(id);
        }
        return null;
    }

    @Override
    public Contacts findById(Long id) {
        if(contactsRepository.checkId(id)){
            return contactsRepository.findById(id);
        }

        throw new RuntimeException();
    }

    @Override
    public List<Contacts> findAll() {
        return contactsRepository.findAll();
    }

    @Override
    public Contacts create(Contacts object) {
        return contactsRepository.create(object);
    }

    @Override
    public Contacts update(Contacts object) {
        return contactsRepository.update(object);
    }

    @Override
    public void delete(Long id) {
        if(!contactsRepository.checkId(id)){
            throw new RuntimeException();
        }
        contactsRepository.delete(id);
    }

    @Override
    public List<Contacts> findContactsUserId(Long id) {
        if(!contactsRepository.checkUserId(id)){
            throw new RuntimeException();
        }
        return contactsRepository.findContactsUserId(id);
    }

    @Override
    public Boolean checkId(Long id) {
        return contactsRepository.checkId(id);
    }
}
