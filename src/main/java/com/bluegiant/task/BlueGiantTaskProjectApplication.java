package com.bluegiant.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class BlueGiantTaskProjectApplication {
	private static Log logger = LogFactory.getLog(BlueGiantTaskProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlueGiantTaskProjectApplication.class, args);
		logger.info("localhost:8061/index.html ile uygulamaya giriş yapabiliriz ");
	}

}
