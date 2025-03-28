package com.springsecurity.foods.Foods;

import com.springsecurity.foods.Bases.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodsService implements FoodsInterface{
    private final FoodsRepo foodsRepo;
    private final FoodsMapper foodsMapper;
    public FoodsService(FoodsRepo foodsRepo, FoodsMapper foodsMapper) {
        this.foodsRepo = foodsRepo;
        this.foodsMapper = foodsMapper;
    }

    @Override
    public boolean save(FoodsDto foodsDto) throws Exception {
        return false;
    }

    @Override
    public boolean update(FoodsDto foodsDto) throws Exception {
        return false;
    }

    @Override
    public Response<FoodsDto> findAll(Integer pageSize, Integer pageNumb) throws Exception {
        Pageable pageable = PageRequest.of(pageNumb, pageSize);
        Page<FoodsEntity> foodsEntities = foodsRepo.findAll(pageable);
        return foodsMapper.entityToDto(foodsEntities);
    }

}
