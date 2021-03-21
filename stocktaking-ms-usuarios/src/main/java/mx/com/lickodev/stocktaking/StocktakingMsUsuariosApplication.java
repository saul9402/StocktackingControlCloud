package mx.com.lickodev.stocktaking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class StocktakingMsUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocktakingMsUsuariosApplication.class, args);
	}

}
