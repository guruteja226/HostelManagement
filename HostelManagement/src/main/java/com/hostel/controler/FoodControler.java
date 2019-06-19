package com.hostel.controler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hostel.model.FoodModel;
import com.hostel.service.FoodService;

@Controller
public class FoodControler 
{
	@Autowired
	@Qualifier(value="foodService")
	private FoodService foodService;

	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	
	@RequestMapping(value="hostel/foodList", method=RequestMethod.GET)
	public String foodList(Model model)
	{
		model.addAttribute("food", new FoodModel());
		model.addAttribute("foodList", this.foodService.foodList());
		return "food";
	}
	
	@RequestMapping(value="hostel/food/add",method=RequestMethod.GET)
	private String addFood(@ModelAttribute("food") FoodModel f) 
	{
		if(f.getFoodId()==0)
		{
			this.foodService.addFood(f);
		}else
		{
			this.foodService.updateFood(f);
		}
		 return "Redirect:/hostel/foodList";
	}
	
	@RequestMapping(value="/food/remove/{foodId}")
	public String deleteFood(@PathVariable("foodId") int foodId)
	{
		this.foodService.deleteFood(foodId);
		
		return "Redirect:/hostel/foodList";
		
	}
	
	@RequestMapping(value="/food/edit/{foodId}")
	public String editFood(@PathVariable("foodId") int foodId,Model model)
	{
		model.addAttribute("food", this.foodService.getFoodById(foodId));
		model.addAttribute("foodList", this.foodService.foodList());
		
		return "food";
		
	}
}
