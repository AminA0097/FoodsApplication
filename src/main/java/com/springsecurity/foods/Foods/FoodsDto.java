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
    private String fldCategoryName;

    public String getFldCategoryName() {
        return fldCategoryName;
    }

    public void setFldCategoryName(String fldCategoryName) {
        this.fldCategoryName = fldCategoryName;
    }
}
