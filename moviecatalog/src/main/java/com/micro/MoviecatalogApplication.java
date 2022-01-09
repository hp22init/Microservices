package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class MoviecatalogApplication {

	// below is the code to make the restTemplete object singloton
	//so that it is not creted everytime the
	@Bean
	@LoadBalanced //does service discovey in load balanced way
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

/* rective java
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(MoviecatalogApplication.class, args);
	}

}
