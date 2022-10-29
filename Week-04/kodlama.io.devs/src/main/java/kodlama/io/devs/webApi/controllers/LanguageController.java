package kodlama.io.devs.webApi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.entity.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public Language getById(@PathVariable(name = "id") int id) throws Exception {
        return languageService.getById(id);
    }

    @PostMapping
    public String add(@RequestBody Language language) throws Exception {
        languageService.addLanguage(language);
        return ("added");
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) throws Exception {
        languageService.removeLanguage(id);
        return ("deleted!");
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable int id, @RequestBody Language language) throws Exception {
        languageService.updateLanguage(id, language);
    }
}
