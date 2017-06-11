package com.example.multitenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//docker run --name some-postgres -p 5432:5432 -d postgres
//curl -v -H "X-TENANT-ID: tenant_2" "http://localhost:8080/persons"
@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
public class Application {

	@Autowired
    private AutowireCapableBeanFactory beanFactory;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
/*
	@Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        Filter tenantFilter = new MultiTenantFilter();
        beanFactory.autowireBean(tenantFilter);
        registration.setFilter(tenantFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
	*/
	/*@Bean
	public RequestContextFilter requestContextListener(){
	    return new RequestContextFilter();
	} */
}
