package com.bluegiant.task.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ={"com.bluegiant.task.model"})
@EnableJpaRepositories(
        basePackages = {"com.bluegiant.task.dao"},
        entityManagerFactoryRef = "h2EntityManagerFactory"
        )
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class H2DataSourceConfiguration implements ApplicationContextAware {

    @Bean("h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        ApplicationContext applicationContext = ApplicationContextHolder.getApplicationContext();
        DataSource h2DataSource = (DataSource) applicationContext.getBean("h2DataSource");

        DataSource dataSource = h2DataSource;

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.bluegiant.task.model");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(createJpaProperties());
        return em;
    }

    private Properties createJpaProperties() {

        ApplicationContext applicationContext = ApplicationContextHolder.getApplicationContext();
        Environment env = applicationContext.getBean(Environment.class);

        Properties properties = new Properties();

        properties.setProperty("hibernate.connection.release_mode", env.getProperty("h2.hibernate.connection.release_mode"));
        properties.setProperty("hibernate.dialect", env.getProperty("h2.hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("h2.hibernate.show_sql"));
        properties.setProperty("hibernate.format_sql", env.getProperty("h2.hibernate.format_sql"));

        properties.put("hibernate.hbm2ddl.delimiter", env.getProperty("h2.hibernate.hbm2ddl.delimiter"));
        properties.put("hibernate.hbm2ddl.charset_name", env.getProperty("h2.hibernate.hbm2ddl.charset_name"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("h2.hibernate.hbm2ddl.auto"));

        properties.put("javax.persistence.validation.mode", env.getProperty("h2.javax.persistence.validation.mode"));

        return properties;
    }

    @Bean
    public DataSource h2DataSource() {

        ApplicationContext applicationContext = ApplicationContextHolder.getApplicationContext();
        Environment env = applicationContext.getBean(Environment.class);

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("h2.driverClassName"));
        dataSource.setUrl(env.getProperty("h2.dataSource.url"));
        dataSource.setUsername(env.getProperty("h2.dataSource.username"));
        dataSource.setPassword(env.getProperty("h2.dataSource.password"));

        return dataSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.setApplicationContextProceted(applicationContext);
    }
}
