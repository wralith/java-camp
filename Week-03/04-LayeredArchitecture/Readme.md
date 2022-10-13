# Layered Architecture

## Entity

Entity layer consist of data models which usually have corresponding data schema in the database, so when the entity
created mostly it represent one rows in the database.

```java
public class Category {
    private int id;
    private String name;
}
```

## Data Access Layer

This layer is responsible to interact with database with the defined entities.

```java
public interface Dao<T> {
    T get(int id);

    T add(T t);

    T update(T t);

    void delete(T t);
}
```

## Service

Service layer uses data access objects, and it is responsible for doing the business tasks such as validation, logging
etc.

```java
public class CourseService {
    public void add(Course course) throws Exception {
        if (courseDao.getByName(course.getName()) != null) {
            throw new Exception("Course with name " + course.getName() + " already exists");
        }

        courseDao.add(course);
        LoggerHelper.logEach(loggers, course.getName().concat(" course added"));
    }
}
```