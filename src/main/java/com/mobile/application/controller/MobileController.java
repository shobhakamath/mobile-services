package com.mobile.application.controller;

import com.mobile.application.dto.Brand;
import com.mobile.application.services.MobileServiceClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class MobileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileController.class);

    private final MobileServiceClient mobileServiceClient;

    /**
     * Handles the search GET API request.
     *
     * @param allParams
     * @return REST API for searching mobiles
     */
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Mono<List<Brand>> searchMobiles(@RequestParam Map<String, String> allParams) throws Exception{
        LOGGER.info("search Mobiles controller");
        return mobileServiceClient
                .getMobilesOnCriteria(allParams);
    }


}
