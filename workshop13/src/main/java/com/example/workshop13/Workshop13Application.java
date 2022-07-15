package com.example.workshop13;

import java.util.List;

import static com.example.workshop13.util.IOUtil.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13Application {
	private static final Logger logger = LoggerFactory.getLogger(Workshop13Application.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Workshop13Application.class);
		DefaultApplicationArguments defaultArgs = new DefaultApplicationArguments(args);
		List<String> opsVal = defaultArgs.getOptionValues("dataDir");
		if(opsVal !=null){
			logger.info("data dir > ", (String) opsVal.get(0));
			createDir((String) opsVal.get(0));
		}else{
			logger.warn("No data directory was provided");
			System.exit(1);
		}

		app.run(args);
	}

}
