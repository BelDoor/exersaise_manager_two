package com.exercise.repository.user_rep;

import com.exercise.domain.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.exercise.repository.columns.UsersColumns.DATE_BIRTH;
import static com.exercise.repository.columns.UsersColumns.HEIGHT;
import static com.exercise.repository.columns.UsersColumns.ID;
import static com.exercise.repository.columns.UsersColumns.NAME;
import static com.exercise.repository.columns.UsersColumns.ROLE_ID;
import static com.exercise.repository.columns.UsersColumns.SEX;
import static com.exercise.repository.columns.UsersColumns.SURNAME;

@Component
public class UserRowMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();

        user.setId(rs.getLong(ID));
        user.setName(rs.getString(NAME));
        user.setSurname(rs.getString(SURNAME));
        user.setDateBirth(rs.getTimestamp(DATE_BIRTH));
        user.setSex(rs.getString(SEX));
        user.setHeight(rs.getInt(HEIGHT));
        user.setRoleId(rs.getLong(ROLE_ID));

        return user;
    }
}
