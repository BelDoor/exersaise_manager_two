package com.exercise.repository.contacts_rep;

import com.exercise.configuration.DataBaseProperties;
import com.exercise.domain.Contacts;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.exercise.repository.columns.ContactsColumns.ID;
import static com.exercise.repository.columns.ContactsColumns.USER_ID;
import static com.exercise.repository.columns.ContactsColumns.CITY;
import static com.exercise.repository.columns.ContactsColumns.COUNTRY;
import static com.exercise.repository.columns.ContactsColumns.STREET;
import static com.exercise.repository.columns.ContactsColumns.HOUSE_NUMBER;
import static com.exercise.repository.columns.ContactsColumns.FLAT;
import static com.exercise.repository.columns.ContactsColumns.PHONE_NUMBER;
import static com.exercise.repository.columns.ContactsColumns.EMAIL;

@Repository
@RequiredArgsConstructor
public class ContactsRepositoryImpl implements ContactsRepository {

    private final DataBaseProperties dataBaseProperties;

    private void registredDriver() {
        try {
            Class.forName(dataBaseProperties.getPostgresDriverName());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        String jdbcURL = StringUtils.join(dataBaseProperties.getUrl(),
                dataBaseProperties.getPort(), dataBaseProperties.getName());
        try {
            return DriverManager.getConnection(jdbcURL, dataBaseProperties.getLogin(),
                    dataBaseProperties.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Contacts parseResultContacts(ResultSet rs) {
        Contacts contacts;

        try {
            contacts = new Contacts();
            contacts.setId(rs.getLong(ID));
            contacts.setUserId(rs.getLong(USER_ID));
            contacts.setCountry(rs.getString(CITY));
            contacts.setCity(rs.getString(COUNTRY));
            contacts.setStreet(rs.getString(STREET));
            contacts.setHouseNumber(rs.getInt(HOUSE_NUMBER));
            contacts.setFlat(rs.getInt(FLAT));
            contacts.setPhoneNumber(rs.getLong(PHONE_NUMBER));
            contacts.setEmail(rs.getString(EMAIL));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contacts;
    }

    @Override
    public Contacts findOne(Long id) {
        return null;
    }

    @Override
    public List<Contacts> findAll() {
        final String findAllQuery = "select * from users order by id desc";

        List<Contacts> result = new ArrayList<>();

        registredDriver();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findAllQuery)) {

            while (rs.next()) {
                result.add(parseResultContacts(rs));
            }

            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public Contacts create(Contacts object) {
        return null;
    }

    @Override
    public Contacts update(Long id, Contacts object) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Contacts getRandomContacts() {
        final String findRandomQuery = "SELECT * FROM contacts\n" +
                "ORDER BY RANDOM()\n" +
                "LIMIT 1";

        Contacts contacts = null;

        registredDriver();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findRandomQuery)) {

            while (rs.next()) {
                contacts = parseResultContacts(rs);
            }

            return contacts;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }
}

