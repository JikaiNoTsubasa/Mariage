package ovh.mariage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Mariage extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Mariage.class);
        app.run(args);
	}

}
