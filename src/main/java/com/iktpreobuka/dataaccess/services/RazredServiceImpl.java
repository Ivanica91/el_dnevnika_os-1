package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.repository.RazredRepository;

@Service
public class RazredServiceImpl implements RazredService {

	@Autowired
	private RazredRepository razredRepository;
	
}
