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
public class OdeljenjeEntity extends RazredEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name= "Naziv_odeljenja")
	private String naziv;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<UcenikEntity> ucenici = new ArrayList<UcenikEntity>();
	
	
	@OneToMany(mappedBy = "nastavnikPredajeOdeljenju", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<NastavnikEntity> nastavnikPredajeOdeljenju = new ArrayList<NastavnikEntity>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "Odeljnje_koje_pripada_razredu")
	private RazredEntity odeljenjeRazred ;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public OdeljenjeEntity(Integer id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	public OdeljenjeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OdeljenjeEntity(Integer id, RazredEnum razredEnum) {
		super(id, razredEnum);
		// TODO Auto-generated constructor stub
	}
	public List<UcenikEntity> getUcenici() {
		return ucenici;
	}
	public void setUcenici(List<UcenikEntity> ucenici) {
		this.ucenici = ucenici;
	}
	public List<NastavnikEntity> getNastavnikPredajeOdeljenju() {
		return nastavnikPredajeOdeljenju;
	}
	public void setNastavnikPredajeOdeljenju(List<NastavnikEntity> nastavnikPredajeOdeljenju) {
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
	}
	public RazredEntity getOdeljenjeRazred() {
		return odeljenjeRazred;
	}
	public void setOdeljenjeRazred(RazredEntity odeljenjeRazred) {
		this.odeljenjeRazred = odeljenjeRazred;
	}
	public OdeljenjeEntity(Integer id, String naziv, List<UcenikEntity> ucenici,
			List<NastavnikEntity> nastavnikPredajeOdeljenju, RazredEntity odeljenjeRazred) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.ucenici = ucenici;
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
		this.odeljenjeRazred = odeljenjeRazred;
	}
	

}
