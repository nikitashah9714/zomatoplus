
package com.thinkxfactor.zomatoplus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Items;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.ItemsRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	/*	This is to be done when the database has not been connected
		
	// API of Post type for restaurant/create
		@PostMapping("/create") 
		public Restaurant createRestaurant(@RequestBody Restaurant rest) { 
			System.out.println(rest.toString());
			return rest;
		}
		
	//API of GET type for restaurant/listall
		@GetMapping("/listall")	
		public List <Restaurant> restaurantList() {
			List<Restaurant> rest = new ArrayList<>();
			Restaurant rst1,rst2,rst3;
			rst1 = new Restaurant("India Restaurant","Kolkata","good","IR@gmail.com","757536387");
			rst2 = new Restaurant("Meridian Inn","Kolkata","okay","Mi@yahoo.com","5374657326");
			rst3 = new Restaurant("Cafe Fancy","Kolkata","good","CF@gmail.com","352735357");
			rest.add(rst1);
			rest.add(rst2);
			rest.add(rst3);
			return rest;
		}
		
	//API for restaurant/items
		@PostMapping("/items")
		public Items addItems(@RequestBody Items item)
		{
			return item;
		}
		
	*/
	
	
	
//After we create the database ORM maps the class variables to the column names of the database
	@Autowired 
	//This is IOC with DI(Dependency Injection)
	private RestaurantRepository restaurantRepository;
	
	@PostMapping("/addRestaurant")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant persistedRestaurant = restaurantRepository.save(restaurant);
		return persistedRestaurant;
	}
	
	@GetMapping("/getallRestaurant")
	public List<Restaurant> getall(){
		List<Restaurant> listofrestaurants = restaurantRepository.findAll();
		return listofrestaurants;
	}
	
	@PostMapping("/restaurantByAddress") 
	//This API will take only the name and password and give the entire details
	//In post mapping always use RequestBody
	public Restaurant restaurantByAddress(@RequestBody Restaurant restaurant) { 
		return restaurantRepository.findByAddress(restaurant.getAddress());
	}
	
	@PostMapping("/restaurantByNameAndId")
	public Restaurant restaurantByNameAndId(@RequestBody Restaurant restaurant) { 
		return restaurantRepository.findByNameAndId(restaurant.getName(), restaurant.getId());
	}
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@PostMapping("/addItems")
	public Items addItem(@RequestBody Items item) {
		if( restaurantRepository.existsById(item.getRestaurantid())) {
			itemsRepository.save(item);
			return item;
		}
		else
		{
			return  null;
		}
	}
	
	@GetMapping("/getallItems")
	public List<Items> getallItems(){
		List<Items> listofitems = itemsRepository.findAll();
		return listofitems;
	}
	
}

