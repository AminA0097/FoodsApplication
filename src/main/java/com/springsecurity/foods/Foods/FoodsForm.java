package com.springsecurity.foods.Foods;

public class FoodsForm {
    private long id;
    private String foodName;
    private String foodDescription;
    private long foodCategory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public long getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(long foodCategory) {
        this.foodCategory = foodCategory;
    }
}
