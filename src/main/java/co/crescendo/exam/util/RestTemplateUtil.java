package co.crescendo.exam.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class RestTemplateUtil {

    @Value("${token}")
    private String token;

    public HttpHeaders createRequestHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ token);
        return  headers;
    }
}
