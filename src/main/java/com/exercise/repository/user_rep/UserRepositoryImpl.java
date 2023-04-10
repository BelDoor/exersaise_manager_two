package com.exercise.repository.user_rep;

import com.exercise.domain.Contacts;
import com.exercise.domain.Users;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public static final String POSTGRES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "/exercise_manager";
    public static final String DATABASE_LOGIN = "pablito";
    public static final String DATABASE_PASSWORD = "pablito";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String DATE_BIRTH = "date_birth";
    private static final String SEX = "sex";
    private static final String HEIGHT = "height";
    private static final String ROLE_ID = "role_id";

    private void registredDriver() {
        try {
            Class.forName(POSTGRES_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    private Connection getConnection() {
        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);
        try {
            return DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Users parseResultSet(ResultSet rs) {
        Users user;

        try {
            user = new Users();
            user.setId(rs.getLong(ID));
            user.setName(rs.getString(NAME));
            user.setSurname(rs.getString(SURNAME));
            user.setDateBirth(rs.getTimestamp(DATE_BIRTH));
            user.setSex(rs.getString(SEX));
            user.setHeight(rs.getInt(HEIGHT));
            user.setRoleId(rs.getLong(ROLE_ID));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<Users> findAll() {
        final String findAllQuery = "select * from users order by name desc";

        List<Users> result = new ArrayList<>();

        registredDriver();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findAllQuery)) {

            while (rs.next()) {
                result.add(parseResultSet(rs));
            }

            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public Users findOne(Long id) {
        String findOneQuery = "SELECT * FROM users WHERE id = ?";

        Users user;

        registredDriver();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findOneQuery)) {

            try {
                connection.setAutoCommit(false);

                preparedStatement.setLong(1, id);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
            }

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = parseResultSet(rs);
                return user;
            } else {
                throw new SQLException("I can not find id ->" + id);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public Users create(Users object) {
        String createUsersQuery = "INSERT INTO users(name, surname, date_birth, sex, height," +
                " role_id, created, is_deleted) VALUES (?,?,?,?,?,?,?,?)";

        Users userNewCreated = null;

        registredDriver();
        try (Connection connection = getConnection();
             PreparedStatement createStatment = connection.prepareStatement(createUsersQuery, new String[]{"id"})) {

            createStatment.setString(1, object.getName());
            createStatment.setString(2, object.getSurname());
            createStatment.setTimestamp(3, object.getDateBirth());
            createStatment.setString(4, object.getSex());
            createStatment.setInt(5, object.getHeight());
            createStatment.setLong(6, object.getRoleId());
            createStatment.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            createStatment.setBoolean(8, false);
            createStatment.executeUpdate();

            ResultSet rs = createStatment.getGeneratedKeys();

            if (rs.next()) {
                userNewCreated = findOne(rs.getLong("id"));
            }

            return userNewCreated;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public Users update(Long id, Users object) {
        String updateUserQuery = "UPDATE user set" +
                "name = ?, surname = ?, change = ?," +
                "sex = ?, height = ?, role_id = ?" + "where id = ?";

        Users user = null;

        registredDriver();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateUserQuery)) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getSurname());
            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(4, object.getSex());
            preparedStatement.setInt(5, object.getHeight());
            preparedStatement.setLong(6, object.getRoleId());
            preparedStatement.setLong(7, id);

            preparedStatement.executeUpdate();

            return findOne(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues! UserRUpdate");
        }
    }

    @Override
    public void delete(Long id) {
        String deleteUserQuery = "DELETE FROM users WHERE id = ?";

        registredDriver();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery)) {
            try {
                connection.setAutoCommit(false);

                preparedStatement.setLong(1, id);

                connection.commit();
            } catch (Exception e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues! UserRepDelete!");
        }
    }

    @Override
    public Users getRandomUsers() {
        final String findRandomQuery = "SELECT * FROM users ORDER BY RANDOM() LIMIT 1";

        Users user = null;

        registredDriver();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findRandomQuery)) {

            while (rs.next()) {
                user = parseResultSet(rs);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        return user;
    }
}
