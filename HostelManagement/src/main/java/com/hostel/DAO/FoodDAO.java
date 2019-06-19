package com.hostel.DAO;

import java.util.List;

import com.hostel.model.FoodModel;

public interface FoodDAO 
{
	public void addFood(FoodModel f);
	public void updateFood(FoodModel f);
	public List<FoodModel> foodList();
	public void deleteFood(int foodId);
	public FoodModel getFoodById(int foodId);
	
}
