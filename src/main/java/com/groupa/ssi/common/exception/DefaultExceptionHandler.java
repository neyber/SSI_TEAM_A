package com.groupa.ssi.common.exception;

import com.groupa.ssi.common.response.rest.ErrorRestResponse;
import com.groupa.ssi.exception.DeleteEntityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler for controller layer, this should be handle all exception and create
 * the respective response
 *
 * @author Miguel Rojas
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    /**
     * Exception handler to DefaultSSIRuntimeException type and all sub class that extends of this
     * the result is an rest response with error message
     *
     * @param e exception
     * @return ErrorRestResponse
     */
    @ExceptionHandler(DefaultSSIRuntimeException.class)
    public ResponseEntity<ErrorRestResponse> handleMessagingException(DefaultSSIRuntimeException e) {
        log.info("handled DefaultSSIRuntimeException error...... ", e);
        ErrorRestResponse errorRestResponse = new ErrorRestResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorRestResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorRestResponse> handleConstraintViolationException(DataIntegrityViolationException e) {
        log.info("handled DataIntegrityViolationException error...... ", e);
        DeleteEntityConstraintViolationException constraintViolationException = new DeleteEntityConstraintViolationException();
        ErrorRestResponse errorRestResponse = new ErrorRestResponse(HttpStatus.BAD_REQUEST.value(), constraintViolationException.getMessage());
        return new ResponseEntity<>(errorRestResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Common Exception handler, if a exception is not handled, this manage the error
     * the result is an rest response with error message
     *
     * @param e exception
     * @return ErrorRestResponse
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRestResponse> handleGeneralException(Exception e) {
        log.info("Exception name..... " + e);
        log.info("handled Exception error...... ", e);
        ErrorRestResponse errorRestResponse = new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return new ResponseEntity<>(errorRestResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
