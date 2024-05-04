package apiendereco.spring.apiendereco.uf.adapters.in;

import apiendereco.spring.apiendereco.uf.adapters.in.dto.AdicionarUfDto;
import apiendereco.spring.apiendereco.uf.application.AdicionarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfUseCase;
import apiendereco.spring.apiendereco.uf.application.CarregarUfsUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import apiendereco.spring.apiendereco.uf.domain.model.Uf;

@RestController
@RequestMapping("/uf")
public class UfRestController  extends ControllerShared<Uf> {


    private @Autowired CarregarUfsUseCase carregarUfsUseCase;
    private @Autowired CarregarUfUseCase carregarUfUseCase;
    private @Autowired AdicionarUfUseCase adicionarUfUseCase;

    @GetMapping
    public List<?> carregarListaUf(){
        return carregarUfsUseCase.carregarUfs();
    }

    @GetMapping("{id:\\d+}")
    public Object carregarUf(@PathVariable Long id){
      return carregarUfUseCase.carregarUf(id);

    }

    @PostMapping
    public void salvarUf(@Valid @RequestBody AdicionarUfDto ufDto){
        adicionarUfUseCase.adicionarUf(
                new Uf(ufDto.getNome(), ufDto.getSigla(), ufDto.getStatus()));
    }
}
