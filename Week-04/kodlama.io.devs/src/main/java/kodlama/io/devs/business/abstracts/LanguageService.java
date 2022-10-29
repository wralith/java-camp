package kodlama.io.devs.business.abstracts;

import java.util.List;
import kodlama.io.devs.entity.Language;

public interface LanguageService {
    List<Language> getAll();

    Language getById(int id) throws Exception;

    void addLanguage(Language language) throws Exception;

    void updateLanguage(int id, Language language) throws Exception;

    void removeLanguage(int id) throws Exception;
}
