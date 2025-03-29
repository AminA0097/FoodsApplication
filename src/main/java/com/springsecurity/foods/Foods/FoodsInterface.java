package com.springsecurity.foods.Foods;
import com.springsecurity.foods.Bases.Response;


public interface FoodsInterface{
    boolean save(FoodsForm foodsForm) throws Exception;
    Response<FoodsDto> findAll(Integer pageSize, Integer pageNumb) throws Exception;
    FoodsEntity loadAsEntity(Long id) throws Exception;
    String delete(Long id) throws Exception;

}
