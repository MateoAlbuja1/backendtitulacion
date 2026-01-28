package ec.yavirac.yavigestion.modules.administration.dtos.request.career;

import ec.yavirac.yavigestion.modules.administration.enums.CareerType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "Información necesaria para la creación de una carrera académica")
public class CreateCareerDTO {

    @Schema(
            description = "Nombre de la carrera",
            example = "Desarrollo de Software"
    )
    private String name;

    @Schema(
            description = "Descripción de la carrera",
            example = "Carrera enfocada en el desarrollo de aplicaciones y sistemas informáticos"
    )
    private String description;

    @Schema(
            description = "Estado de la carrera",
            example = "ACTIVE"
    )
    private String status;

    @Schema(
            description = "Tipo de carrera (dual o no dual)",
            example = "DUAL",
            allowableValues = {
                    "DUAL",
                    "NOT_DUAL"
            }
    )
    private CareerType isDual;
}
