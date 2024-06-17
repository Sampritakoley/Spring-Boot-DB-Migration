package com.example.SpringDbMigration.Flyway;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Bean
    public Flyway primaryFlyway(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(primaryDataSource)
                .locations("classpath:DbMigration/PrimaryScript")
                .load();
        flyway.migrate();  // Explicitly call migrate
        return flyway;
    }

    @Bean
    public Flyway secondaryFlyway(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(secondaryDataSource)
                .locations("classpath:DbMigration/SecondaryScript")
                .load();
        flyway.migrate();  // Explicitly call migrate
        return flyway;
    }

}
