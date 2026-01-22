package ec.yavirac.yavigestion.modules.administration.controllers;

import ec.yavirac.yavigestion.modules.administration.dtos.request.academicPeriods.CareerByPeriodDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.request.academicPeriods.CreateAcademicPeriodDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.request.academicPeriods.UpdateAcademicPeriodDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.response.AcademicPeriodDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.response.CareerAcademicPeriodDTO;
import ec.yavirac.yavigestion.modules.administration.services.facades.academicPeriod.AcademicPeriodFacade;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericPaginationResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/periods")
@Tag(
    name = "Academic Periods",
    description = "Gestión de períodos académicos y asignación de carreras"
)
public class AcademicPeriodController {

    private final AcademicPeriodFacade academicPeriodFacade;

    public AcademicPeriodController(AcademicPeriodFacade academicPeriodFacade) {
        this.academicPeriodFacade = academicPeriodFacade;
    }

    @Operation(
        summary = "Crear período académico",
        description = "Registra un nuevo período académico"
    )
    @ApiResponse(responseCode = "201", description = "Período creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @PostMapping
    public ResponseEntity<GenericOnlyTextResponse> create(
            @RequestBody CreateAcademicPeriodDTO academicPeriodDTO) {

        GenericOnlyTextResponse response = academicPeriodFacade.save(academicPeriodDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Listar períodos académicos",
        description = "Obtiene un listado paginado de períodos académicos"
    )
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping
    public ResponseEntity<GenericPaginationResponse<AcademicPeriodDTO>> findAll(
            @Parameter(description = "Parámetros de paginación")
            @PageableDefault(size = 20) Pageable pageable) {

        GenericPaginationResponse<AcademicPeriodDTO> response = academicPeriodFacade.findAll(pageable);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Buscar período por ID",
        description = "Obtiene un período académico por su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Período encontrado")
    @ApiResponse(responseCode = "404", description = "Período no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<AcademicPeriodDTO>> findOneById(
            @Parameter(description = "ID del período académico", example = "1")
            @PathVariable Long id) {

        GenericResponse<AcademicPeriodDTO> response = academicPeriodFacade.findById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Obtener carreras de un período",
        description = "Lista las carreras asociadas a un período académico"
    )
    @ApiResponse(responseCode = "200", description = "Carreras obtenidas correctamente")
    @ApiResponse(responseCode = "404", description = "Período no encontrado")
    @GetMapping("/{id}/career")
    public ResponseEntity<GenericResponse<CareerAcademicPeriodDTO>> findCareersPeriod(
            @Parameter(description = "ID del período académico", example = "1")
            @PathVariable Long id) {

        GenericResponse<CareerAcademicPeriodDTO> response =
                academicPeriodFacade.findCareersByPeriod(id);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Actualizar período académico",
        description = "Actualiza la información de un período académico existente"
    )
    @ApiResponse(responseCode = "200", description = "Período actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Período no encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateAcademicPeriodDTO academicPeriodDTO) {

        GenericOnlyTextResponse response =
                academicPeriodFacade.update(id, academicPeriodDTO);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Asignar carreras a un período",
        description = "Asocia una o varias carreras a un período académico"
    )
    @ApiResponse(responseCode = "200", description = "Carreras asignadas correctamente")
    @ApiResponse(responseCode = "404", description = "Período no encontrado")
    @PutMapping("/{id}/assignCareer")
    public ResponseEntity<GenericOnlyTextResponse> assignCareers(
            @Parameter(description = "ID del período académico", example = "1")
            @PathVariable Long id,
            @RequestBody CareerByPeriodDTO academicPeriodDTO) {

        GenericOnlyTextResponse response =
                academicPeriodFacade.assignCareers(id, academicPeriodDTO);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Eliminar período académico",
        description = "Elimina un período académico por su ID"
    )
    @ApiResponse(responseCode = "200", description = "Período eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Período no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> delete(
            @PathVariable Long id) {

        GenericOnlyTextResponse response = academicPeriodFacade.delete(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}