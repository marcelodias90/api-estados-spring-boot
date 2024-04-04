package apiendereco.spring.apiendereco.httpHelpers;

public class httpResponse<T> {
    private Integer statusCode;
    private Object body;

    public httpResponse(Integer satusCode, Object body){
        this.statusCode = satusCode;
        this.body = body;
    }
}
