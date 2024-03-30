package com.iktpreobuka.dataaccess.services;


import com.iktpreobuka.dataaccess.entities.PredmetEntity;

public interface PredmetService {

	 public PredmetEntity findById(int id);
	 public PredmetEntity dodajOcenuPredmetu (int predmetId, long ocenaId);


}
