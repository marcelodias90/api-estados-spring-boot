package apiendereco.spring.apiendereco.uf.adapters.in.dto;


import java.util.Optional;

public record CarregarUfDto(Optional<String> nome, Optional<String> sigla, Optional<Boolean> status, Optional<Long> id) {
}
