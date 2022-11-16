package tr.com.unicepte.unicepteservice.domain.util.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    GENERIC_EXCEPTION(1, "Bilinmeyen bir sorun oluştu."),

    STUDENT_DATA_NOT_FOUND(1001, "Öğrenci bulunamadı"),
    GROUP_DATA_NOT_FOUND(1002, "Grup bulunamadı"),
    FACULTY_DATA_NOT_FOUND(1003, "Fakülte bulunamadı"),

    COLLECTION_SIZE_EXCEPTION(2001, "Liste boyutları uyuşmuyor");



    private final Integer code;
    private final String message;
}
