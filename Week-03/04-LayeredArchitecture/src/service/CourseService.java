package service;

import dao.CourseDao;
import entity.Course;
import logger.Logger;
import logger.LoggerHelper;

public class CourseService {
    private final CourseDao courseDao;
    private final Logger[] loggers;

    public CourseService(CourseDao courseDao, Logger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    public void add(Course course) throws Exception {
        if (courseDao.getByName(course.getName()) != null) {
            throw new Exception("Course with name " + course.getName() + " already exists");
        }

        courseDao.add(course);
        LoggerHelper.logEach(loggers, course.getName().concat(" course added"));
    }

    public void get(int id) {
        courseDao.get(id);
        LoggerHelper.logEach(loggers, "course with id " + id + " reached");
    }
}
