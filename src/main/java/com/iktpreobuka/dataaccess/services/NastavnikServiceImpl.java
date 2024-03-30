package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.NastavnikEntity;
import com.iktpreobuka.dataaccess.entities.OdeljenjeEntity;
import com.iktpreobuka.dataaccess.entities.PredmetEntity;
import com.iktpreobuka.dataaccess.repository.NastavnikRepository;

@Service
public class NastavnikServiceImpl implements NastavnikService {

	@Autowired
	private NastavnikRepository nastavnikRepository;
	@Autowired
	private PredmetService predmetService;
	@Autowired
	private OdeljenjeService odeljenjeService;
	
	
	@Override
	public NastavnikEntity dodajPredmetNastavniku (int nastavnikId, int predmetId) {
		NastavnikEntity nastavnik = nastavnikRepository.findById(nastavnikId).get();
		PredmetEntity predmet = predmetService.findById(predmetId);
		nastavnik.getPredmeti().add(predmet);
		return nastavnikRepository.save(nastavnik);
		
	}
	
	@Override
	public NastavnikEntity dodajOdeljenjeNastavniku (int nastavnikId, int odeljenjeId) {
		NastavnikEntity nastavnik = nastavnikRepository.findById(nastavnikId).get();
		OdeljenjeEntity odeljenje = odeljenjeService.findById(odeljenjeId);
		nastavnik.setNastavnikPredajeOdeljenju(odeljenje);
		return nastavnikRepository.save(nastavnik);
		
	}
}
