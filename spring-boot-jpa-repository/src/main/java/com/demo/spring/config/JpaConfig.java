package com.demo.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {
	
	@Bean
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		
		LocalContainerEntityManagerFactoryBean lcb=new LocalContainerEntityManagerFactoryBean();
		lcb.setDataSource(ds);
		lcb.setPackagesToScan("com.demo.spring.entity");
		HibernateJpaVendorAdapter va=new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		lcb.setJpaVendorAdapter(va);
		return lcb;
		
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txm=new JpaTransactionManager();
		txm.setEntityManagerFactory(emf);
		return txm;
	}
	*/
	
	
}
