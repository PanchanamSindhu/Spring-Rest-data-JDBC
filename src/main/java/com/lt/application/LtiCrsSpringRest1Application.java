package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.lt.configuration.JDBCConfiguration;

/**
* The CRS program implements an Spring Rest application that simply allows the user to
* perform Specific actions by taking Input from Postman.
*
* @author group5
* @since 2022-06-02
*/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.lt.*"})
@Import({JDBCConfiguration.class})
@EnableWebMvc
public class LtiCrsSpringRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(LtiCrsSpringRest1Application.class, args);
	}

}
