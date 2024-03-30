package com.iktpreobuka.dataaccess.services;


import com.iktpreobuka.dataaccess.entities.OcenaEntity;

public interface OcenaService {
	
	public OcenaEntity findById(long id);
	public OcenaEntity dodajOcenuZaZakljucivanje (long ocenaId, long zakljucnaOcenaId);

}
