package com.reactivetest.controller;

import com.reactivetest.util.CommonConstants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ReactiveController {

    @GetMapping(value = CommonConstants.FLUX_STREAM_EP, produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Integer> getFlux(){
        return Flux.just(1,2,3,4)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }
}
