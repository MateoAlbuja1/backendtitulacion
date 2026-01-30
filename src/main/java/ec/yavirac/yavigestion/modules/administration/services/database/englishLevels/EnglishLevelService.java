package ec.yavirac.yavigestion.modules.administration.services.database.englishLevels;

import ec.yavirac.yavigestion.modules.administration.entities.EnglishLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnglishLevelService {

    // INSERT
    EnglishLevel save(EnglishLevel entity);

    // SELECT
    Page<EnglishLevel> findAll(Pageable pageable);
}
