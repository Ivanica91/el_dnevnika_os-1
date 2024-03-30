package com.iktpreobuka.dataaccess.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.repository.UserRepository;

@RestController
@RequestMapping("/el_dnevnik_os-1/korisnik")
public class UserController {
	@Autowired
	public UserRepository userRepository;
	
	@RequestMapping("/greetings")
	public String dobrodoslica() {
		return "Dobro došli u naš elektronski dnevnik za osnovnu školu ";
		
	}
private final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@RequestMapping (method = RequestMethod.GET, value="/lista korisnika")
	public Iterable<UserEntity> getUserEntity(){
		logger.info("Pokrenuta je metoda Korisnik");
		return userRepository.findAll();
	}
	
	
}
