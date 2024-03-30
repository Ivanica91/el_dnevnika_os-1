package com.iktpreobuka.dataaccess.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;





@Entity
public class NastavnikEntity extends UserEntity{
	

	@Column (name= "Nedeljni_fond_casova")
	private Integer nedeljniFond;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "nastavnik_predaje_uceniku")
	private UcenikEntity ucenik ;
	
	
	@ManyToMany(mappedBy = "nastavnici",fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<PredmetEntity> predmeti = new HashSet<PredmetEntity>();

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "nastavnik_predaje_odeljenju")
	private OdeljenjeEntity nastavnikPredajeOdeljenju ; 
	
	@ManyToMany(mappedBy= "nastavnikOcena" ,fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<OcenaEntity> ocene = new HashSet<OcenaEntity>();
	
	public Integer getNedeljniFond() {
		return nedeljniFond;
	}

	public void setNedeljniFond(Integer nedeljniFond) {
		this.nedeljniFond = nedeljniFond;
	}

	public NastavnikEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NastavnikEntity(String ime, String prezime, Integer id, String username, String password,
			UlogaKorisnika ulogaKorisnika) {
		super(ime, prezime, id, username, password, ulogaKorisnika);
		// TODO Auto-generated constructor stub
	}

	public UcenikEntity getUcenik() {
		return ucenik;
	}

	public void setUcenik(UcenikEntity ucenik) {
		this.ucenik = ucenik;
	}

	public Set<PredmetEntity> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<PredmetEntity> predmeti) {
		this.predmeti = predmeti;
	}

	public OdeljenjeEntity getNastavnikPredajeOdeljenju() {
		return nastavnikPredajeOdeljenju;
	}

	public void setNastavnikPredajeOdeljenju(OdeljenjeEntity nastavnikPredajeOdeljenju) {
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
	}

	public Set<OcenaEntity> getOcene() {
		return ocene;
	}

	public void setOcene(Set<OcenaEntity> ocene) {
		this.ocene = ocene;
	}

	public NastavnikEntity(Integer nedeljniFond, UcenikEntity ucenik, Set<PredmetEntity> predmeti,
			OdeljenjeEntity nastavnikPredajeOdeljenju, Set<OcenaEntity> ocene) {
		super();
		this.nedeljniFond = nedeljniFond;
		this.ucenik = ucenik;
		this.predmeti = predmeti;
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
		this.ocene = ocene;
	}
	

	
	
}
