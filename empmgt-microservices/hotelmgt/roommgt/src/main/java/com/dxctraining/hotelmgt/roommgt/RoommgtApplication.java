package com.dxctraining.hotelmgt.roommgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RoommgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoommgtApplication.class, args);
	}

}
