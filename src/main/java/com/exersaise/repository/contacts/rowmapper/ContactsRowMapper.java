package com.exersaise.repository.contacts.rowmapper;

import com.exersaise.domain.Contacts;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.exersaise.repository.columns.ContactsColumns.CITY;
import static com.exersaise.repository.columns.ContactsColumns.COUNTRY;
import static com.exersaise.repository.columns.ContactsColumns.EMAIL;
import static com.exersaise.repository.columns.ContactsColumns.FLAT;
import static com.exersaise.repository.columns.ContactsColumns.HOUSE_NUMBER;
import static com.exersaise.repository.columns.ContactsColumns.PHONE_NUMBER;
import static com.exersaise.repository.columns.ContactsColumns.STREET;
import static com.exersaise.repository.columns.ContactsColumns.USER_ID;

@Component
public class ContactsRowMapper implements RowMapper<Contacts> {
    @Override
    public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contacts contacts;

        try {
            contacts = Contacts.builder()
                    .userId(rs.getLong(USER_ID))
                    .phoneNumber(rs.getLong(PHONE_NUMBER))
                    .email(rs.getString(EMAIL))
                    .city(rs.getString(CITY))
                    .country(rs.getString(COUNTRY))
                    .street(rs.getString(STREET))
                    .houseNumber(rs.getString(HOUSE_NUMBER))
                    .flat(rs.getInt(FLAT))
                    .build();
        } catch (SQLException e){
            throw new RuntimeException();
        }
        return contacts;
    }
}
