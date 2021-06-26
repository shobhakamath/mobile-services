package com.mobile.application.services;

import com.mobile.application.configuration.MobileConfiguration;
import com.mobile.application.exceptions.BadRequestException;
import com.mobile.application.exceptions.MobileNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

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
    public void getBadRequestException() throws Exception {
        Assertions.assertThrows(BadRequestException.class, () -> mobileServiceClient
                .getMobilesOnCriteria(new HashMap<>()));

    }

    @Test
    public void getMobileNotFoundException() throws Exception {
        Map<String, String> mapParams = new HashMap<>();
        mapParams.put("sim", "eSim");
        Assertions.assertThrows(MobileNotFoundException.class, () -> mobileServiceClient
                .getMobilesOnCriteria(mapParams));

    }


}
