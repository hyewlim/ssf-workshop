package com.ssf.workshop11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Workshop11Application {

	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);
	private static final String DEFAULT_PORT_NUMBER = "3000";

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter requestLoggingFilter = new CommonsRequestLoggingFilter();
		requestLoggingFilter.setIncludeClientInfo(true);
		requestLoggingFilter.setIncludeHeaders(true);
		requestLoggingFilter.setIncludeQueryString(true);
		requestLoggingFilter.setIncludePayload(true);
		return requestLoggingFilter;
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Workshop11Application.class);
		SpringApplication.run(Workshop11Application.class, args);
		logger.info("web app");
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List<String> opsVal = appArgs.getOptionValues("port");
		logger.info("opsVal >" + opsVal);
		String portNumber;
		if (opsVal == null || opsVal.get(0) == null) {
			portNumber = System.getenv("PORT");
			if (portNumber == null ) {
				portNumber = DEFAULT_PORT_NUMBER;
			} else {
				portNumber = (String)opsVal.get(0);
			}

			if (portNumber != null) {
				app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
			}
		}
		app.run(args);
	}

}
