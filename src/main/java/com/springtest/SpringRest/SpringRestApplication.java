package com.springtest.SpringRest;

import com.springtest.SpringRest.service.UdpClientService;
import com.springtest.SpringRest.service.UdpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringRestApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
