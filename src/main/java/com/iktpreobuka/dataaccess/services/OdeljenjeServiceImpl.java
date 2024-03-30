package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.OdeljenjeEntity;
import com.iktpreobuka.dataaccess.repository.OdeljenjeRepository;

@Service
public class OdeljenjeServiceImpl implements OdeljenjeService {

	@Autowired
	private OdeljenjeRepository odeljenjeRepository;
	
	
	@Override
	public OdeljenjeEntity findById(int id) {
		
		return odeljenjeRepository.findById(id).get();
	}
}
