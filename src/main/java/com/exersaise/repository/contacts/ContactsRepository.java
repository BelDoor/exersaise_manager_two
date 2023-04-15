package com.exersaise.repository.contacts;

import com.exersaise.domain.Contacts;
import com.exersaise.repository.CRUDRepository;

import java.util.List;

public interface ContactsRepository extends CRUDRepository<Long, Contacts> {
    Boolean checkUserId(Long id);
    Boolean checkId(Long id);
    List<Contacts> findContactsUserId(Long id);
}
