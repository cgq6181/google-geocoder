package com.rest.client.controller;

import com.rest.client.json.GeocoderResponse;
import com.rest.client.services.GeocoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GeocoderController {

    @Autowired
    GeocoderService geocoderService;

    @GetMapping("/latandlng/{address}")
    public Mono<GeocoderResponse> getLatAndLng(@PathVariable String address){
     return geocoderService.getLatAndLng("1600 Ampitheatre Parkway",
             "Mountain View", "CA");
    }

    @GetMapping("/latandlng")
    public Mono<GeocoderResponse> getLatAndLngV1(){
        return geocoderService.getLatAndLng("1600 Ampitheatre Parkway",
                "Mountain View", "CA");
    }
}
