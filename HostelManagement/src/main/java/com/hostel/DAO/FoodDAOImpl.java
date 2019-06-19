package com.hostel.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hostel.model.FoodModel;

@Repository
public class FoodDAOImpl implements FoodDAO
{
	private static final Logger logger=LoggerFactory.getLogger(FoodDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void addFood(FoodModel f) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(f);
		logger.info("addFood Method called and the result is "+f);
		
	}

	public void updateFood(FoodModel f) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(f);
		logger.info("Update method called and the result is "+f);
		
	}

	public List<FoodModel> foodList() {
		Session session=this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<FoodModel> foodList=session.createQuery("form food").list();
		for(FoodModel f:foodList)
		{
			logger.info("foodList Method get called");
		}
		return null;
	}

	public void deleteFood(int foodId) {
		Session session=this.sessionFactory.getCurrentSession();
		FoodModel f=(FoodModel)session.load(FoodModel.class, new Integer(foodId));
		if(null!=f)
		{
			session.delete(f);
		}
		logger.info("deleteFood Mthod called ");
		
	}

	public FoodModel getFoodById(int foodId) {
		Session session=this.sessionFactory.getCurrentSession();
		FoodModel f=(FoodModel)session.load(FoodModel.class, new Integer(foodId));
		logger.info("getFoodById method called and the result is "+f);
		return f;
	}

		

}
