package com.reactivetest.controllertest;

import com.reactivetest.util.CommonConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebFluxTest
public class ReactiveControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void fluxStreamTest(){
        List<Integer> expectedResult = Arrays.asList(1,2,3,4);

        webTestClient
                .get().uri(CommonConstants.FLUX_STREAM_EP)
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Integer.class)
                .consumeWith((response)->{
                    assertEquals(expectedResult,response.getResponseBody());
                });
    }

}
