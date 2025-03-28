package com.springsecurity.foods.Foods;

import com.springsecurity.foods.Bases.Response;
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
    public Response<FoodsDto> getFoods() throws Exception {
        return foodsInterface.findAll(5,0);
    }
}
