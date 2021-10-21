package com.devsuperior.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {
	@Value("${spring.cloud.config.server.git.username}")
	private String username;

	@Value("${spring.cloud.config.server.git.password}")
	private String password;
	
	@Value("${spring.cloud.config.server.git.private-key}")
	private String key;

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	public void run(String... args) throws Exception {

		System.out.println("Username = " + username);
		System.out.println("Password = " + password);
		System.out.println("Key = " + key);

	}
}
