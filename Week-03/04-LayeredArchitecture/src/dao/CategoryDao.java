package dao;

import entity.Category;

public abstract class CategoryDao implements Dao<Category> {
    @Override
    public Category get(int id) {
        System.out.printf("Category with id `%s` reached.\n", id);
        return new Category("Programming");
    }

    public Category getByName(String name) {
        System.out.printf("Category with name `%s` reached.\n", name);
        // Mocking unique value
        if (name.equals("programming")) {
            return new Category("programming");
        }
        return null;
    }

    @Override
    public void add(Category category) {
        System.out.printf("Category `%s` is added.\n", category.getName());
    }

    @Override
    public void update(Category category) {
        System.out.printf("Category `%s` updated.\n", category.getName());
    }

    @Override
    public void delete(Category category) {
        System.out.printf("Category `%s` deleted.\n", category.getName());

    }
}
