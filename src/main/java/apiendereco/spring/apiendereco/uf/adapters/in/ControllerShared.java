package apiendereco.spring.apiendereco.uf.adapters.in;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class ControllerShared<T> {

    protected Function<T, ResponseEntity<T>> objetoNaoEncontrado() {
        return object -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(object);
    }

    protected Predicate<Page<T>> filtrarListaVazia() {
        return page -> page.getContent().isEmpty();
    }
}
