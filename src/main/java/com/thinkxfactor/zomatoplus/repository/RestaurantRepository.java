package com.thinkxfactor.zomatoplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.models.User;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
	
	Restaurant findByAddress(String address);
	Restaurant findByNameAndId(String name ,Long id);

}
