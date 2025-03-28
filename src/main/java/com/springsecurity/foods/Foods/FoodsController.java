package com.springsecurity.foods.Foods;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("Foods/")
@RestController

public class FoodsController {
    private final FoodsInterface foodsInterface;
    public FoodsController(FoodsInterface foodsInterface) {
        this.foodsInterface = foodsInterface;
    }
    @GetMapping("/getfoods")
    public List<FoodsDto> getFoods() throws Exception {
        return foodsInterface.findAll(4,0);
    }
}
