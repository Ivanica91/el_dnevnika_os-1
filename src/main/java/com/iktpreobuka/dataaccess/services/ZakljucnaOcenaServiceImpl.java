package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.ZakljucnaOcenaEntity;
import com.iktpreobuka.dataaccess.repository.ZakljucnaOcenaRepository;


@Service
public class ZakljucnaOcenaServiceImpl implements ZakljucnaOcenaService{
	@Autowired
	private ZakljucnaOcenaRepository zakljucnaOcenaRepository;
	

	@Override
	public ZakljucnaOcenaEntity findById(long id){
		return zakljucnaOcenaRepository.findById(id).get();
	}

}
