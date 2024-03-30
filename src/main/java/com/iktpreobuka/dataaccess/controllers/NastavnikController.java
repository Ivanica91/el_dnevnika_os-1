package com.iktpreobuka.dataaccess.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.NastavnikEntity;

import com.iktpreobuka.dataaccess.entities.UlogaKorisnika;
import com.iktpreobuka.dataaccess.repository.NastavnikRepository;
import com.iktpreobuka.dataaccess.services.NastavnikService;

@RestController
@RequestMapping("/el_dnevnik_os-1/nastavnik")
public class NastavnikController {

	@Autowired
	public NastavnikRepository nastavnikRepository;
	@Autowired
	public NastavnikService nastavnikService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.POST)
	public NastavnikEntity addNastavnik (@RequestBody NastavnikEntity noviNastavnik ) {
		logger.info("Pokrenuta je metoda Nastavnik");
		NastavnikEntity nastavnik = new NastavnikEntity();
		nastavnik.setIme (noviNastavnik.getIme());
		nastavnik.setPrezime (noviNastavnik.getPrezime());
		nastavnik.setUsername (noviNastavnik.getUsername());
		nastavnik.setPassword (noviNastavnik.getPassword());
		nastavnik.setUlogaKorisnika(UlogaKorisnika.Korisnik_NASTAVNIK);
		nastavnikRepository.save(nastavnik);
		return nastavnik;
	
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/listanastavnika")
	public Iterable<NastavnikEntity> getNastavnikEntity(){
		return nastavnikRepository.findAll();
		
	}
	@RequestMapping(method = RequestMethod.GET,value="/update/{id}")
	public NastavnikEntity getNastavnikEntityById(@PathVariable int id){
		return nastavnikRepository.findById(id).get();
		
	}
	 
	@RequestMapping( method = RequestMethod.PUT, value="/update/{id}")
	 public NastavnikEntity updateNastavnik (@RequestBody NastavnikEntity noviNastavnik,@PathVariable int id ) {
		NastavnikEntity nastavnik = new NastavnikEntity();
		nastavnik.setId(id);
		nastavnik.setIme (noviNastavnik.getIme());
		nastavnik.setPrezime (noviNastavnik.getPrezime()); 
	    nastavnik.setUsername (noviNastavnik.getUsername());
		nastavnik.setPassword (noviNastavnik.getPassword());
		nastavnik.setUlogaKorisnika(UlogaKorisnika.Korisnik_NASTAVNIK);
		nastavnikRepository.save(nastavnik);
		return nastavnik;
	  
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public String delete(@PathVariable int id){
			nastavnikRepository.deleteById(id);
			return "Nastavnik sa id brojem " + id  + " je izbrisan.";
	}
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajPredmetNastavniku/{nastavnikId}/{predmetId}")
	public NastavnikEntity  dodajPredmetNastavniku (@PathVariable int nastavnikId, @PathVariable int predmetId) {
		return nastavnikService.dodajPredmetNastavniku(nastavnikId, predmetId );
	}
	
	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajOdeljenjeNastavniku/{nastavnikId}/{odeljenjeId}")
	public NastavnikEntity  dodajOdeljenjeNastavniku (@PathVariable int nastavnikId, @PathVariable int odeljenjeId) {
		return nastavnikService.dodajOdeljenjeNastavniku(nastavnikId, odeljenjeId );
	}
	
	
}
