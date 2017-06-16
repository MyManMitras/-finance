package mmm.service.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args){
		SpringApplication.run(FinanceApplication.class, args); //NOSONAR
	}
	
}
