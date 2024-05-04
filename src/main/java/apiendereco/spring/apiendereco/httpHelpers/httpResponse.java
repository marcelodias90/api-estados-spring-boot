package apiendereco.spring.apiendereco.httpHelpers;

public class httpResponse<T> {
    private int statusCode;
    private T body;
    private String message;

    public httpResponse(int statusCode, Error error){
        this.statusCode = statusCode;
        this.body = (T) error;
    }

    public httpResponse(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }

    public httpResponse(int statusCode){
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
