package ec.yavirac.yavigestion.modules.administration.controllers;

import ec.yavirac.yavigestion.modules.administration.dtos.request.career.CreateCareerDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.request.career.UpdateCareerDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.CareerDTO;
import ec.yavirac.yavigestion.modules.administration.services.facades.career.CareerFacade;
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
@RequestMapping("/careers")
@Tag(
    name = "Careers",
    description = "Endpoints para la gestión de carreras académicas"
)
public class CareerController {

    private final CareerFacade careerFacade;

    public CareerController(CareerFacade careerFacade) {
        this.careerFacade = careerFacade;
    }

    @Operation(
        summary = "Crear una carrera",
        description = "Registra una nueva carrera académica"
    )
    @ApiResponse(responseCode = "201", description = "Carrera creada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @PostMapping
    public ResponseEntity<GenericOnlyTextResponse> create(
            @RequestBody CreateCareerDTO careerDTO) {

        GenericOnlyTextResponse response = careerFacade.save(careerDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Listar carreras",
        description = "Obtiene un listado paginado de carreras académicas"
    )
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping
    public ResponseEntity<GenericPaginationResponse<CareerDTO>> findAll(
            @Parameter(description = "Parámetros de paginación")
            @PageableDefault(size = 20) Pageable pageable) {

        GenericPaginationResponse<CareerDTO> response = careerFacade.findAll(pageable);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Buscar carrera por ID",
        description = "Obtiene una carrera específica por su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Carrera encontrada")
    @ApiResponse(responseCode = "404", description = "Carrera no encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CareerDTO>> findOneById(
            @Parameter(description = "ID de la carrera", example = "1")
            @PathVariable Long id) {

        GenericResponse<CareerDTO> response = careerFacade.findById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Actualizar carrera",
        description = "Actualiza la información de una carrera existente"
    )
    @ApiResponse(responseCode = "200", description = "Carrera actualizada correctamente")
    @ApiResponse(responseCode = "404", description = "Carrera no encontrada")
    @PutMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateCareerDto careerDTO) {

        GenericOnlyTextResponse response = careerFacade.update(id, careerDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(
        summary = "Eliminar carrera",
        description = "Elimina una carrera académica por su ID"
    )
    @ApiResponse(responseCode = "200", description = "Carrera eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "Carrera no encontrada")
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> delete(
            @PathVariable Long id) {

        GenericOnlyTextResponse response = careerFacade.delete(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}