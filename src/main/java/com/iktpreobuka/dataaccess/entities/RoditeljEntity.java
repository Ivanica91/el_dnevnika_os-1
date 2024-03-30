package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class RoditeljEntity extends UserEntity {
	
	@Column
	private String mail;
	
	

	@OneToMany(mappedBy = "roditelj", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<UcenikEntity> deca = new ArrayList<UcenikEntity>();

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public RoditeljEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoditeljEntity(String mail) {
		super();
		this.mail = mail;
	}

	public List<UcenikEntity> getDeca() {
		return deca;
	}

	public void setDeca(List<UcenikEntity> deca) {
		this.deca = deca;
	}

	public RoditeljEntity(String ime, String prezime, Integer id, String username, String password,
			UlogaKorisnika ulogaKorisnika) {
		super(ime, prezime, id, username, password, ulogaKorisnika);
		// TODO Auto-generated constructor stub
	}

	public RoditeljEntity(String mail, List<UcenikEntity> deca) {
		super();
		this.mail = mail;
		this.deca = deca;
	}
	
}
