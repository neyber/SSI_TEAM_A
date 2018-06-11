package com.groupa.ssi.config.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = Constants.SsiDataWarehousePersistence.BASE_REPOSITORIES_PACKAGE,
        entityManagerFactoryRef = "ssiWarehouseEntityManager",
        transactionManagerRef = "ssiWarehouseTransactionManager"
)
public class SsiDataWarehouseDBConfig {

    @Bean
    @ConfigurationProperties(prefix = "ssi.datawarehouse.datasource")
    public DataSource ssiWarehouseDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean(name = "ssiWarehouseEntityManager")
    public LocalContainerEntityManagerFactoryBean ssiWarehouseEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ssiWarehouseDataSource())
                .properties(hibernateProperties())
                .packages(Constants.SsiDataWarehousePersistence.BASE_ENTITIES_PACKAGE)
                .persistenceUnit(Constants.SsiDataWarehousePersistence.PU_NAME)
                .build();
    }

    @Bean(name = "ssiWarehouseTransactionManager")
    public PlatformTransactionManager ssiWarehouseTransactionManager(@Qualifier("ssiWarehouseEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map hibernateProperties() {
        Map map = new HashMap();
        //todo: enable this when datawarehouse entities is created
        //map.put("hibernate.hbm2ddl.auto", "validate");  //values:  create, create-drop, validate, and update

        return map;
    }
}
