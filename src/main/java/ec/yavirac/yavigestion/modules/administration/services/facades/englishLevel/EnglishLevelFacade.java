package ec.yavirac.yavigestion.modules.administration.services.facades.englishLevel;

import ec.yavirac.yavigestion.modules.administration.dtos.request.englishLevel.CreateEnglishLevelDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.response.EnglishLevelDTO;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericPaginationResponse;
import org.springframework.data.domain.Pageable;

public interface EnglishLevelFacade {

    // INSERT
    GenericOnlyTextResponse save(CreateEnglishLevelDTO dto);

    // SELECT
    GenericPaginationResponse<EnglishLevelDTO> findAll(Pageable pageable);
}
