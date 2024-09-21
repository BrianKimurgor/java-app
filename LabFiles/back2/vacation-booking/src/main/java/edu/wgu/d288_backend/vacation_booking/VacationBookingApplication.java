package edu.wgu.d288_backend.vacation_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import edu.wgu.d288_backend.entities.Customer;

@SpringBootApplication
@ComponentScan(basePackages = {
	"edu.wgu.d288_backend.controllers",
	"edu.wgu.d288_backend.services",
	"edu.wgu.d288_backend.config"
})
@EnableJpaRepositories(basePackages = "edu.wgu.d288_backend.dao")
@EntityScan(basePackages = "edu.wgu.d288_backend.entities")
public class VacationBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacationBookingApplication.class, args);
	}

}
