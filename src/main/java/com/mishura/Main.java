package com.mishura;

import com.mishura.util.HibernateUtil;
import org.apache.log4j.PropertyConfigurator;
import org.flywaydb.core.Flyway;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();

        flyway.clean();

        final EntityManager entityManager = HibernateUtil.getEntityManager();

        flyway.migrate();

        PropertyConfigurator.configure("src/main/resources/log4j.properties");

    }
}
