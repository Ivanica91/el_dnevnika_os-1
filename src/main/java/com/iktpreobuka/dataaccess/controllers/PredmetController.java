package com.iktpreobuka.dataaccess.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.PredmetEntity;
import com.iktpreobuka.dataaccess.repository.PredmetRepository;
import com.iktpreobuka.dataaccess.services.PredmetService;

@RestController
@RequestMapping("/el_dnevnik_os-1/predmet")
public class PredmetController {
	
	@Autowired
	public PredmetRepository predmetRepository;
	@Autowired
	public PredmetService predmetService;
	
	private final Logger logger=(Logger)LoggerFactory.getLogger(this.getClass());
	//private static final Logger log = LoggerFactory.getLogger(KorisnikController.class);
	
	@RequestMapping(method= RequestMethod.POST)
	public PredmetEntity addPredmet(@RequestBody PredmetEntity noviPredmet) {
		logger.info("Pokrenuta je metoda Predmet");
		PredmetEntity predmet = new PredmetEntity();
		predmet.setNaziv(noviPredmet.getNaziv());
		predmet.setNedeljniFond(noviPredmet.getNedeljniFond());
		predmet.setRazred(noviPredmet.getRazred());
		 predmetRepository.save(predmet);
		 return predmet;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/listapredmeta")
	public Iterable<PredmetEntity> getPredmet(){
		return predmetRepository.findAll();
	}

	@RequestMapping (method = RequestMethod.GET, value="/get/{id}")
	public PredmetEntity getPredmetById(@PathVariable int id) {
		return predmetRepository.findById(id).get();
	}
	@RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
	public String delete(@PathVariable int id){
			predmetRepository.deleteById(id);
			return "Predmet sa id brojem " + id  + " je izbrisan.";
	}	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajOcenuPredmetu/{predmetId}/{ocenatId}")
	public PredmetEntity  dodajOcenuPredmetu (@PathVariable int predmetId, @PathVariable long ocenaId) {
		return predmetService.dodajOcenuPredmetu(predmetId,ocenaId);
	}
}
