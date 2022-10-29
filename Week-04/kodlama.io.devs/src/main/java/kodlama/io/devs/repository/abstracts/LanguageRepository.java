package kodlama.io.devs.repository.abstracts;

import java.util.List;
import kodlama.io.devs.entity.Language;

public interface LanguageRepository {
    List<Language> getAll();

    Language getById(int id);

    void addLanguage(Language language);

    void updateLanguage(int id, Language language);

    void removeLanguage(int id);
}
