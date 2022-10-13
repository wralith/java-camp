import dao.CategoryDao;
import dao.CourseDao;
import dao.HibernateCategoryDao;
import dao.HibernateCourseDao;
import entity.Category;
import entity.Course;
import logger.ConsoleLogger;
import logger.DatabaseLogger;
import logger.FileLogger;
import logger.Logger;
import service.CategoryService;
import service.CourseService;

public class Main {
    public static void main(String[] args) {
        Logger[] loggers = new Logger[]{
                new ConsoleLogger(), new DatabaseLogger(), new FileLogger()
        };

        System.out.println("Courses");
        CourseManualTest(loggers);

        System.out.println("------\n");

        System.out.println("Categories");
        CategoriesManualTest(loggers);
    }

    private static void CourseManualTest(Logger[] loggers) {
        // Inject
        CourseDao courseDao = new HibernateCourseDao();
        CourseService courseService = new CourseService(courseDao, loggers);

        // Dummy course with name "java"
        Course javaCourse = new Course("java", 5.5, new int[]{1, 2}, 1);
        // Invalid to add, mocking "name already exists"
        Course pythonCourse = new Course("python", 3.5, new int[]{3}, 1);

        Course[] courses = {javaCourse, pythonCourse};

        for (Course course : courses) {
            try {
                courseService.add(course);
            } catch (Exception e) {
                ConsoleLogger.logErr(e.getMessage());
            }
        }

        courseService.get(12);
    }

    private static void CategoriesManualTest(Logger[] loggers) {
        // Inject
        CategoryDao categoryDao = new HibernateCategoryDao();
        CategoryService categoryService = new CategoryService(categoryDao, loggers);

        Category architectureCategory = new Category("architecture");
        // Invalid to add, mocking "name already exists"
        Category programmingCategory = new Category("programming");

        Category[] categories = {architectureCategory, programmingCategory};

        for (Category category : categories) {
            try {
                categoryService.add(category);
            } catch (Exception e) {
                ConsoleLogger.logErr(e.getMessage());
            }
        }

        categoryService.get(12);
    }
}