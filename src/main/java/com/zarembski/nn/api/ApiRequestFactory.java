package com.zarembski.nn.api;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class ApiRequestFactory {
    public static final String URL = "https://api.github.com/users/";

    private Client client = ClientBuilder.newClient(new ClientConfig());

    public Response invoke(String endpoint) {
        return invokeFullPath(URL + endpoint);
    }

    public Response invokeFullPath(String url) {
        return client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }
}
