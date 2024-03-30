package com.iktpreobuka.dataaccess.entities;

import jakarta.persistence.Entity;

@Entity
public class AdminEntity extends UserEntity{

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEntity(String ime, String prezime, Integer id, String username, String password,
			UlogaKorisnika ulogaKorisnika) {
		super(ime, prezime, id, username, password, ulogaKorisnika);
		// TODO Auto-generated constructor stub
	}
	

}
