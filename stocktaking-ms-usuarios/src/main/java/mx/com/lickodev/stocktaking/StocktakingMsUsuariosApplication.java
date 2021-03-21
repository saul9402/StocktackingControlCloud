package mx.com.lickodev.stocktaking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = {"mx.com.lickodev.stocktaking.entity"})
@EnableEurekaClient
@EnableAutoConfiguration
public class StocktakingMsUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocktakingMsUsuariosApplication.class, args);
	}

}
