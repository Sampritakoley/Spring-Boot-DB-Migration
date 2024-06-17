package com.example.SpringDbMigration.Db.SecondaryDB.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.SpringDbMigration.Db.SecondaryDB.Repo"},
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager"
)
public class SecondaryDbConfig {

    @Autowired
    private Environment environment;
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    public DataSource secondaryDataSource() {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("second.datasource.url"));
        dataSource.setUsername(environment.getProperty("second.datasource.username"));
        dataSource.setPassword(environment.getProperty("second.datasource.password"));
        return  dataSource;
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(secondaryDataSource());
        JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        Map<String,Object> prop=new HashMap<>();
        prop.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        prop.put("hibernate.show-sql","true");
        prop.put("hibernate.ddl-auto","validate");

        bean.setJpaPropertyMap(prop);
        bean.setPackagesToScan("com.example.SpringDbMigration.Db.SecondaryDB.Entity");
        return bean;
    }

    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager secondTransactionManager() {
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(secondaryEntityManagerFactory().getObject());
        return manager;
    }
}
