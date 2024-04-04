package apiendereco.spring.apiendereco.uf.domain.ports;

import java.util.Optional;

import apiendereco.spring.apiendereco.uf.domain.model.uf;
public interface UfRepository {

    Iterable<uf> carregarUfs();

    Optional<uf> carregarUf(Long id);

     int adicionarUf(uf uf);

}
