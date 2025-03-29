package com.springsecurity.foods.Foods;

import com.springsecurity.foods.Category.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsRepo extends JpaRepository<FoodsEntity,Long> {
    @Query("select fe from FoodsEntity fe where fe.deleted <> true ")
    Page<FoodsEntity> findAll(Pageable pageable);
    @Query("select fe from FoodsEntity fe where fe.deleted <> true and fe.fldFoodsId =?1")
    FoodsEntity findId(Long id);

}
