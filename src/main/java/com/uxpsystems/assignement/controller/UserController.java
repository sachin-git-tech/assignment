package com.uxpsystems.assignement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignement.model.User;
import com.uxpsystems.assignement.repository.UserRepository;
import com.uxpsystems.assignement.service.UserService;

@RestController
@RequestMapping(value="/assignment")
public class UserController {
	@Autowired
	private UserService userserv;
	
	@GetMapping(value="/users")
    public ResponseEntity<List<User>> getAllusers() {
        List<User> list = userserv.getAllusers();
 
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	 
	@GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws Exception {
        User entity = userserv.getUserById(id);
 
        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	 
	
	@PostMapping
    public ResponseEntity<User> createOrUpdateUser(User user) throws Exception {
        User updated = userserv.createOrUpdateUser(user);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		userserv.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }
	

}
