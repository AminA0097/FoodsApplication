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

@Service
public class FoodsMapper {
    private static final Logger log = LoggerFactory.getLogger(FoodsMapper.class);

    public Response<FoodsDto> entityToDto(Page<FoodsEntity> entityList) {
        List<FoodsDto> dtoList = new ArrayList<>();

        for (FoodsEntity entity : entityList) {
            FoodsDto dto = new FoodsDto();
            Class<?> clazz = entity.getClass();
            while (clazz != null) {
                for (Field field : clazz.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(entity);
                        if (value!= null && value.getClass().isAnnotationPresent(Entity.class)) {
                            String entityName = value.getClass().getSimpleName();
                            String fieldName = "fld" + entityName.replace("Entity", "Name");
                            try {
                                Field fieldDto = FoodsDto.class.getDeclaredField(fieldName);
                                Field fieldDtoDto = value.getClass().getDeclaredField(fieldName);
                                fieldDtoDto.setAccessible(true);
                                fieldDto.setAccessible(true);
                                Object t = fieldDtoDto.get(value);
                                fieldDto.set(dto, t);
                            }catch (NoSuchFieldException e){
                                log.warn("Field {} not found in DTO", field.getName());
                            }
                        }
                        try {
                            Field fieldDto = FoodsDto.class.getDeclaredField(field.getName());
                            fieldDto.setAccessible(true);
                            fieldDto.set(dto, value);
                        } catch (NoSuchFieldException e) {
                            log.warn("Field {} not found in DTO", field.getName());
                        }
                    } catch (IllegalAccessException e) {
                        log.warn("Field {} not accessible", field.getName());
                    }
                }
                clazz = clazz.getSuperclass();
            }

            dtoList.add(dto);
        }
        Response<FoodsDto > response = new Response<>();
        response.setContent(dtoList);
        response.setTotal(entityList.getTotalElements());
        response.setPageNumber(entityList.getNumber());
        response.setPageSize(entityList.getSize());
        response.setTotalPages(entityList.getTotalPages());
        return response;
    }
}
