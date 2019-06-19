package com.hostel.service;

import java.util.List;

import com.hostel.DAO.FoodDAO;
import com.hostel.model.FoodModel;

public class FoodServiceImpl implements FoodService
{
	private FoodDAO foodDAO;
	
	

	

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

	public void addFood(FoodModel f) {
		this.foodDAO.addFood(f);
		
	}

	public void updateFood(FoodModel f) {
		this.foodDAO.updateFood(f);
		
	}

	public List<FoodModel> foodList() {
	
		return this.foodDAO.foodList();
	}

	public void deleteFood(int foodId) {
		this.foodDAO.deleteFood(foodId);
		
	}

	public FoodModel getFoodById(int foodId) {
		// TODO Auto-generated method stub
		return this.foodDAO.getFoodById(foodId);
	}

}
