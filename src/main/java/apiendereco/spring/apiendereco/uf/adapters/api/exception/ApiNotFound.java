package apiendereco.spring.apiendereco.uf.adapters.api.exception;

public class ApiNotFound extends RuntimeException{

    public ApiNotFound(String message){
        super(message);
    }
}
