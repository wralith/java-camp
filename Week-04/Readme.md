# Architecture

## Entity

For Entity object I created `Language` class with two values: `id` and `name`.  
While defining `Language` entity I leveraged three annotations from `Lombok` library.

- `@Getter`
- `@Setter`
- `@AllArgsConstructor`

Entity object look exactly like this:

```java
@Getter
@Setter
@AllArgsConstructor
public class Language {
    private int id;
    private String name;
}
```

## Repository

Repository layer is where we generally interact with the database. For this demo project I imitated the in memory database with `ArrayList` object.

```java
List<Language> languages;
languages = new ArrayList<Language>();
```

Also, in `Repository` layer we define some methods to interact with that object.

- `getAll()`: Returns all the `Languages` inside `ArrayList`
- `getById(id)`: Returns one if id match
- `addLanguage(language)`: Takes `Language` object as parameter and add it into the `ArrayList`
- `updateLanguage(id, language)`: Takes `id` and `Language` object and updates the `Language` object with the new one where id match
- `removeLanguage(id)`: Remove a language if id match

## Service

In service layer we inject `Repository` and use the methods we defined there. This is the layer that we can implement business logics in this example I created two validation methods and validate the requests before sending it to the `Repository` layer. If they are not valid or not in the form that i want then i throw exception.

### Validation

I created two method that check if `id` or `name` exists in the repository. Actually both of them uses `Repository` methods directly without an extra in order to validate, which makes me wonder if I should implemented them inside the `Repository` layer. Anyway there are methods which leverages `stream()` and `lambda` functions.

```java
private boolean isNameExists(String name) {
    return languageRepository.getAll().stream().anyMatch(l -> l.getName() == name);
}

private boolean isIdExists(int id) {
    return languageRepository.getAll().stream().anyMatch(l -> l.getId() == id);
}
```

## Controller

This is the layer where `Spring` magic happens, I am still not sure if I like that amount of magic or not. Tool for the magic is `Annotations`.

In `Controller` layer we define endpoints and match them with their corresponding methods in `Service` layer. For example:

```java
@GetMapping("/{id}")
public Language getById(@PathVariable(name = "id") int id) throws Exception {
    return languageService.getById(id);
}
```

### EndPoints

- `GET` : `api/languages/` - Get all languages
- `GET` : `api/languages/{id}` - Get a language with `id`
- `POST` : `api/languages/` - Create new language
- `PUT` : `api/languages/{id}` - Update an existing language
- `DELETE` : `api/languages/{id}` - Delete a language with `id`

Request body for language entity

```json
{
    "id": int,
    "name": string
}
```
