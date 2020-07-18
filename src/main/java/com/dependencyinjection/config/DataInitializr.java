package com.dependencyinjection.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dependencyinjection.models.User;
import com.dependencyinjection.repositories.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	public void creatUser(String name, String email) {

		User user = new User(name, email);

		userRepository.save(user);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			
			creatUser("Anastacia", "anastacia@gmail.com");
			creatUser("Joaquim", "joaquim@gmail.com");
			creatUser("Filomena", "filomena@gmail.com");
		
	}
		
		User user = userRepository.findByNameIgnoreCaseLike("filomena");
		System.out.println(user.getName());
	}
	
}
