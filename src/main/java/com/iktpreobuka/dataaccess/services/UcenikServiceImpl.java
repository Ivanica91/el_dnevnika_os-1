package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.OdeljenjeEntity;
import com.iktpreobuka.dataaccess.entities.PredmetEntity;
import com.iktpreobuka.dataaccess.entities.RoditeljEntity;
import com.iktpreobuka.dataaccess.entities.UcenikEntity;
import com.iktpreobuka.dataaccess.repository.UcenikRepository;

@Service
public class UcenikServiceImpl implements UcenikService {

	@Autowired
	private UcenikRepository ucenikRepository;
	@Autowired
	private OdeljenjeService odeljenjeService;
	@Autowired
	private RoditeljService roditeljService;
	@Autowired
	private PredmetService predmetService;
	
	@Override
	public UcenikEntity dodajOdeljenjeUceniku(int ucenikId, int odeljenjeId) {
		UcenikEntity ucenik = ucenikRepository.findById(ucenikId).get();
		OdeljenjeEntity odeljenje= odeljenjeService.findById(odeljenjeId);
		ucenik.setOdeljenje(odeljenje);
		return ucenikRepository.save(ucenik);
	}
	@Override
	public UcenikEntity dodajRoditeljaUceniku(int ucenikId, int roditeljId) {
		UcenikEntity ucenik = ucenikRepository.findById(ucenikId).get();
		RoditeljEntity roditelj = roditeljService.findById(roditeljId);
		ucenik.setRoditelj(roditelj);
		return ucenikRepository.save(ucenik);
	}
	@Override
	public UcenikEntity findById(int id) {
		return ucenikRepository.findById(id).get();
	}
	
	@Override
	public UcenikEntity dodajPredmetUceniku (int ucenikId, int predmetId) {
		UcenikEntity ucenik = ucenikRepository.findById(ucenikId).get();
		PredmetEntity predmet = predmetService.findById(predmetId);
		ucenik.getPredmeti().add(predmet);
		return ucenikRepository.save(ucenik);
		
	}
}
