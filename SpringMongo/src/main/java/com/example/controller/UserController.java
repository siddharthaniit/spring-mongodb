package com.example.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestBody User user)
	{
		 userRepository.save(user);
		 
		 return "success";
	}
	
	@RequestMapping(value="/byid/{id}",method=RequestMethod.GET)
	public Optional<User> byId(@PathVariable UUID id)
	{
		return userRepository.findById(id);
		 
		 
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable UUID id)
	{
		 userRepository.deleteById(id);
		 
		 return "success";
		 
		 
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public User update(@RequestBody User user, @PathVariable UUID id)
	{
		user.setId(id);
		return userRepository.save(user);
		 
		 
	}
	
	@RequestMapping(value="getAll",method=RequestMethod.GET)
	public List<User> getAll()
	{
		return userRepository.findAll();
		 
		 
	}
	
	
	
	
	
	
	
	

}
