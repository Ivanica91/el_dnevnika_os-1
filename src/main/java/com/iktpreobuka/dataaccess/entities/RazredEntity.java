package com.iktpreobuka.dataaccess.entities;

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
public class RazredEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private RazredEnum razredEnum;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "Razred_u_kome_se_drzi_predmet")
	private PredmetEntity razredPredmet ;
	
	@OneToMany(mappedBy = "odeljenjeRazred", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<OdeljenjeEntity> razredSaOdeljenjima = new ArrayList<OdeljenjeEntity>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RazredEnum getRazredEnum() {
		return razredEnum;
	}
	public void setRazredEnum(RazredEnum razredEnum) {
		this.razredEnum = razredEnum;
	}
	public RazredEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RazredEntity(Integer id, RazredEnum razredEnum) {
		super();
		this.id = id;
		this.razredEnum = razredEnum;
	}
	public PredmetEntity getRazredPredmet() {
		return razredPredmet;
	}
	public void setRazredPredmet(PredmetEntity razredPredmet) {
		this.razredPredmet = razredPredmet;
	}
	public List<OdeljenjeEntity> getRazredSaOdeljenjima() {
		return razredSaOdeljenjima;
	}
	public void setRazredSaOdeljenjima(List<OdeljenjeEntity> razredSaOdeljenjima) {
		this.razredSaOdeljenjima = razredSaOdeljenjima;
	}
	public RazredEntity(Integer id, RazredEnum razredEnum, PredmetEntity razredPredmet,
			List<OdeljenjeEntity> razredSaOdeljenjima) {
		super();
		this.id = id;
		this.razredEnum = razredEnum;
		this.razredPredmet = razredPredmet;
		this.razredSaOdeljenjima = razredSaOdeljenjima;
	}
	
	    

}
