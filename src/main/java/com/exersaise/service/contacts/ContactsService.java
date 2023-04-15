package com.exersaise.service.contacts;

import com.exersaise.domain.Contacts;

import java.util.List;

public interface ContactsService {
    Contacts findOne(Long id);

    Contacts findById(Long id);

    List<Contacts> findAll();

    Contacts create(Contacts object);

    Contacts update(Contacts object);

    void delete(Long id);

    List<Contacts> findContactsUserId(Long id);
    Boolean checkId(Long id);
}
