package ec.yavirac.yavigestion.modules.administration.dtos.request.academicPeriods;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "Información necesaria para crear un período académico")
public class CreateAcademicPeriodDTO {

    @Schema(
            description = "Nombre del período académico",
            example = "Periodo 2024-2025"
    )
    @NotEmpty(message = "El campo name no debe estar vacio")
    @NotNull(message = "El campo name no debe estar vacio")
    private String name;

    @Schema(
            description = "Fecha de inicio del período académico",
            example = "2024-09-01"
    )
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La startDate es obligatoria")
    private LocalDate startDate;

    @Schema(
            description = "Fecha de finalización del período académico",
            example = "2025-02-28"
    )
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La endDate es obligatoria")
    private LocalDate endDate;

    @Schema(
            description = "Descripción opcional del período académico",
            example = "Período correspondiente al segundo semestre académico"
    )
    private String description;

    @Schema(
            description = "Estado del período académico",
            example = "ACTIVE"
    )
    @NotEmpty(message = "El campo status no debe estar vacio")
    private String status;
}
