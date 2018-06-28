package com.thinkxfactor.zomatoplus.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Items;
import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;


@RestController   //Creating restful controllers
@RequestMapping("/user") //class level mapping 
public class UserController {

/* These APIs are used when DB connection is not established
 	
	//To view this put http://localhost:9080/user/login?username=nikita&password=shah
		@GetMapping("/login")	
		public User userLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
			User usr = new User();
			usr.setUsername(username);
			usr.setPassword(password);
		return usr;
		}
	
	//To list all users 
	//Add 2 constructors in User.java in com.thinkxfactor.zomatoplus.models
	//One parameterized and other non parameterized
	//To view this put http://localhost:9080/user/all
	//It gives an array of objects
	@GetMapping("/all")	
		public List<User> userList() {
			List<User> users = new ArrayList<>();
			User usr1,usr2,usr3;
			usr1 = new User("Ananya","Das");
			usr2 = new User("Akshay","Anand");
			usr3 = new User("Shreya","Sil");
			users.add(usr1);
			users.add(usr2);
			users.add(usr3);
		return users;
		}
	
	//Post is done in the body hence RequestBody
	//http://localhost:9080/user/create.........This is Get need to fix it to Post
	//Use swagger ie a postman
		@PostMapping("/create") //To denote it as post
		public User userCreate(@RequestBody User user) { //To denote data is passed in the body
			System.out.println(user.toString());
		return user;
	}
	
	//userRegistration API of Post type for user/create
	@PostMapping("/create") 
	public User userRegistration(@RequestBody User user) { 
		System.out.println(user.toString());
		return user;
	}
	
	//userLogin API of Post type for user/login
		@PostMapping("/login") 
		public User userLogin(@RequestBody User user) { 
			//System.out.println(user.toString());
		return user;
		}

*/
	
	@Autowired //needed because spring will create objects for us IOC
	//This is IOC with DI(dependency Injection)
	//Can be done using constructer IOC which is better
	private UserRepository userRepository;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		User persistedUser = userRepository.save(user);
		return persistedUser;
	}
	
	@GetMapping("/getallUsers")
	public List<User> getall(){
		List<User> listofusers = userRepository.findAll();
		return listofusers;
	}
	
	@PostMapping("/login") 
	//This API will take only the name and password and give the entire details
	//In post mapping always use RequestBody
	public User userLogin(@RequestBody User user) { 
		return userRepository.findByNameAndPassword(user.getName(),user.getPassword());
		
	}
	
}
