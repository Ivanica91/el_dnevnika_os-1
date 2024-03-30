package com.iktpreobuka.dataaccess.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class UserEntity {
	
	@Column(name="Ime", nullable = false)
	private String ime;
	@Column(name= "Prezime", nullable = false)
	private String prezime;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="Username")
	private String username;
	@Column(name="Password")
	private String password;
	@Column (name = "Uloga_korisnika")
	protected UlogaKorisnika ulogaKorisnika;

	public String getIme() {
		return ime;
	}
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UlogaKorisnika getUlogaKorisnika() {
		return ulogaKorisnika;
	}

	public void setUlogaKorisnika(UlogaKorisnika ulogaKorisnika) {
		this.ulogaKorisnika = ulogaKorisnika;
	}

	public UserEntity(String ime, String prezime, Integer id, String username, String password,
			UlogaKorisnika ulogaKorisnika) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
		this.username = username;
		this.password = password;
		this.ulogaKorisnika = ulogaKorisnika;
	}
	

	
}
