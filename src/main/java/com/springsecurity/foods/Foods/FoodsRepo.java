package com.springsecurity.foods.Foods;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsRepo extends JpaRepository<FoodsEntity,Long> {
    @Query("select fe from FoodsEntity fe where fe.deleted <> 1")
    Page<FoodsEntity> findAll(Pageable pageable);

}
