package apiendereco.spring.apiendereco;

import apiendereco.spring.apiendereco.uf.application.AdicionarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfsUseCase;
import apiendereco.spring.apiendereco.uf.domain.ports.UfRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
@EnableFeignClients
public class ApiEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEnderecoApplication.class, args);
	}
}
