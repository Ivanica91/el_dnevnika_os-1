package com.iktpreobuka.dataaccess.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.OdeljenjeEntity;
import com.iktpreobuka.dataaccess.repository.OdeljenjeRepository;


@RestController
@RequestMapping("/el_dnevnik_os-1/odeljenje")
public class OdeljenjeController {
	@Autowired
	public OdeljenjeRepository odeljenjeRepository;
	
	private final Logger logger=(Logger)LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.POST)
	public OdeljenjeEntity addOdeljenje (@RequestBody OdeljenjeEntity odeljenje) {
		logger.info("Pokrenuta je metoda Odeljenje");
		OdeljenjeEntity novoOdeljenje = new OdeljenjeEntity();
		novoOdeljenje.setNaziv (odeljenje.getNaziv());
		odeljenjeRepository.save(novoOdeljenje);
		return novoOdeljenje;
	}
	
	@RequestMapping(method= RequestMethod.GET, value ="/lista odeljenja")
	public Iterable<OdeljenjeEntity> getOdeljenje(){
		return odeljenjeRepository.findAll();
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value ="/get/{id}")
	public OdeljenjeEntity getOdelkjenjeById(@PathVariable int id){
		return odeljenjeRepository.findById(id).get();
	}
	

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public OdeljenjeEntity updateOdeljenje (@RequestBody OdeljenjeEntity novoOdeljenje, @PathVariable int id) {
		OdeljenjeEntity  odeljenje = new OdeljenjeEntity();
		odeljenje.setId(id);
		odeljenje.setNaziv (novoOdeljenje.getNaziv());
		odeljenjeRepository.save(odeljenje);
		return odeljenje;
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public String delete(@PathVariable int id){
			odeljenjeRepository.deleteById(id);
			return "Odeljenje sa id brojem " + id  + " je izbrisan.";
	}
	
}

