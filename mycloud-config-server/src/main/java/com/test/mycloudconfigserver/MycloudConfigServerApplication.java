package com.test.mycloudconfigserver;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class MycloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycloudConfigServerApplication.class, args);
	}

}
