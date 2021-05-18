package com.rest.client.services;

import com.rest.client.json.GeocoderResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeocoderService {
    //Use your own key
    private static final String KEY = "";
    private final WebClient client;

    public GeocoderService(WebClient.Builder builder) {
        this.client = builder.baseUrl("https://maps.googleapis.com").build();
    }

    private String encodeString(String address){
        try{
            return URLEncoder.encode(address,"UTF-8");
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    public Mono<GeocoderResponse> getLatAndLng(String... address){
        String encoded = Stream.of(address)
                                .map(this::encodeString)
                                .collect(Collectors.joining(","));
        String path = "/maps/api/geocode/json";

        Mono<GeocoderResponse> geocoderResponseMono = client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("address", encoded)
                        .queryParam("key", KEY)
                        .build()
                )
                .retrieve()
                .bodyToMono(GeocoderResponse.class);
        //.block();

        return geocoderResponseMono;
    }
}
