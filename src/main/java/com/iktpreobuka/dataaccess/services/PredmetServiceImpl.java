package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.OcenaEntity;
import com.iktpreobuka.dataaccess.entities.PredmetEntity;
import com.iktpreobuka.dataaccess.repository.PredmetRepository;

@Service
public class PredmetServiceImpl implements PredmetService {

	@Autowired
	private PredmetRepository predmetRepository;
	@Autowired
	private OcenaService ocenaService;

	
	@Override
	public PredmetEntity findById(int id) {
		return predmetRepository.findById(id).get();
	}
	
	
	@Override
	public PredmetEntity dodajOcenuPredmetu (int predmetId, long ocenaId) {
		PredmetEntity predmet = predmetRepository.findById(predmetId).get();
		OcenaEntity ocena = ocenaService.findById(ocenaId);
		predmet.setOcena(ocena);
		return predmetRepository.save(predmet);
		
	}
}
