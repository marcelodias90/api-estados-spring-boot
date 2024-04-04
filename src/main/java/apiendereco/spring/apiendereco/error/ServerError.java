package apiendereco.spring.apiendereco.error;

public class ServerError extends Error{
    public ServerError(String message){
        super(message);
    }
}
