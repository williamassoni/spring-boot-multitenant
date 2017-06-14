package com.example.multitenant;

import java.util.Arrays;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

//docker run --name some-postgres -p 5432:5432 -d postgres
//curl -v -H "X-TENANT-ID: tenant_2" "http://localhost:8080/persons"
@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public FlywayMigrationStrategy flywayMigrationStrategy(){
		return new FlywayMigrationStrategy() {
			@Override
			public void migrate(Flyway migrate) {
				String schemas[] = Arrays.copyOf(migrate.getSchemas(),migrate.getSchemas().length);
				
				for (String schema : schemas) {
					migrate.setSchemas(schema);
					migrate.migrate();
				}
			}
		};
	}
}
