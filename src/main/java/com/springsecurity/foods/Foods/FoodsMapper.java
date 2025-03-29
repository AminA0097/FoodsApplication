package com.springsecurity.foods.Foods;

import com.springsecurity.foods.Bases.Response;
import jakarta.persistence.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodsMapper {
    private static final Logger log = LoggerFactory.getLogger(FoodsMapper.class);

    public Response<FoodsDto> entityToDto(Page<FoodsEntity> entity) {
        Response<FoodsDto > response = new Response<>();
        List<FoodsDto> dtos = entity.stream().map(FoodsDto::new).collect(Collectors.toList());
        response.setContent(dtos);
        response.setTotal(entity.getTotalElements());
        response.setPageNumber(entity.getNumber() + 1);
        response.setPageSize(entity.getSize());
        response.setTotalPages(entity.getTotalPages());
        return response;
    }

}
