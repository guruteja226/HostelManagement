package com.hostel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FoodItems")
public class FoodModel 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int foodId;
	private String foodName;
	private String session;
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "FoodModel [foodId=" + foodId + ", foodName=" + foodName + ", session=" + session + "]";
	}
	
	
	
}
