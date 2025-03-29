package com.springsecurity.foods.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
    @Query("select fe from CategoryEntity fe where fe.deleted <> 1 and fe.fldCategoryId =?1")
    CategoryEntity findId(Long id);
}
