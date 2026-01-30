package ec.yavirac.yavigestion.modules.administration.services.facades.englishLevel;

import ec.yavirac.yavigestion.modules.administration.dtos.request.englishLevel.CreateEnglishLevelDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.response.EnglishLevelDTO;
import ec.yavirac.yavigestion.modules.administration.entities.EnglishLevel;
import ec.yavirac.yavigestion.modules.administration.services.database.englishLevels.EnglishLevelService;
import ec.yavirac.yavigestion.modules.core.consts.StatusConst;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericPaginationResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j2
public class EnglishLevelFacadeImpl implements EnglishLevelFacade {

    private final EnglishLevelService englishLevelService;

    public EnglishLevelFacadeImpl(
            @Qualifier("englishLevelServiceImpl") EnglishLevelService englishLevelService
    ) {
        this.englishLevelService = englishLevelService;
    }

    @Override
    public GenericOnlyTextResponse save(CreateEnglishLevelDTO dto) {
        log.info("EnglishLevelFacadeImpl::save");

        EnglishLevel entity = new EnglishLevel();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus() == null ? StatusConst.ACTIVE : dto.getStatus());

        EnglishLevel saved = englishLevelService.save(entity);

        if (saved == null) {
            return GenericOnlyTextResponse.builder()
                    .status(500)
                    .message("No se pudo guardar el nivel de inglés")
                    .build();
        }

        return GenericOnlyTextResponse.builder()
                .status(201)
                .message("Se ha creado exitosamente")
                .build();
    }

    @Override
    public GenericPaginationResponse<EnglishLevelDTO> findAll(Pageable pageable) {
        log.info("EnglishLevelFacadeImpl::findAll");

        Page<EnglishLevel> page = englishLevelService.findAll(pageable);

        List<EnglishLevelDTO> data = page.getContent().stream()
                .map(level -> EnglishLevelDTO.builder()
                        .id(level.getId())
                        .code(level.getCode())
                        .description(level.getDescription())
                        .status(level.getStatus())
                        .build()
                )
                .collect(Collectors.toList());

        return GenericPaginationResponse.<EnglishLevelDTO>builder()
                .status(200)
                .currentPage(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .data(data)
                .build();
    }
}
