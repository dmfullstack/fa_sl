package com.stackroute.foodieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.foodieapp.entity.RestaurantComment;

@Repository
public interface RestaurantDetailComment extends JpaRepository<RestaurantComment, Integer>{

}
