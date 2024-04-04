package apiendereco.spring.apiendereco.uf.application;

import apiendereco.spring.apiendereco.uf.application.exception.UfNaoEncontradaException;
import apiendereco.spring.apiendereco.uf.domain.model.uf;
import apiendereco.spring.apiendereco.uf.domain.ports.UfRepository;


public record CarregarUfUseCase(UfRepository repository) {

    public uf carregarUf(Long id){
        return repository.carregarUf(id)
                .orElseThrow(() -> new UfNaoEncontradaException(id));
    }
}
