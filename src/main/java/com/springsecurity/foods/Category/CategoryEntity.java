package com.springsecurity.foods.Category;

import com.springsecurity.foods.Bases.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORYTABLE")
public class CategoryEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "generic_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @Column(name = "fld_category_id")
    private long fldFoodsId;
    public long getFldFoodsId() {
        return fldFoodsId;
    }
    public void setFldFoodsId(long fldFoodsId) {
        this.fldFoodsId = fldFoodsId;
    }
    @Column(name = "fld_Category_Name")
    private String fldCategoryName;
    public String getFldCategoryName() {
        return fldCategoryName;
    }
    public void setFldCategoryName(String fldCategoryName) {
        this.fldCategoryName = fldCategoryName;
    }
    @Column(name = "fld_Category_Desc")
    private String fldCategoryDesc;
    public String getFldCategoryDesc() {
        return fldCategoryDesc;
    }
    public void setFldCategoryDesc(String fldCategoryDesc) {
        this.fldCategoryDesc = fldCategoryDesc;
    }
}

