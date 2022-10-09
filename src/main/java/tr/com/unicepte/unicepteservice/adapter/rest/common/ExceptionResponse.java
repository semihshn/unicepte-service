package tr.com.unicepte.unicepteservice.adapter.rest.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {
    private Integer code;
    private String message;
    private String detail;

    public ExceptionResponse(ExceptionType exceptionType, String detail) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
        this.detail = detail;
    }
}
