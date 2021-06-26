package com.mobile.application.controller;

import com.mobile.application.dto.Brand;
import com.mobile.application.services.MobileServiceClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = MobileController.class)
public class MobileControllerTest {
    @MockBean
    private MobileServiceClient mobileServiceClient;

    @Autowired
    private WebTestClient client;


    @Test
    void getMobileListTest() throws Exception{
        Mockito
                .when(mobileServiceClient.getMobilesOnCriteria(any(Map.class)))
                .thenReturn(Mono.just(
                        List.of(Brand.builder()
                                .brand("brand1")
                                .build(), Brand.builder()
                                .brand("brand2")
                                .build())
                ));

         client.get()
                .uri("/search")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].brand", is("brand1"));
    }
}
