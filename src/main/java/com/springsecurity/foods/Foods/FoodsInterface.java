package com.springsecurity.foods.Foods;
import com.springsecurity.foods.Bases.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FoodsInterface{
    boolean save(FoodsDto foodsDto) throws Exception;
    boolean update(FoodsDto foodsDto) throws Exception;
    Response<FoodsDto> findAll(Integer pageSize, Integer pageNumb) throws Exception;
}
