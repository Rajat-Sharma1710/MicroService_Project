package com.example.address.config;

import com.example.address.globalException.CustomException;
import com.example.address.globalException.Responsehandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

/*
    JSON contracts and Java exception types do NOT have to be identical.
    You must convert at the boundary (Feign layer).

    “Feign acts as a boundary between services. JSON responses use
     simple types like strings, while internal exceptions use
     framework-specific enums. The correct place to convert between them
     is the Feign ErrorDecoder.”
 */
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            InputStream inputStream = response.body().asInputStream();
            Responsehandler errorResponse = mapper.readValue(inputStream, Responsehandler.class);
            HttpStatus status = getStatusFromMessage(errorResponse);
            return new CustomException(errorResponse.getMessage(), status);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpStatus getStatusFromMessage(Responsehandler errorResponse) {
        HttpStatus status;
        try {
            status = HttpStatus.valueOf(errorResponse.getStatus());
        } catch (IllegalArgumentException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return status;
    }
}
