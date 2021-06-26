package com.mobile.application.services;

import com.mobile.application.configuration.MobileConfiguration;
import com.mobile.application.dto.Brand;
import com.mobile.application.exceptions.MobileNotFoundException;
import com.mobile.application.utils.MobileFilterUtility;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MobileServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileServiceClient.class);

    private final WebClient.Builder webClientBuilder;
    private final MobileConfiguration mobileConfiguration;

    public Mono<List<Brand>> getMobilesOnCriteria(Map<String, String> requestParameters) {

        LOGGER.info("Request parameter size" + requestParameters.size());
        Map<String, Boolean> reqParams = new HashMap<>();
        requestParameters.forEach((k, v) -> reqParams.put(k, false));
        RequestParamsValidationService.validateRequestParams(reqParams, Brand.class);

        try {
            return getMobileBrands()
                    .flatMap(brands -> Mono.just(MobileFilterUtility
                            .filterCriteria(brands, requestParameters)));
        } catch (Exception e) {
            throw new MobileNotFoundException("mobile not found");
        }


    }

    private Mono<List<Brand>> getMobileBrands() throws Exception {
        LOGGER.info("Calling the downstream");
        return webClientBuilder.build().get()
                .uri(mobileConfiguration.getMobileUrl())
                .retrieve()
                .bodyToFlux(Brand.class)
                .timeout(Duration.ofMillis(mobileConfiguration.getMobileConnectionTimeout()))
                .collectList();

    }

}
