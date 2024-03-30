package com.iktpreobuka.dataaccess.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.iktpreobuka.dataaccess.entities.RoditeljEntity;
import com.iktpreobuka.dataaccess.entities.UlogaKorisnika;
import com.iktpreobuka.dataaccess.repository.RoditeljRepository;
import com.iktpreobuka.dataaccess.services.RoditeljService;

@RestController
@RequestMapping("/el_dnevnik_os-1/roditelj")
public class RoditeljController {
	@Autowired
	public RoditeljRepository roditeljRepository;
	@Autowired
	public RoditeljService roditeljService;
	
	private final Logger logger=(Logger)LoggerFactory.getLogger(this.getClass());

	
	 @RequestMapping(method = RequestMethod.POST)
	public RoditeljEntity addRoditelj (@RequestBody RoditeljEntity noviRoditelj) {
		logger.info("Pokrenuta je metoda Roditelj");
		RoditeljEntity roditelj = new RoditeljEntity();
		roditelj.setIme (noviRoditelj.getIme());
		roditelj.setPrezime (noviRoditelj.getPrezime());
		roditelj.setUsername(noviRoditelj.getUsername());
		roditelj.setPassword(noviRoditelj.getPassword());
		roditelj.setMail(noviRoditelj.getMail());
		roditelj.setUlogaKorisnika(UlogaKorisnika.Korisnik_RODITELj);
		roditeljRepository.save(roditelj);
		return roditelj;
	 
	}
	 @RequestMapping(method = RequestMethod.GET, value= "/lista roditelja")
		public Iterable<RoditeljEntity> getRoditelj(){
			return roditeljRepository.findAll();
		}
		
		@RequestMapping (method=RequestMethod.GET, value = "/get/{id}" )
		public RoditeljEntity getRoditeljById(@PathVariable int id) {
			return roditeljRepository.findById(id).get();
		}
		
		@RequestMapping(method = RequestMethod.PUT, value="/update/{id}")
		public RoditeljEntity updateRoditelj (@RequestBody RoditeljEntity noviRoditelj, @PathVariable int id) {
			RoditeljEntity roditelj = new RoditeljEntity();
			roditelj.setId(id);
			roditelj.setIme (noviRoditelj.getIme());
			roditelj.setPrezime (noviRoditelj.getPrezime());
			roditelj.setUsername(noviRoditelj.getUsername());
			roditelj.setPassword(noviRoditelj.getPassword());
			roditelj.setMail(noviRoditelj.getMail());
			roditelj.setUlogaKorisnika(UlogaKorisnika.Korisnik_RODITELj);
			roditeljRepository.save(roditelj);
			return roditelj;
		}

		@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
		public String delete(@PathVariable int id){
			roditeljRepository.deleteById(id);
			return "Roditelj sa id brojem " + id  + " je izbrisan." ;
		}
		
}
