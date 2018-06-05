package com.stackroute.foodieapp.dao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapp.entity.FavoriteEntity;
import com.stackroute.foodieapp.entity.RestaurantComment;
import com.stackroute.foodieapp.repository.FoodieAppRepo;
import com.stackroute.foodieapp.repository.RestaurantDetailComment;

@Service
public class FoodieAppService {
	
	@Autowired
	FoodieAppRepo  appRepo;
	
	@Autowired
	RestaurantDetailComment resRepo;
	
	@Transactional
	public void saveResId(int id,String resName){
		appRepo.save(new FavoriteEntity(id,resName));
		
	}
	
	public void saveComments(RestaurantComment restaurantComment)
	{
		resRepo.save(restaurantComment);
	}
	
	public List<FavoriteEntity> fetchAllRecords(){
		return appRepo.findAll();
	}
	
	
	public void deleteResFromFavourite(int id){
		appRepo.delete(id);
	}
	
	public FavoriteEntity findById(int id){
		return appRepo.findOne(id);
	}
	
	
	public List<RestaurantComment> fetchResComments(){
		return resRepo.findAll();
	}

}
