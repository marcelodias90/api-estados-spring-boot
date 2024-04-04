package apiendereco.spring.apiendereco.uf.adapters.in;

import apiendereco.spring.apiendereco.uf.adapters.in.dto.ufDto;
import apiendereco.spring.apiendereco.uf.application.AdicionarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfsUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import apiendereco.spring.apiendereco.uf.domain.model.uf;

@RestController
@RequestMapping("/uf")
public record UfRestController(CarregarUfsUseCase carregarUfsUseCase, CarregarUfUseCase carregarUfUseCase, AdicionarUfUseCase adicionarUfUseCase) {

    @GetMapping
    public List<uf> carregarListaUf(){
        return carregarUfsUseCase.carregarUfs();
    }

    @GetMapping("/{id}")
    public uf carregarUf( @PathVariable Long id){
       return carregarUfUseCase.carregarUf(id);
    }

    @PostMapping
    public void salvarUf(@Valid @RequestBody ufDto ufDto){
        adicionarUfUseCase.adicionarUf(
                new uf(ufDto.getNome(), ufDto.getSigla(), ufDto.getStatus()));
    }
}
