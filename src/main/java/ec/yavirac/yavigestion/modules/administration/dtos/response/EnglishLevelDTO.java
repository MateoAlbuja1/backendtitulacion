package ec.yavirac.yavigestion.modules.administration.dtos.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnglishLevelDTO {

    private Long id;
    private String code;
    private String description;
    private String status;
}
