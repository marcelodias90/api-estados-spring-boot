package apiendereco.spring.apiendereco.uf.application;

import apiendereco.spring.apiendereco.error.BadRequest;
import apiendereco.spring.apiendereco.error.ServerError;
import apiendereco.spring.apiendereco.httpHelpers.removerAcentos;
import apiendereco.spring.apiendereco.uf.adapters.api.estadoModelApi;
import apiendereco.spring.apiendereco.uf.domain.model.uf;
import apiendereco.spring.apiendereco.uf.domain.ports.GenerativeApiService;
import apiendereco.spring.apiendereco.uf.domain.ports.UfRepository;


import java.util.List;
import java.util.stream.Collectors;


public record AdicionarUfUseCase(UfRepository repository, GenerativeApiService apiService, CarregarUfsUseCase carregarUfsUseCase) {

    public void adicionarUf(uf uf){

        try {
            List<estadoModelApi> listaFormatada = formatarDadosApi(apiService.generateContent());

            boolean ufValido = verificaUfValido(listaFormatada,uf);
            if(!ufValido){
                throw new BadRequest("UF não existe ou sigla não pertece à essa UF");
            }

            List<uf> ufs = carregarUfsUseCase.carregarUfs();
            boolean ufExiste = ufs.stream().anyMatch(ufBanco -> ufBanco.getNome()
                            .equalsIgnoreCase(uf.getNome().trim()));

            if (ufExiste){
                throw new BadRequest("UF já cadastrado ");
            }

            repository.adicionarUf(uf);

        } catch (Error error){
            throw new ServerError(error.getMessage());
        }

    }


    private List<estadoModelApi> formatarDadosApi(List<estadoModelApi> estados) {
        return estados.stream()
                .map(estado -> new estadoModelApi(
                        estado.sigla(),
                        removerAcentos.remove(estado.nome())))
                .collect(Collectors.toList());
    }

    private boolean verificaUfValido(List<estadoModelApi> estados, uf uf){
        return estados.stream().anyMatch(estado -> estado.nome()
                .equalsIgnoreCase(uf.getNome())
                && estado.sigla().equalsIgnoreCase(uf.getSigla()));
    }

}

