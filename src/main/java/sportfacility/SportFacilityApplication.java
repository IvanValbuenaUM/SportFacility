package sportfacility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sportfacility.logic.Menu;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.management.RuntimeErrorException;

@SpringBootApplication
@EnableSwagger2
public class SportFacilityApplication {
	
    public static void main(String[] args) {
    	
        SpringApplication.run(SportFacilityApplication.class, args);
        
        try {
			Menu menu = Menu.getInstance();
			menu.start();
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
    }
}
