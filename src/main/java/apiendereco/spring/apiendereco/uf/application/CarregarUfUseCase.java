package apiendereco.spring.apiendereco.uf.application;


import apiendereco.spring.apiendereco.uf.domain.ports.GenerativeApiService;

import org.springframework.beans.factory.annotation.Autowired;


public class CarregarUfUseCase  {

    private @Autowired GenerativeApiService apiService;

    public Object carregarUf(Long id) {

        return apiService.estado(id);
    }
}
