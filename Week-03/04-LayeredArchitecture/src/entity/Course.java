package entity;

public class Course {
    private int id;
    private String name;
    // Why double for money? https://stackoverflow.com/a/34628503/18543470
    private double price;
    private int[] instructorIds;
    private int categoryId;

    public Course(String name, double price, int[] instructorIds, int categoryId) {
        this.name = name;
        this.price = price;
        this.instructorIds = instructorIds;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int[] getInstructorIds() {
        return instructorIds;
    }

    public void setInstructorIds(int[] instructorIds) {
        this.instructorIds = instructorIds;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
