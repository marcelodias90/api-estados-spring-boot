package apiendereco.spring.apiendereco.uf.adapters;

import apiendereco.spring.apiendereco.uf.application.AdicionarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfsUseCase;
import apiendereco.spring.apiendereco.uf.domain.ports.GenerativeApiService;
import apiendereco.spring.apiendereco.uf.domain.ports.UfRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ufRepositoryConfig {

    @Bean
    public CarregarUfsUseCase provideCarregarUfsUseCase(UfRepository repository){
        return  new CarregarUfsUseCase(repository);
    }

    @Bean
    public CarregarUfUseCase provideCarregarUfUseCase(UfRepository repository){
        return  new CarregarUfUseCase(repository);
    }

    @Bean
    public AdicionarUfUseCase provideAdicionarUfUseCase(
            UfRepository repository, GenerativeApiService apiService, CarregarUfsUseCase carregarUfsUseCase
    ){
        return  new AdicionarUfUseCase(repository, apiService, carregarUfsUseCase);
    }
}
