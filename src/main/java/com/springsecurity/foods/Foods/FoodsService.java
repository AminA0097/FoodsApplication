package com.springsecurity.foods.Foods;

import com.springsecurity.foods.Bases.FoodsException;
import com.springsecurity.foods.Bases.Response;
import com.springsecurity.foods.Category.CategoryEntity;
import com.springsecurity.foods.Category.CategoryInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FoodsService implements FoodsInterface{
    private final FoodsRepo foodsRepo;
    private final FoodsMapper foodsMapper;
    private final CategoryInterface categoryInterface;
    public FoodsService(FoodsRepo foodsRepo, FoodsMapper foodsMapper, CategoryInterface categoryInterface) {
        this.foodsRepo = foodsRepo;
        this.foodsMapper = foodsMapper;
        this.categoryInterface = categoryInterface;
    }
    @Override
    public boolean save(FoodsForm foodsForm) throws Exception {
        CategoryEntity categoryEntity = categoryInterface.findCategory(foodsForm.getFoodCategory());
        if(foodsForm.getId() != -1){
            FoodsEntity foodsEntity = loadAsEntity(foodsForm.getId());
            foodsEntity.setFldFoodsDesc(foodsForm.getFoodDescription());
            foodsEntity.setFldFoodsName(foodsForm.getFoodName());
            foodsEntity.setCategoryEntity(categoryEntity);
            foodsEntity.setDeleted(false);
            foodsEntity.setCreated("Amin");
            foodsEntity.setUpdated("Amin");
            foodsEntity.setCreatedDate(new Date());
            foodsEntity.setUpdatedDate(new Date());
            foodsRepo.save(foodsEntity);
        }
        else {
            FoodsEntity foodsEntity = new FoodsEntity();
            foodsEntity.setCategoryEntity(categoryEntity);
            foodsEntity.setFldFoodsName(foodsForm.getFoodName());
            foodsEntity.setFldFoodsDesc(foodsForm.getFoodDescription());
            foodsEntity.setDeleted(false);
            foodsEntity.setCreated("Amin");
            foodsEntity.setUpdated("Amin");
            foodsEntity.setCreatedDate(new Date());
            foodsEntity.setUpdatedDate(new Date());
            foodsRepo.save(foodsEntity);
        }
        return true;
    }
    @Override
    public Response<FoodsDto> findAll(Integer pageSize, Integer pageNumb) throws Exception {
        Pageable pageable = PageRequest.of(pageNumb -1, pageSize);
        Page<FoodsEntity> foodsEntities = foodsRepo.findAll(pageable);
        if(pageNumb > foodsEntities.getTotalPages()){
            throw new FoodsException("No more pages");
        }
        return foodsMapper.entityToDto(foodsEntities);
    }
    @Override
    public FoodsEntity loadAsEntity(Long id) throws Exception {
        return foodsRepo.findId(id);
    }
    @Override
    public String delete(Long id)throws Exception {
        FoodsEntity foodsEntity = loadAsEntity(id);
        foodsEntity.setDeleted(true);
        foodsEntity.setUpdated("Amin");
        foodsEntity.setUpdatedDate(new Date());
        foodsRepo.save(foodsEntity);
        return "";
    }
}
