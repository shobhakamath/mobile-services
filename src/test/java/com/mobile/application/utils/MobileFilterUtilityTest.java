package com.mobile.application.utils;

import com.mobile.application.dto.Brand;
import com.mobile.application.testutils.LoadUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileFilterUtilityTest {

    static List<Brand> brands;

    @BeforeAll
    public static void init() {
        LoadUtils loadUtils = new LoadUtils();
        brands = loadUtils.getMobiles();
    }

    @DisplayName("Test loading a JSON file")
    @Test
    void loadJSONTest() {
        assertNotNull(brands);

    }

    @Test
    public void test1() {
        List<Brand> brands1 = brands.stream()
                .filter(i -> i.getRelease().getPriceEur().contains("200"))
                .collect(Collectors.toList());
        assertTrue(brands1.size() == 10);

    }

    @Test
    public void test2() {
        List<Brand> brands1 = brands.stream()
                .filter(i -> i.getSim().contains("eSIM"))
                .collect(Collectors.toList());
        assertTrue(brands1.size() == 18);

    }

    @Test
    public void test3() {
        List<Brand> brands1 = brands.stream()
                .filter(i -> i.getRelease().getAnnounceDate().contains("2018"))
                .collect(Collectors.toList());
        assertTrue(brands1.size() == 8);

    }


    @Test
    public void test4() {
        List<Brand> brands1 = brands.stream()
                .filter(i -> i.getSim().contains("eSIM") && i.getRelease().getAnnounceDate().contains("2018"))
                .collect(Collectors.toList());
        assertTrue(brands1.size() == 7);

    }

    @Test
    public void testForPriceEurSpec() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("priceEur", "200");
        List<Brand> result = MobileFilterUtility.filterCriteria(brands, requestParams);
        assertTrue(result.size() == 10);
    }

    @Test
    public void testForSimSpec() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("sim", "eSim");
        List<Brand> result = MobileFilterUtility.filterCriteria(brands, requestParams);
        assertTrue(result.size() == 18);
    }

    @Test
    public void testForAnnounceDatePriceSpec() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("announceDate", "1999");
        requestParams.put("priceEur", "200");
        List<Brand> result = MobileFilterUtility.filterCriteria(brands, requestParams);
        assertTrue(result.size() == 2);
    }

    @Test
    public void testForResolutionSpec() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("resolution", "448");
        List<Brand> result = MobileFilterUtility.filterCriteria(brands, requestParams);
        assertTrue(result.size() == 2);
    }

    @Test
    public void testForAudioJackAnSimSpec() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("audioJack", "Yes");
        requestParams.put("sim", "esim");
        List<Brand> result = MobileFilterUtility.filterCriteria(brands, requestParams);
        assertTrue(result.size() == 9);
    }

    @Test
    public void testForAuioJackAndPriceEurSpec() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("audioJack", "Yes");
        requestParams.put("priceEur", "200");
        List<Brand> result = MobileFilterUtility.filterCriteria(brands, requestParams);
        assertTrue(result.size() == 4);
    }

    @Test
    public void testForAudioJackNullSimSpec() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("audioJack", null);
        requestParams.put("sim", "esim");
        List<Brand> result = MobileFilterUtility.filterCriteria(brands, requestParams);
        assertTrue(result.size() == 18);
    }

}
