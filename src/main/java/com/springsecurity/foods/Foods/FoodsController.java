package com.springsecurity.foods.Foods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("foods/")
@Controller
public class FoodsController {
    private final FoodsInterface foodsInterface;
    public FoodsController(FoodsInterface foodsInterface) {
        this.foodsInterface = foodsInterface;
    }
    @PostMapping("/post")
    public String addFood(@RequestBody FoodsForm foodsForm)throws Exception{
        foodsInterface.save(foodsForm);
        return "Foods/Foods";
    }
    @GetMapping("/getfoods/{pageNumb}")
    public String getFoods(@PathVariable("pageNumb")Integer pageNumb ) throws Exception {
        foodsInterface.findAll(5,pageNumb);
        return "Foods/Foods";
    }
    @GetMapping("/addnew")
    public String addNewFood()throws Exception{
        return "Foods/Foods";
    }
}
