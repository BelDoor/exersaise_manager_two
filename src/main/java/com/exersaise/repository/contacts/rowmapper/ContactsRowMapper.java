package com.exersaise.repository.contacts.rowmapper;

import com.exersaise.domain.Contacts;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.exersaise.repository.columns.ContactsColumns.CHANGED;
import static com.exersaise.repository.columns.ContactsColumns.CITY;
import static com.exersaise.repository.columns.ContactsColumns.COUNTRY;
import static com.exersaise.repository.columns.ContactsColumns.CREATED;
import static com.exersaise.repository.columns.ContactsColumns.DELETED;
import static com.exersaise.repository.columns.ContactsColumns.EMAIL;
import static com.exersaise.repository.columns.ContactsColumns.FLAT;
import static com.exersaise.repository.columns.ContactsColumns.HOUSE_NUMBER;
import static com.exersaise.repository.columns.ContactsColumns.ID;
import static com.exersaise.repository.columns.ContactsColumns.PHONE_NUMBER;
import static com.exersaise.repository.columns.ContactsColumns.STREET;
import static com.exersaise.repository.columns.ContactsColumns.USER_ID;

@Component
public class ContactsRowMapper implements RowMapper<Contacts> {
    @Override
    public Contacts mapRow(ResultSet rs, int rowNum){
        Contacts contacts;

        try {
            contacts = Contacts.builder()
                    .id(rs.getLong(ID))
                    .userId(rs.getLong(USER_ID))
                    .phoneNumber(rs.getLong(PHONE_NUMBER))
                    .email(rs.getString(EMAIL))
                    .city(rs.getString(CITY))
                    .country(rs.getString(COUNTRY))
                    .street(rs.getString(STREET))
                    .houseNumber(rs.getInt(HOUSE_NUMBER))
                    .flat(rs.getInt(FLAT))
                    .created((rs.getTimestamp(CREATED)))
                    .changed(rs.getTimestamp(CHANGED))
                    .deleted(rs.getBoolean(DELETED))
                    .build();
        } catch (SQLException e){
            throw new RuntimeException();
        }
        return contacts;
    }
}
