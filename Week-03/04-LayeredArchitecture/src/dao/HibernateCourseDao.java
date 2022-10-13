package dao;

import entity.Course;

public class HibernateCourseDao extends CourseDao {
    @Override
    public Course get(int id) {
        System.out.printf("Course with id `%d` reached with Hibernate\n", id);
        return super.get(id);
    }

    @Override
    public void add(Course course) {
        System.out.printf("Course `%s` added with Hibernate\n", course.getName());
    }
}
