package apiendereco.spring.apiendereco.error;

public class BadRequest extends RuntimeException{
    public BadRequest(String message){
        super(message);
    }
}
