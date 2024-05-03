package apiendereco.spring.apiendereco.uf.adapters.api;

import apiendereco.spring.apiendereco.uf.domain.ports.GenerativeApiService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "OPENAI", matchIfMissing = true)
@FeignClient(name = "apiEstados", url = "${api.estados.base.url}")
public interface apiEstados extends GenerativeApiService {
    @GetMapping("/api/v1/localidades/estados")
    List<estadoModelApi> generateContent();

}
