package tr.com.unicepte.unicepteservice.adapter.rest.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

@RestControllerAdvice
public class UcepteExceptionHandler {

    @ExceptionHandler(UcepteDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleDataNotFoundException(UcepteDataNotFoundException e){
        return new ExceptionResponse(e.getExceptionType(),e.getDetail());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception e){
        return new ExceptionResponse(ExceptionType.GENERIC_EXCEPTION, e.getMessage());
    }
}
