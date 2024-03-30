package com.iktpreobuka.dataaccess.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.AdminEntity;
import com.iktpreobuka.dataaccess.entities.UlogaKorisnika;
import com.iktpreobuka.dataaccess.repository.AdminRepository;

@RestController
@RequestMapping("/el_dnevnik_os-1/admin")
public class AdminController {
	@Autowired
	public AdminRepository adminRepository;

	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	 	@RequestMapping(method = RequestMethod.POST)
	public AdminEntity addAdmin (@RequestBody AdminEntity admin) {
		logger.info("Pokrenuta je metoda Admin");
		AdminEntity noviAdmin = new AdminEntity();
		noviAdmin.setIme(admin.getIme());
		noviAdmin.setPrezime(admin.getPrezime());
		noviAdmin.setUsername(admin.getUsername());
		noviAdmin.setPassword(admin.getPassword());
		noviAdmin.setUlogaKorisnika(UlogaKorisnika.Korisnik_ADMIN);
		 adminRepository.save(noviAdmin);
		 return noviAdmin ;
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "/lista administratora")
	public Iterable<AdminEntity>getAdmin(){
		return adminRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/update/{id}")
	public AdminEntity updateAdmin (@RequestBody AdminEntity admin,@PathVariable int id) {
		AdminEntity noviAdmin = new AdminEntity();
		noviAdmin.setId(id);
		noviAdmin.setIme(admin.getIme());
		noviAdmin.setPrezime(admin.getPrezime());
		noviAdmin.setUsername(admin.getUsername());
		noviAdmin.setPassword(admin.getPassword());
		noviAdmin.setUlogaKorisnika(UlogaKorisnika.Korisnik_ADMIN);
		 adminRepository.save(noviAdmin);
		 return noviAdmin ;
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
	public String delete(@PathVariable int id) {
		adminRepository.deleteById(id);
		return "Admin sa id brojem " + id  + " je izbrisan.";
	}
	 
	
}
