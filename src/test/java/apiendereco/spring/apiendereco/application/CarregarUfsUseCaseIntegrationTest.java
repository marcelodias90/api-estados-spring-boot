package apiendereco.spring.apiendereco.application;
import apiendereco.spring.apiendereco.uf.application.CarregarUfsUseCase;
import apiendereco.spring.apiendereco.uf.domain.model.uf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CarregarUfsUseCaseIntegrationTest {

    @Autowired
    private CarregarUfsUseCase carregarUfsUseCase;

    @Test
    public void testListUf(){
        List<uf> ufs = carregarUfsUseCase.findAll();

        Assertions.assertEquals(2, ufs.size());
    }
}
