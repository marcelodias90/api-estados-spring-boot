package apiendereco.spring.apiendereco.uf.application.exception;

import apiendereco.spring.apiendereco.error.BadRequest;


public class UfNaoEncontradaException extends BadRequest {
     public UfNaoEncontradaException(Long ufId) {
         super("UF do ID: %d não encontrado ou não existe.".formatted(ufId));
     }
}
