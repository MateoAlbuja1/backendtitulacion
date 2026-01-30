package ec.yavirac.yavigestion.modules.administration.services.database.englishLevels;

import ec.yavirac.yavigestion.modules.administration.entities.EnglishLevel;
import ec.yavirac.yavigestion.modules.administration.repositories.EnglishLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnglishLevelServiceImpl implements EnglishLevelService {

    private final EnglishLevelRepository repository;

    @Override
    public EnglishLevel save(EnglishLevel englishLevel) {
        // INSERT
        return repository.save(englishLevel);
    }

    @Override
    public Page<EnglishLevel> findAll(Pageable pageable) {
        // SELECT
        return repository.findAll(pageable);
    }
}
