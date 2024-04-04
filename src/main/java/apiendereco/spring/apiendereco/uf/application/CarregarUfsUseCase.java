package apiendereco.spring.apiendereco.uf.application;

import apiendereco.spring.apiendereco.uf.domain.ports.UfRepository;
import apiendereco.spring.apiendereco.uf.domain.model.uf;

import java.util.List;

public record CarregarUfsUseCase(UfRepository repository) {

    public List<uf> carregarUfs(){
        return (List<uf>) repository.carregarUfs();
    }
}
