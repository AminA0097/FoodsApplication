package com.springsecurity.foods.Foods;
import com.springsecurity.foods.Bases.BaseEntity;
import com.springsecurity.foods.Category.CategoryEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "FOODSTABLE")
public class FoodsEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "foods_seq", sequenceName = "generic_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foods_seq")
    @Column(name = "fld_foods_id")
    private long fldFoodsId;
    public long getFldFoodsId() {
        return fldFoodsId;
    }
    public void setFldFoodsId(long fldFoodsId) {
        this.fldFoodsId = fldFoodsId;
    }
    @Column(name = "fld_foods_name")
    private String fldFoodsName;
    public String getFldFoodsName() {
        return fldFoodsName;
    }
    public void setFldFoodsName(String fldFoodsName) {
        this.fldFoodsName = fldFoodsName;
    }
    @Column(name = "fld_foods_desc")
    private String fldFoodsDesc;
    public String getFldFoodsDesc() {
        return fldFoodsDesc;
    }
    public void setFldFoodsDesc(String fldFoodsDesc) {
        this.fldFoodsDesc = fldFoodsDesc;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fld_category_id")
    private CategoryEntity categoryEntity;
    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }
    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
