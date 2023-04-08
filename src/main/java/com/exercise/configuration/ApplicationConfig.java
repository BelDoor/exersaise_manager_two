package com.exercise.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableWebMvc
public class ApplicationConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource hikariDataSource(DataBaseProperties dataBaseProperties){
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setUsername(dataBaseProperties.getLogin());
        hikariDataSource.setPassword(dataBaseProperties.getPassword());
        hikariDataSource.setDriverClassName(dataBaseProperties.getPostgresDriverName());
        hikariDataSource.setMaximumPoolSize(dataBaseProperties.getPoolSize());
        hikariDataSource.setJdbcUrl(dataBaseProperties.getJdbcUrl());

        return hikariDataSource;
    }
}
