package ec.yavirac.yavigestion.modules.administration.controllers;

import ec.yavirac.yavigestion.modules.administration.dtos.request.englishLevel.CreateEnglishLevelDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.response.EnglishLevelDTO;
import ec.yavirac.yavigestion.modules.administration.services.facades.englishLevel.EnglishLevelFacade;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericPaginationResponse;
import ec.yavirac.yavigestion.modules.auth.decorators.HasPermission;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Niveles de Inglés",
        description = "Operaciones relacionadas con la gestión de niveles de inglés"
)
@RestController
@RequestMapping("/english-levels")
public class EnglishLevelController {

    @Qualifier("englishLevelFacadeImpl")
    private final EnglishLevelFacade englishLevelFacade;

    public EnglishLevelController(EnglishLevelFacade englishLevelFacade) {
        this.englishLevelFacade = englishLevelFacade;
    }


    // INSERT

    @PostMapping
    @HasPermission("english-level:create")
    public ResponseEntity<GenericOnlyTextResponse> create(@RequestBody CreateEnglishLevelDTO dto) {
        GenericOnlyTextResponse response = englishLevelFacade.save(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }


    // SELECT (

    @GetMapping
    @HasPermission("english-level:read")
    public ResponseEntity<GenericPaginationResponse<EnglishLevelDTO>> findAll(Pageable pageable) {
        GenericPaginationResponse<EnglishLevelDTO> response = englishLevelFacade.findAll(pageable);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
