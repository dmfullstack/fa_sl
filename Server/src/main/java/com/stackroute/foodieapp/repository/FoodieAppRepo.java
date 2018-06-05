package com.stackroute.foodieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.foodieapp.entity.FavoriteEntity;

@Repository
public interface FoodieAppRepo  extends JpaRepository<FavoriteEntity, Integer>{

}
