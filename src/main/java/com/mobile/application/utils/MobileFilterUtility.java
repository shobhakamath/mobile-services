package com.mobile.application.utils;

import com.mobile.application.dto.Brand;
import com.mobile.application.dto.Hardware;
import com.mobile.application.dto.Release;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class contains utility methods of the application.
 *
 * @author shobha
 * @version 1.0
 */
public class MobileFilterUtility {

    public final static Predicate<String> isHardware = name -> (name.equals(Hardware.class.getSimpleName()));
    public final static Predicate<String> isRelease = name -> (name.equals(Release.class.getSimpleName()));

    /**
     * Filter the mobile data based on criteria
     *
     * @param brands
     * @param requestParams map of request parameters
     * @return   List of brands filtered on the filter criteria
     */
    public static List<Brand> filterCriteria(List<Brand> brands, Map<String, String> requestParams) {
        return brands.stream().
                filter(brand ->
                        filterMobiles(requestParams, brand))
                .collect(Collectors.toList());

    }

    /**
     * Validate the request parameters
     *
     * @param requestParamFound
     * @param objClass the object
     * @return boolean
     */
    public static boolean filterMobiles(Map<String, String> requestParamFound,
                                        Object objClass) {
        Field[] fields = objClass.getClass().getDeclaredFields();
        boolean isValid = true;
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (isRelease.test(field.getType().getSimpleName()) ||
                        isHardware.test(field.getType().getSimpleName())) {
                    isValid = isValid && filterMobiles(requestParamFound, field.get(objClass));
                    if (!isValid) return isValid;
                }
                if (Objects.nonNull(requestParamFound.get(field.getName()))) {
                    String str = (String) field.get(objClass);
                    isValid = isValid && str.toLowerCase().contains(requestParamFound.get(field.getName()).toLowerCase());
                    if (!isValid) return isValid;
                }
            }
        } catch (IllegalAccessException e) {
            return false;
        }
        return isValid;
    }
}
