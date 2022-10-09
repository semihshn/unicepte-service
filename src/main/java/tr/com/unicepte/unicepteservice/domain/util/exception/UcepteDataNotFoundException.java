package tr.com.unicepte.unicepteservice.domain.util.exception;

import lombok.Getter;

@Getter
public class UcepteDataNotFoundException extends RuntimeException {
    private final ExceptionType exceptionType;
    private String detail;

    public UcepteDataNotFoundException(ExceptionType exceptionType, String detail){
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public UcepteDataNotFoundException(ExceptionType exceptionType){
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }


}
