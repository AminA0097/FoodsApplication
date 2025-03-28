package com.springsecurity.foods.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FoodsInterface{
    boolean save(FoodsDto foodsDto) throws Exception;
    boolean update(FoodsDto foodsDto) throws Exception;
}
