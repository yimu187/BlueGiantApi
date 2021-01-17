package com.bluegiant.task.exception.handler;

import com.bluegiant.task.exception.TaskException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(ResponseExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGenericExcepiton(Exception ex, WebRequest request){
        logException(ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Genel bir hata oluştu. Lütfen sistem yöneticiniz ile görüşünüz.", request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }

    @ExceptionHandler(TaskException.class)
    public final ResponseEntity<ExceptionResponse> handleNotImplementedException(TaskException notImpEx, WebRequest request){
        logException(notImpEx);
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), notImpEx.getExceptionMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public final ResponseEntity<ExceptionResponse> handleGenericExcepiton(BadCredentialsException ex, WebRequest request){
        logException(ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Kullanici adi veya şifre bilgisi hatalıdır.", request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }

    private void logException(Exception ex) {
        logger.info("ex is => " + ex.getMessage());

        StackTraceElement[] stackTrace = ex.getStackTrace();
        if(stackTrace != null && stackTrace.length > 0){
            logger.info("Stack Trace Begin");
            for (StackTraceElement stackTraceElement : stackTrace) {
                logger.info(stackTraceElement.toString());
            }
            logger.info("Stack Trace End");
        }
    }

}
