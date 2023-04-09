package com.exersaise.repository.contacts;

import com.exersaise.domain.Contacts;
import com.exersaise.repository.contacts.rowmapper.ContactsRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContactsRepositoryImpl implements ContactsRepository{

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final ContactsRowMapper contactsRowMapper;

    public List<Contacts> findContactsUserId(Long id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);

        return namedParameterJdbcTemplate.query("SELECT u.name, u.surname," +
                        "par.weight, par.fat_percent, par.max_bench, par.max_squat, " +
                        "par.max_traction FROM users AS u JOIN parameters_gym AS par ON u.id = par.user_id WHERE u.id = (:id)",
                parameters, contactsRowMapper);
    }

    @Override
    public Contacts findOne(Long id) {
        return null;
    }

    @Override
    public List<Contacts> findAll() {
        return null;
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
}
