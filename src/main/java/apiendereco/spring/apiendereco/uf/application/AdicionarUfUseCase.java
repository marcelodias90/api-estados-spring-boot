package apiendereco.spring.apiendereco.uf.application;

import apiendereco.spring.apiendereco.error.BadRequest;
import apiendereco.spring.apiendereco.httpHelpers.RemoverAcentos;
import apiendereco.spring.apiendereco.uf.domain.model.EstadoModel;
import apiendereco.spring.apiendereco.uf.domain.model.Uf;
import apiendereco.spring.apiendereco.uf.domain.ports.GenerativeApiService;
import apiendereco.spring.apiendereco.uf.domain.ports.UfRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.stream.Collectors;


public class AdicionarUfUseCase {

    private @Autowired UfRepository repository;
    private @Autowired GenerativeApiService apiService;
    private @Autowired CarregarUfsUseCase carregarUfsUseCase;

    public void adicionarUf(Uf uf){

        validaNovoUf(uf);
        repository.adicionarUf(uf);
    }

    private void validaNovoUf(Uf uf){
        List<EstadoModel> listaFormatada = (List<EstadoModel>) apiService.todosEstados();

        boolean ufValido = verificaUfValido(listaFormatada,uf);
        if(!ufValido){
            throw new BadRequest("UF não existe ou sigla não pertece à essa UF");
        }

        List<Uf> ufs = (List<Uf>) carregarUfsUseCase.carregarUfs();

        boolean ufExiste = ufs.stream().anyMatch(ufBanco -> ufBanco.getNome()
                .equalsIgnoreCase(uf.getNome().trim()));
        if (ufExiste){
            throw new BadRequest("Já exite esse UF");
        }
    }


    private List<EstadoModel> formatarDadosApi(List<EstadoModel> estados) {
        return estados.stream()
                .map(estado -> new EstadoModel(
                        estado.getSigla(),
                        RemoverAcentos.remove(estado.getNome())))
                .collect(Collectors.toList());
    }

    private boolean verificaUfValido(List<EstadoModel> estados, Uf uf){
        return estados.stream().anyMatch(estado -> estado.getNome()
                .equalsIgnoreCase(uf.getNome())
                && estado.getSigla().equalsIgnoreCase(uf.getSigla()));
    }
}

