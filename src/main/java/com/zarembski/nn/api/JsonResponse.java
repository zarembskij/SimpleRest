package com.zarembski.nn.api;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum JsonResponse {
    ERROR("{ \"message\": \"Error\" }"),
    NOT_FOUND("{ \"message\": \"Not Found\" }");

    private String value;

    public String getValue() {
        return value;
    }
}
