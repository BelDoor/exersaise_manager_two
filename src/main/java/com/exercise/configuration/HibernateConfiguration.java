package com.exercise.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfiguration {

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setPackagesToScan("com.exercise");
        factoryBean.setDataSource(dataSource);
        factoryBean.afterPropertiesSet();

        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setPackagesToScan("com.exercise");
        em.setDataSource(dataSource);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;

    }

//    private Properties getAdditionalProperties() {
//        Properties properties = new Properties();
//
//        properties.put("hibernate.show_sql", "true");
//        properties.put("current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
//        return properties;
 //   }
}
