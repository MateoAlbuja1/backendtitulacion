package ec.yavirac.yavigestion.modules.auth.dtos.request;


import ec.yavirac.yavigestion.modules.administration.enums.BloodType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Schema(description = "Información personal asociada al usuario")
public class PersonDto {
    @Schema(
            description = "Identificador de la persona",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;
    @Schema(description = "Nombres de la persona", example = "Juan")
    private String name;
    @Schema(description = "Apellidos de la persona", example = "Pérez")
    private String lastname;
    @Schema(description = "Número de cédula", example = "0102030405")
    private String dni;
    @Schema(description = "Teléfono de contacto", example = "0999999999")
    private String phonenumber;
    @Schema(description = "Dirección domiciliaria", example = "Quito")
    private String address;
    @Schema(
            description = "Tipo de sangre",
            example = "O_POSITIVE",
            allowableValues = {
                    "O_POSITIVE", "O_NEGATIVE",
                    "A_POSITIVE", "A_NEGATIVE",
                    "B_POSITIVE", "B_NEGATIVE",
                    "AB_POSITIVE", "AB_NEGATIVE"
            }
    )
    private BloodType bloodtype;
    @Schema(description = "Género", example = "M")
    private String gender;
    @Schema(description = "Fecha de nacimiento (YYYY-MM-DD)", example = "1990-01-01")
    private LocalDate birthdate;
    @Schema(description = "Correo personal", example = "juan@test.com")
    private String email;
    @Schema(
            description = "Estado del registro",
            example = "ACTIVE",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String status;
}
