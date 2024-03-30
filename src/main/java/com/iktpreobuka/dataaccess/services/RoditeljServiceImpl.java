package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.RoditeljEntity;
import com.iktpreobuka.dataaccess.repository.RoditeljRepository;

@Service
public class RoditeljServiceImpl implements RoditeljService{
	@Autowired
	private RoditeljRepository roditeljRepository;
	
	@Override
	public RoditeljEntity findById(int id) {
		
		return roditeljRepository.findById(id).get();
	}
}