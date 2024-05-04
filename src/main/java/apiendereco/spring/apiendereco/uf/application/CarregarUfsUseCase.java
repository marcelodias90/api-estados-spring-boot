package apiendereco.spring.apiendereco.uf.application;

import apiendereco.spring.apiendereco.uf.domain.ports.GenerativeApiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CarregarUfsUseCase {

    private @Autowired GenerativeApiService apiService;

    public List<?> carregarUfs(){

        return apiService.todosEstados();
    }
}
