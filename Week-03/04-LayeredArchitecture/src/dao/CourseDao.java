package dao;

import entity.Course;

public abstract class CourseDao implements Dao<Course> {
    @Override
    public Course get(int id) {
        System.out.printf("Course with id `%d` reached.\n", id);
        return new Course("Dummy", 9.5, new int[]{1, 2}, 1);
    }

    public Course getByName(String name) {
        System.out.printf("Course with name `%s` reached.\n", name);
        // Mocking unique value
        if (name.equals("java") || name.equals("go")) {
            return new Course("java", 10, new int[]{1}, 1);
        }
        return null;
    }

    @Override
    public void add(Course course) {
        System.out.printf("Course `%s` is added.\n", course.getName());
    }

    @Override
    public void update(Course course) {
        System.out.printf("Course `%s` is updated.\n", course.getName());
    }

    @Override
    public void delete(Course course) {
        System.out.printf("Course `%s` is deleted.\n", course.getName());
    }
}
