package com.mobile.application.services;

import com.mobile.application.dto.Hardware;
import com.mobile.application.dto.Release;
import com.mobile.application.exceptions.BadRequestException;
import com.mobile.application.utils.MobileFilterUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;


/**
 * This class contains utility methods for validating the request params.
 *
 * @author shobha
 * @version 1.0
 */
public class RequestParamsValidationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestParamsValidationService.class);

    /**
     * @param requestParamFound
     * @param class1            Validates the request params recursively
     */
    public static void validateRequestParamsRecursively(Map<String, Boolean> requestParamFound,
                                                        Class class1) {
        LOGGER.info("validateRequestParamsRecursively for " + class1.getName());
        Field[] fields = class1.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
                    if (MobileFilterUtility.isHardware.test(field.getType().getSimpleName()))
                        validateRequestParamsRecursively(requestParamFound, Hardware.class);
                    if (MobileFilterUtility.isRelease.test(field.getType().getSimpleName()))
                        validateRequestParamsRecursively(requestParamFound, Release.class);
                    if (Objects.nonNull(requestParamFound.get(field.getName()))) {
                        requestParamFound.put(field.getName(), true);
                    }
                }
        );
    }

    /**
     * @param requestParamFound
     * @param class1
     * @return validates the request params
     */
    public static boolean validateRequestParams(Map<String, Boolean> requestParamFound,
                                                Class class1) {
        LOGGER.info("validateRequestParams for " + class1.getName());
        validateRequestParamsRecursively(requestParamFound, class1);
        requestParamFound.forEach((k, v) -> LOGGER.info((k + ":" + v)));
        Set<Boolean> values = new HashSet<Boolean>(requestParamFound.values());
        if (values.size() == 1 && values.contains(true))
            return true;
        else {
            List<String> errorLst = new ArrayList<>();
            requestParamFound.forEach((k, v) -> {
                        if (!v) {
                            errorLst.add(k);
                        }
                    }
            );
            throw new BadRequestException(errorLst, "Validation Errors");
        }
    }


}
