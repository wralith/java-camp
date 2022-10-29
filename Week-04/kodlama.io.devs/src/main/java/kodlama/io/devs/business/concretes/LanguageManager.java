package kodlama.io.devs.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.entity.Language;
import kodlama.io.devs.repository.abstracts.LanguageRepository;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void addLanguage(Language language) throws Exception {
        if (isIdExists(language.getId()))
            throw new Exception("id already exists");

        if (isNameExists(language.getName()))
            throw new Exception("name already exists");

        languageRepository.addLanguage(language);
    }

    @Override
    public Language getById(int id) throws Exception {
        if (!isIdExists(id))
            throw new Exception("id not found");
        return languageRepository.getById(id);
    }

    @Override
    public void removeLanguage(int id) throws Exception {
        if (!isIdExists(id))
            throw new Exception("id not found");

        languageRepository.removeLanguage(id);
    }

    @Override
    public void updateLanguage(int id, Language language) throws Exception {
        if (!isIdExists(language.getId()))
            throw new Exception("id not found");
        if (isNameExists(language.getName()))
            throw new Exception("name cannot be repeated");

        languageRepository.updateLanguage(id, language);
    }

    private boolean isNameExists(String name) {
        return languageRepository.getAll().stream().anyMatch(l -> l.getName() == name);
    }

    private boolean isIdExists(int id) {
        return languageRepository.getAll().stream().anyMatch(l -> l.getId() == id);
    }
}
