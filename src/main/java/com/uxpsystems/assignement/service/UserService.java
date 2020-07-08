package com.uxpsystems.assignement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.uxpsystems.assignement.model.User;
import com.uxpsystems.assignement.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List < User > getAllusers() {
		List<User> userList = userRepo.findAll();
        
        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }
     }
	
	 
	 
	 public User getUserById(Long id) throws Exception 
	    {
	        Optional<User> user = userRepo.findById(id);
	         
	        if(user.isPresent()) {
	            return user.get();
	        } else {
	            throw new Exception("No employee record exist for given id");
	        }
	    }
	 
	 
	 public User createOrUpdateUser(User entity) throws Exception 
	    {
	        Optional<User> employee = userRepo.findById(entity.getId());
	         
	        if(employee.isPresent()) 
	        {
	            User newEntity = employee.get();
	            newEntity.setUsername(entity.getUsername());
	            newEntity.setPassword(entity.getPassword());
	            newEntity.setStatus(entity.getStatus());
	 
	            newEntity = userRepo.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = userRepo.save(entity);
	             
	            return entity;
	            
	        }
	    } 
	 
	 
	 public void deleteUserById(Long id) throws Exception 
	    {
	        Optional<User> employee = userRepo.findById(id);
	         
	        if(employee.isPresent()) 
	        {
	        	userRepo.deleteById(id);
	        } else {
	            throw new Exception("No employee record exist for given id");
	        }
	    } 
	

}
