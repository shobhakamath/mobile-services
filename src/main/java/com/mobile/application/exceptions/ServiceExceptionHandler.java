package com.mobile.application.exceptions;

import com.mobile.application.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The exception handler that maps exceptions to corresponding response status and message.
 *
 * @author shobha
 * @version 1.0
 */
@RestControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle illegal argument exception.
     *
     * @param ex the exception
     * @return the error response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildErrorResponse(ex.getMessage());
    }

    /**
     * Handle entity not found exception.
     *
     * @param ex the exception
     * @return the error response entity
     */
    @ExceptionHandler(MobileNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEntityNotFoundException(MobileNotFoundException ex) {
        return buildErrorResponse(ex.getMessage());
    }

    /**
     * Handle the other exceptions.
     *
     * @param throwable the throwable
     * @return the error response entity
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOtherException(Throwable throwable) {
        return buildErrorResponse("Internal server error");
    }


    /**
     * Build error response.
     *
     * @param message the message
     * @return the error response entity with code and message
     */
    private static ErrorResponse buildErrorResponse(String message) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(message);
        return response;
    }
}
