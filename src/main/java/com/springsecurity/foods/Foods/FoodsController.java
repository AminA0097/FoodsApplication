package com.springsecurity.foods.Foods;
import com.springsecurity.foods.Bases.Response;
import org.springframework.web.bind.annotation.*;

@RequestMapping("foods/")
@RestController

public class FoodsController {
    private final FoodsInterface foodsInterface;
    public FoodsController(FoodsInterface foodsInterface) {
        this.foodsInterface = foodsInterface;
    }
    @PostMapping("/addnew")
    public String addFood(@RequestBody FoodsForm foodsForm)throws Exception{
        foodsInterface.save(foodsForm);
        return "Successfully added food!";
    }
    @GetMapping("/getfoods/{pageNumb}")
    public Response<FoodsDto> getFoods(@PathVariable(name = "pageNumb",required = false)Integer pageNumb ) throws Exception {
        return foodsInterface.findAll(5,pageNumb);
    }
    @PostMapping("/del/{foodid}")
    public String delFood(@PathVariable("foodid")Long id)throws Exception{
        return foodsInterface.delete(id);
    }
}
