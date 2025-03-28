package com.springsecurity.foods.Foods;
import com.springsecurity.foods.Category.CategoryEntity;

public class FoodsDto {
    private String fldFoodsName;
    public String getFldFoodsName() {
        return fldFoodsName;
    }
    public void setFldFoodsName(String fldFoodsName) {
        this.fldFoodsName = fldFoodsName;
    }
    private String fldFoodsDesc;
    public String getFldFoodsDesc() {
        return fldFoodsDesc;
    }
    public void setFldFoodsDesc(String fldFoodsDesc) {
        this.fldFoodsDesc = fldFoodsDesc;
    }
    private CategoryEntity categoryEntity;
    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
