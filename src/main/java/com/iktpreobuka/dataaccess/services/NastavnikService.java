package com.iktpreobuka.dataaccess.services;

import com.iktpreobuka.dataaccess.entities.NastavnikEntity;

public interface NastavnikService {
	
	public NastavnikEntity dodajPredmetNastavniku(int nastavnikId, int predmetId);
	public NastavnikEntity dodajOdeljenjeNastavniku (int nastavnikId,int odeljenjeId);

}
