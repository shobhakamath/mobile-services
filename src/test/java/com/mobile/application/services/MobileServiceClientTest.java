package com.mobile.application.services;

import com.mobile.application.configuration.MobileConfiguration;
import com.mobile.application.dto.Brand;
import com.mobile.application.exceptions.MobileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class MobileServiceClientTest {
    @MockBean
    WebClient.Builder webClientBuilder;
    @MockBean
    MobileConfiguration mobileConfiguration;


    private MobileServiceClient mobileServiceClient;

    @BeforeEach
    public void setUp() {

        mobileServiceClient = new MobileServiceClient(webClientBuilder, mobileConfiguration);
    }


    @Test
    public void getMobileResponse() throws Exception{

        Mono<List<Brand>> brands = mobileServiceClient.getMobilesOnCriteria(new HashMap<>());

    }


}
