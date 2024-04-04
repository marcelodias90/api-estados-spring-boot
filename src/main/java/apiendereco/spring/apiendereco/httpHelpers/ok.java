package apiendereco.spring.apiendereco.httpHelpers;

import apiendereco.spring.apiendereco.uf.domain.model.uf;

public class ok extends  RuntimeException {
    private  Object body;

    public ok(Object body) {
        this.body = body;
    }

    public httpResponse ok(Object body){
        Integer statusCode = 200;
        return new httpResponse<Object>(statusCode,body);
    }
}

