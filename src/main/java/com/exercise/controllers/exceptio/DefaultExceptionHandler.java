package com.exercise.controllers.exceptio;

import com.exercise.util.RandomValuesGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.exercise.controllers.response.ApplicationErrorCodes.FATAL_ERROR;
import static com.exercise.controllers.response.ApplicationErrorCodes.USER_NOT_FOUND;

@ControllerAdvice
@RequiredArgsConstructor
public class DefaultExceptionHandler {

    private final RandomValuesGenerator generator;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleOthersException(Exception e) {

        String exceptionUniqueId = generator.uuidGenerator();


        return new ResponseEntity<>(
                new ErrorMessage(
                        exceptionUniqueId,
                        FATAL_ERROR.getCodeId(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException e) {
        /* Handles all other exceptions. Status code 500. */

        String exceptionUniqueId = generator.uuidGenerator();

        return new ResponseEntity<>(
                new ErrorMessage(
                        exceptionUniqueId,
                        USER_NOT_FOUND.getCodeId(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}