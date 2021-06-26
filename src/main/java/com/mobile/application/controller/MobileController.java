package com.mobile.application.controller;

import com.mobile.application.dto.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class MobileController {


    /**
     * Handles the search GET API request.
     *
     * @param allParams
     * @return REST API for searching mobiles
     */
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Brand[] searchMobiles(@RequestParam Map<String, String> allParams) {
        return new Brand[1];
    }


}
