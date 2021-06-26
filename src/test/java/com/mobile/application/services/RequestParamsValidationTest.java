package com.mobile.application.services;

import com.mobile.application.dto.Brand;
import com.mobile.application.exceptions.BadRequestException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RequestParamsValidationTest {
    @Test
    public void testRequestParams() {
        Map<String, Boolean> requestParams = new HashMap<>();
        requestParams.put("resolution", false);
        Assert.assertTrue(RequestParamsValidationService.validateRequestParams(requestParams, Brand.class));
    }

    @Test
    public void testRequestMultiParams() {
        Map<String, Boolean> requestParams = new HashMap<>();
        requestParams.put("resolution", false);
        requestParams.put("sim", false);
        Assert.assertTrue(RequestParamsValidationService.validateRequestParams(requestParams, Brand.class));
    }

    @Test
    public void testRequestParamsException() {
        Map<String, Boolean> requestParams = new HashMap<>();
        requestParams.put("resolution1", false);
        Assertions.assertThrows(BadRequestException.class, () ->
                RequestParamsValidationService.validateRequestParams(requestParams, Brand.class));
    }
}
