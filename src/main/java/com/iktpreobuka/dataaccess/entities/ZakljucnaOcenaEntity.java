package com.iktpreobuka.dataaccess.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ZakljucnaOcenaEntity extends OcenaEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	@Column
	private Integer zakljucnaOcena;
	
	
	@OneToMany(mappedBy = "zakljucivanjeOcena", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<OcenaEntity> ocenaZakljucivanje = new ArrayList<OcenaEntity>();
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "predmet_id")
	private PredmetEntity zakljucnaPredmet ;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ucenik_id")
	private UcenikEntity ucenikZakljucna ;
	
	
		
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getZakljucnaOcena() {
		return zakljucnaOcena;
	}
	public void setZakljucnaOcena(Integer zakljucnaOcena) {
		this.zakljucnaOcena = zakljucnaOcena;
	}
	public ZakljucnaOcenaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZakljucnaOcenaEntity(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date,
			Polugodiste polugodiste) {
		super(id, ocena, nazivOcene, date, polugodiste);
		// TODO Auto-generated constructor stub
	}
	public List<OcenaEntity> getOcenaZakljucivanje() {
		return ocenaZakljucivanje;
	}
	public void setOcenaZakljucivanje(List<OcenaEntity> ocenaZakljucivanje) {
		this.ocenaZakljucivanje = ocenaZakljucivanje;
	}
	public PredmetEntity getZakljucnaPredmet() {
		return zakljucnaPredmet;
	}
	public void setZakljucnaPredmet(PredmetEntity zakljucnaPredmet) {
		this.zakljucnaPredmet = zakljucnaPredmet;
	}
	public UcenikEntity getUcenikZakljucna() {
		return ucenikZakljucna;
	}
	public void setUcenikZakljucna(UcenikEntity ucenikZakljucna) {
		this.ucenikZakljucna = ucenikZakljucna;
	}
	public ZakljucnaOcenaEntity(long id, Integer zakljucnaOcena, List<OcenaEntity> ocenaZakljucivanje,
			PredmetEntity zakljucnaPredmet, UcenikEntity ucenikZakljucna) {
		super();
		this.id = id;
		this.zakljucnaOcena = zakljucnaOcena;
		this.ocenaZakljucivanje = ocenaZakljucivanje;
		this.zakljucnaPredmet = zakljucnaPredmet;
		this.ucenikZakljucna = ucenikZakljucna;
	}
	
}
