package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.OcenaEntity;
import com.iktpreobuka.dataaccess.entities.ZakljucnaOcenaEntity;
import com.iktpreobuka.dataaccess.repository.OcenaRepository;

@Service
public class OcenaServiceImpl implements OcenaService {

	@Autowired
	private OcenaRepository ocenaRepository;
	@Autowired
	private ZakljucnaOcenaService zakljucnaOcenaService;
	
	
	@Override
	public OcenaEntity findById(long id) {
		return ocenaRepository.findById(id).get();
	}
	
	@Override
	public OcenaEntity dodajOcenuZaZakljucivanje (long ocenaId,long zakljucnaOcenaId) {
		OcenaEntity ocena = ocenaRepository.findById(ocenaId).get();
		ZakljucnaOcenaEntity zakljucnaOcena = zakljucnaOcenaService.findById(zakljucnaOcenaId);
		ocena.setZakljucivanjeOcena(zakljucnaOcena);
		return ocenaRepository.save(ocena);
		
	}
	}

