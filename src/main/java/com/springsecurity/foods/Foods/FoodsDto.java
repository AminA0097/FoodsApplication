package com.springsecurity.foods.Foods;
import com.springsecurity.foods.Category.CategoryEntity;

public class FoodsDto {
    private String foodName;
    private String foodDescription;
    private long id;
    private String categoryName;
    private long categoryid;


    public FoodsDto(FoodsEntity foodsEntity) {
        this.id = foodsEntity.getFldFoodsId();
        this.foodName = foodsEntity.getFldFoodsName() == null ? "" : foodsEntity.getFldFoodsName();
        this.foodDescription = foodsEntity.getFldFoodsDesc() == null ? "" : foodsEntity.getFldFoodsDesc();
        this.categoryid = foodsEntity.getCategoryEntity().getFldCategoryId();
        this.categoryName = foodsEntity.getCategoryEntity().getFldCategoryName() == null ? "" : foodsEntity.getCategoryEntity().getFldCategoryName();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }
}
