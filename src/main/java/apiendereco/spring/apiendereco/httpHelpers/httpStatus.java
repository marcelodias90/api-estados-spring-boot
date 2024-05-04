package apiendereco.spring.apiendereco.httpHelpers;


public class httpStatus {

    public static <T> httpResponse<T> badRequest(Error error) {
        return new httpResponse<>(400, error);
    }

    public static <T> httpResponse<T> forbidden(Error error) {
        return new httpResponse<>(403, error);
    }

    public static <T> httpResponse<T> serverError(Error error) {
        return new httpResponse<>(500, error);
    }

    public static <T> httpResponse<T> ok() {
        return new httpResponse<>(200);
    }

    public static <T> httpResponse<T> noContent() {
        return new httpResponse<>(204);
    }

    public static <T> httpResponse<T> notFound(Error error) {
        return new httpResponse<>(404, error);
    }

    public static <T> httpResponse<T> unavailable(Error error) {
        return new httpResponse<>(503, error);
    }

    public static <T> httpResponse<T> created() {
        return new httpResponse<>(201);
    }
}
