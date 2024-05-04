package apiendereco.spring.apiendereco.uf.domain.ports;

import java.util.List;

public interface GenerativeApiService {

   List<?> todosEstados();

   Object estado(Long id);
}
