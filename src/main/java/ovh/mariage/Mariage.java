package ovh.mariage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mariage {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Mariage.class);
        app.run(args);
	}

}
