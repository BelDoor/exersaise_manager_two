package com.exersaise.repository.contacts;

import com.exersaise.domain.Contacts;
import com.exersaise.repository.contacts.rowmapper.ContactsRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContactsRepositoryImpl implements ContactsRepository{

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final ContactsRowMapper contactsRowMapper;

    @Override
    public List<Contacts> findContactsUserId(Long id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);

        return namedParameterJdbcTemplate.query("SELECT * FROM contacts WHERE user_id = (:id)",
                parameters, contactsRowMapper);
    }

    @Override
    public Contacts findOne(Long id) {
        return null;
    }

    @Override
    public Contacts findById(Long id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);
        String sqlQuery = "SELECT * FROM contacts WHERE id = (:id)";

        return  namedParameterJdbcTemplate.queryForObject(sqlQuery, parameters, contactsRowMapper);
    }

    @Override
    public List<Contacts> findAll() {
        return jdbcTemplate.query("SELECT * FROM contacts ORDER BY id DESC", contactsRowMapper);
    }

    @Override
    public Contacts create(Contacts contacts) {
        SqlParameterSource parametrs = new MapSqlParameterSource()
                .addValue("user_id", contacts.getUserId())
                .addValue("phone_number", contacts.getPhoneNumber())
                .addValue("email", contacts.getEmail())
                .addValue("city", contacts.getCity())
                .addValue("country", contacts.getCountry())
                .addValue("street", contacts.getStreet())
                .addValue("house_number", contacts.getHouseNumber())
                .addValue("flat", contacts.getFlat())
                .addValue("created", new Timestamp(System.currentTimeMillis()));

        KeyHolder holder = new GeneratedKeyHolder();

        String createContactsQuery = "INSERT INTO contacts" +
                "(user_id, phone_number, email, city, country, street, house_number, flat, created)" +
                " VALUES (:user_id, :phone_number, :email, :city, :country, :street, :house_number, :flat, :created)";
        namedParameterJdbcTemplate.update(createContactsQuery, parametrs, holder);
        return findById(2L); //!!!! How to make the contact created by the thread from the database
    }

    @Override
    public Contacts update(Contacts contacts) {
        String sql = "UPDATE contacts SET (phone_number = (:phone_number), email = (:email)," +
                " city = (:city), country = (:country), street = (:street), house_number = (:house_number)," +
                " flat = (:flat), changed = (:changed) WHERE id = (:id))";

        SqlParameterSource parametrs = new MapSqlParameterSource()
                .addValue("user_id", contacts.getUserId())
                .addValue("phone_number", contacts.getPhoneNumber())
                .addValue("email", contacts.getEmail())
                .addValue("city", contacts.getCity())
                .addValue("country", contacts.getCountry())
                .addValue("street", contacts.getStreet())
                .addValue("house_number", contacts.getHouseNumber())
                .addValue("flat", contacts.getFlat())
                .addValue("changed", new Timestamp(System.currentTimeMillis()))
                .addValue("id", contacts.getId());

        KeyHolder holder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,parametrs,holder);
        return findById(contacts.getId());
    }

    @Override
    public void delete(Long id) {
       String sql = "UPDATE contacts SET is_deleted = (:deleted) WHERE id = (:id)";

        SqlParameterSource parametrs = new MapSqlParameterSource()
                .addValue("is_deleted",true)
                .addValue("id", id);

        KeyHolder holder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, parametrs, holder);
    }

    @Override
    public Boolean checkUserId(Long id) {
        String sql = "SELECT COUNT(*) FROM contacts WHERE user_id = (:id)";
        SqlParameterSource parameter = new MapSqlParameterSource("id", id);

        Integer x = namedParameterJdbcTemplate.queryForObject(sql, parameter, Integer.class);

        return x > 0;
    }

    @Override
    public Boolean checkId(Long id) {
        String sql = "SELECT COUNT(*) FROM contacts WHERE id = (:id)";
        SqlParameterSource parameter = new MapSqlParameterSource("id", id);

        Integer x = namedParameterJdbcTemplate.queryForObject(sql, parameter, Integer.class);

            return x > 0;
    }
}
