package com.thinkxfactor.zomatoplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.zomatoplus.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//Long is the type of primary key for User
	//This does the CRUD methods create retrieve update delete
	//spring data JPA writes all implementation details for us 
	//IOC spring creates all objects for us
	
	
	User findByNameAndPassword(String name,String password);
}
