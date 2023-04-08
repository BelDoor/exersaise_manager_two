package com.exercise.repository.user_rep;

import com.exercise.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
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
@Primary
public class UserRepositoryTemplate implements UserRepository {

   private final JdbcTemplate jdbcTemplate;

   private final NamedParameterJdbcTemplate nameParameterJdbcTemplate;

   private final UserRowMapper userRowMapper;

    @Override
    public Users findOne(Long id) {
        return jdbcTemplate.queryForObject("select * from users where id = " + id, userRowMapper);
    }

    @Override
    public List<Users> findAll() {
        return jdbcTemplate.query("select * from users order by id desc", userRowMapper);
    }

    @Override
    public Users create(Users object) {
        SqlParameterSource parametrs = new MapSqlParameterSource()
                .addValue("name", object.getName())
                .addValue("surname", object.getSurname())
                .addValue("dateBirth", object.getDateBirth())
                .addValue("sex", object.getSex())
                .addValue("height", object.getHeight())
                .addValue("role_id", object.getRoleId())
                .addValue("created", new Timestamp(System.currentTimeMillis()));

        KeyHolder holder = new GeneratedKeyHolder();

        String createUsersQuery = "INSERT INTO users(name, surname, date_birth, sex, height," +
                " role_id, created) VALUES (:name, :surname, :dateBirth, :sex, :height, :role_id, :created)";
         nameParameterJdbcTemplate.update(createUsersQuery, parametrs, holder);
         return findOne(2L);
    }

    @Override
    public Users update(Long id, Users object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Users getRandomUsers() {
        return null;
    }

    @Override
    public List<Users> searchUsers(String query, Integer height) {
        final String sqlQuery =
                "select * " +
                        " from users " +
                        " where name like '%" + query + "%' and " +
                        " height > " + height +
                        " order by id desc";

        return jdbcTemplate.query(sqlQuery, userRowMapper);
    }
}
