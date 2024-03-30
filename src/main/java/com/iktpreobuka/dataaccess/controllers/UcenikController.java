package com.iktpreobuka.dataaccess.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.UcenikEntity;
import com.iktpreobuka.dataaccess.entities.UlogaKorisnika;
import com.iktpreobuka.dataaccess.repository.UcenikRepository;
import com.iktpreobuka.dataaccess.services.UcenikService;

@RestController
@RequestMapping("/el_dnevnik_os-1/ucenik")
public class UcenikController {
	@Autowired
	public UcenikRepository ucenikRepository;
	@Autowired
	private UcenikService ucenikService;
	
	private final Logger logger=(Logger)LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST)
	public UcenikEntity addUcenik(@RequestBody UcenikEntity noviUcenik) {
		logger.info("Pokrenuta je metoda Ucenik");
		UcenikEntity ucenik = new UcenikEntity();
		ucenik.setIme(noviUcenik.getIme());
		ucenik.setPrezime(noviUcenik.getPrezime());
		ucenik.setUsername(noviUcenik.getUsername());
		ucenik.setPassword(noviUcenik.getPassword());
		ucenik.setUlogaKorisnika(UlogaKorisnika.Korisnik_UCENIK);
		 ucenikRepository.save(ucenik);
		 return ucenik;
	}

	@RequestMapping(method = RequestMethod.GET,value="/lista ucenika")
	public Iterable<UcenikEntity> getUcenik(){
		return ucenikRepository.findAll();
	}
	
	@RequestMapping (method = RequestMethod.GET, value="/get/{id}")
	public UcenikEntity getUcenikById(@PathVariable int id) {
		return ucenikRepository.findById(id).get();
	}
	@RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
	public String delete(@PathVariable int id){
			ucenikRepository.deleteById(id);
			return "Ucenik sa id brojem " + id  + " je izbrisan.";
	}	

	@RequestMapping (method = RequestMethod.PUT, value= "/dodavanjeOdeljenja/{ucenikiId}/{odeljenjeId}")
	public UcenikEntity dodajUOdeljenje ( @PathVariable int ucenikId, @PathVariable int odeljenjeId) {
		return ucenikService.dodajOdeljenjeUceniku(ucenikId, odeljenjeId);
		
	}
	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajPredmetUceniku/{ucenikiId}/{predmetId}")
	public UcenikEntity  dodajPredmetUceniku (@PathVariable int ucenikId, @PathVariable int predmetId) {
		return ucenikService.dodajPredmetUceniku(ucenikId, predmetId );
	}
	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajRoditeljaUceniku/{ucenikiId}/{roditeljId}")
	public UcenikEntity  dodajRoditeljaUceniku (@PathVariable int ucenikId, @PathVariable int roditeljId) {
		return ucenikService.dodajRoditeljaUceniku(ucenikId, roditeljId );
	}
}
