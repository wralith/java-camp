package kodlama.io.devs.repository.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import kodlama.io.devs.entity.Language;
import kodlama.io.devs.repository.abstracts.LanguageRepository;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(0, "Go"));
        languages.add(new Language(1, "C++"));
        languages.add(new Language(2, "Rust"));
        languages.add(new Language(3, "Java"));
        languages.add(new Language(4, "Python"));
        languages.add(new Language(5, "Javascript"));
        languages.add(new Language(6, "C#"));
        languages.add(new Language(7, "Haskell"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getById(int id) {
        return languages.stream().filter(l -> l.getId() == id).findFirst().orElseThrow();
    }

    @Override
    public void addLanguage(Language language) {
        languages.add(language);

    }

    @Override
    public void updateLanguage(int id, Language language) {
        Language existingLanguage =
                languages.stream().filter(l -> l.getId() == id).findFirst().orElseThrow();
        existingLanguage.setName(language.getName());
    }

    @Override
    public void removeLanguage(int id) {
        languages.removeIf(l -> l.getId() == id);
    }


}
