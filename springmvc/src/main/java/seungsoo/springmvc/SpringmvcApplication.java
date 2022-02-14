package seungsoo.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

}