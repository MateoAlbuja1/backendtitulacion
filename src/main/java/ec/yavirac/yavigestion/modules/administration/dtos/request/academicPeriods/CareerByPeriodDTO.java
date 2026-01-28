package ec.yavirac.yavigestion.modules.administration.dtos.request.academicPeriods;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(description = "Listado de identificadores de carreras asociadas a un período académico")
public class CareerByPeriodDTO {

    @Schema(
            description = "Lista de identificadores de las carreras",
            example = "[1, 2, 3]"
    )
    private List<Long> careerIds;
}
