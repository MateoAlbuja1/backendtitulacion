package ec.yavirac.yavigestion.modules.administration.dtos.request.user;

import ec.yavirac.yavigestion.modules.auth.dtos.request.PersonDto;
import ec.yavirac.yavigestion.modules.auth.entities.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Builder
@Schema(description = "Información necesaria para la creación de un usuario")
public class CreateUserDTO {

    @Schema(
            description = "Correo electrónico del usuario",
            example = "usuario@test.com"
    )
    private String email;

    @Schema(
            description = "Fecha y hora de creación del usuario",
            example = "2024-01-15T10:30:00Z",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Instant createdAt;

    @Schema(
            description = "Roles asignados al usuario",
            example = "[\"ADMIN\", \"USER\"]"
    )
    private Set<Role> roles;

    @Schema(
            description = "Información personal asociada al usuario"
    )
    private PersonDto person;

    @Schema(
            description = "Estado del usuario",
            example = "ACTIVE"
    )
    private String status;

    @Schema(
            description = "Contraseña del usuario",
            example = "P@ssw0rd123"
    )
    private String password;
}
