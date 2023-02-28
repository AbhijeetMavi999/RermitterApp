package com.beneficiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeneficiaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiaryServiceApplication.class, args);
	}

}
