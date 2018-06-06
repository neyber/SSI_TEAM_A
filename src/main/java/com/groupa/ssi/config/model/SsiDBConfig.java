package com.groupa.ssi.config.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Miguel Rojas
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = Constants.SsiPersistence.BASE_REPOSITORIES_PACKAGE,
        entityManagerFactoryRef = "ssiEntityManager",
        transactionManagerRef = "ssiTransactionManager"
)
public class SsiDBConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "ssi.datasource")
    public DataSource ssiDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "ssiEntityManager")
    public LocalContainerEntityManagerFactoryBean ssiEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ssiDataSource())
                .properties(hibernateProperties())
                .packages(Constants.SsiPersistence.BASE_ENTITIES_PACKAGE)
                .persistenceUnit(Constants.SsiPersistence.PU_NAME)
                .build();
    }

    @Primary
    @Bean(name = "ssiTransactionManager")
    public PlatformTransactionManager ssiTransactionManager(@Qualifier("ssiEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map hibernateProperties() {
        Map map = new HashMap();
        map.put("hibernate.hbm2ddl.auto", "create-drop");  //values:  validate, create-drop

        return map;
    }
}
