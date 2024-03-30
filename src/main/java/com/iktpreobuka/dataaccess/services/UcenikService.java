package com.iktpreobuka.dataaccess.services;

import com.iktpreobuka.dataaccess.entities.UcenikEntity;

public interface UcenikService {
	
	public UcenikEntity dodajOdeljenjeUceniku(int ucenikId, int odeljenjeId);
	public UcenikEntity dodajRoditeljaUceniku(int ucenikId, int roditeljId);
	public UcenikEntity findById(int id);
	public UcenikEntity dodajPredmetUceniku(int ucenikId, int predmetId);

}
