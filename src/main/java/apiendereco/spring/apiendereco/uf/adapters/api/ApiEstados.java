package apiendereco.spring.apiendereco.uf.adapters.api;

import apiendereco.spring.apiendereco.uf.adapters.api.exception.ApiNotFound;
import apiendereco.spring.apiendereco.uf.application.exception.UfNaoEncontradaException;
import apiendereco.spring.apiendereco.uf.domain.model.EstadoModel;
import apiendereco.spring.apiendereco.uf.domain.ports.GenerativeApiService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "OPENAI", matchIfMissing = true)
@FeignClient(name = "apiEstados", url = "${api.estados.base.url}")
public interface ApiEstados extends GenerativeApiService {
    @GetMapping("/api/v1/localidades/estados")
    List<EstadoModel> listaUfs();

    @GetMapping("/api/v1/localidades/estados/{id}")
    Object Uf(@PathVariable Long id);

    @Override
    default List<?> todosEstados() {

        if(listaUfs().isEmpty()) throw new ApiNotFound("Error ao buscar dados na API.");

        return listaUfs();
    }

    @Override
    default Object estado(Long id) {

        Object uf = Uf(id);

        if(uf instanceof List<?>) throw new UfNaoEncontradaException(id);

        return uf;
    }
}
