package dao;

import entity.Category;
import entity.Course;

public class HibernateCategoryDao extends CategoryDao {
    @Override
    public Category get(int id) {
        System.out.printf("Category with id `%d` reached with Hibernate\n", id);
        return super.get(id);
    }

    @Override
    public void add(Category category) {
        System.out.printf("Category `%s` added with Hibernate\n", category.getName());
    }
}
