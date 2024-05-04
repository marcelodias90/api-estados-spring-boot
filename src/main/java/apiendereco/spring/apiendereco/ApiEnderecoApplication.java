package apiendereco.spring.apiendereco;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ApiEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEnderecoApplication.class, args);
	}
}
