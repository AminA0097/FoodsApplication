package com.springsecurity.foods.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FoodsInterface{
    boolean save(FoodsDto foodsDto) throws Exception;
    boolean update(FoodsDto foodsDto) throws Exception;
    List<FoodsDto> findAll(Integer pageSize,Integer pageNumb) throws Exception;
}
