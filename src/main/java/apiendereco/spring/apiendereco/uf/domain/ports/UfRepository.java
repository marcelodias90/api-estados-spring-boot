package apiendereco.spring.apiendereco.uf.domain.ports;

import java.util.Optional;

import apiendereco.spring.apiendereco.uf.domain.model.Uf;
public interface UfRepository {

    Iterable<Uf> carregarUfs();

    Optional<Uf> carregarUf(Long id);

     void adicionarUf(Uf uf);

}
