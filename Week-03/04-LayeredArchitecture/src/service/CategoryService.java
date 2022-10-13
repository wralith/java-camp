package service;

import dao.CategoryDao;
import entity.Category;
import logger.Logger;
import logger.LoggerHelper;

public class CategoryService {
    private final CategoryDao categoryDao;
    private final Logger[] loggers;

    public CategoryService(CategoryDao categoryDao, Logger[] loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }

    public void add(Category category) throws Exception {
        if (categoryDao.getByName(category.getName()) != null) {
            throw new Exception("Category with name " + category.getName() + " already exists");
        }

        categoryDao.add(category);
        LoggerHelper.logEach(loggers, category.getName().concat(" category added"));
    }

    public void get(int id) {
        categoryDao.get(id);
        LoggerHelper.logEach(loggers, "category with id " + id + " reached");
    }
}
