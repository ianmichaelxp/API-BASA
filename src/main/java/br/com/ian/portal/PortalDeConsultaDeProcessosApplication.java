package br.com.ian.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class PortalDeConsultaDeProcessosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalDeConsultaDeProcessosApplication.class, args);
		System.out.println("✔️ Running!!");
	}

}
