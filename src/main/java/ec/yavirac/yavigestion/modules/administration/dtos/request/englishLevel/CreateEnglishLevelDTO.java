package ec.yavirac.yavigestion.modules.administration.dtos.request.englishLevel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEnglishLevelDTO {

    private String code;        // A1, A2, B1
    private String description;
    private String status;
}
