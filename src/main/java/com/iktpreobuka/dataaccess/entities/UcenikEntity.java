package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class UcenikEntity extends UserEntity{

	
	@OneToMany(mappedBy = "ucenik", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<NastavnikEntity> UceniSlusaNastavnika = new ArrayList<NastavnikEntity>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "roditelj")
	private RoditeljEntity roditelj ;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ucenik_u_odeljenju")
	private OdeljenjeEntity odeljenje ;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "ucenik_predmet", 
        joinColumns = @JoinColumn(name = "Ucenik_id"), 
        inverseJoinColumns = @JoinColumn(name = "Predmet_id")
    )
    private Set<PredmetEntity> predmeti = new HashSet<>();
	/*
	@ManyToMany
	@JoinTable(name = "ucenik_pohadja_predmet",  joinColumns = @JoinColumn(name = "Ucenik_id"),
	inverseJoinColumns = @JoinColumn(name = "Predmet_id"))
	private Set<PredmetEntity> predmeti;
	*/
	@OneToMany(mappedBy = "ocenjivanjeUcenika", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<OcenaEntity> ocena = new ArrayList<OcenaEntity>();
	
	@OneToMany(mappedBy = "ucenikZakljucna", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ZakljucnaOcenaEntity> ucenikZakljucnaOcena = new ArrayList<ZakljucnaOcenaEntity>();

	
	public UcenikEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<NastavnikEntity> getUceniSlusaNastavnika() {
		return UceniSlusaNastavnika;
	}


	public void setUceniSlusaNastavnika(List<NastavnikEntity> uceniSlusaNastavnika) {
		UceniSlusaNastavnika = uceniSlusaNastavnika;
	}


	public RoditeljEntity getRoditelj() {
		return roditelj;
	}


	public void setRoditelj(RoditeljEntity roditelj) {
		this.roditelj = roditelj;
	}


	public OdeljenjeEntity getOdeljenje() {
		return odeljenje;
	}


	public void setOdeljenje(OdeljenjeEntity odeljenje) {
		this.odeljenje = odeljenje;
	}


	public Set<PredmetEntity> getPredmeti() {
		return predmeti;
	}


	public void setPredmeti(Set<PredmetEntity> predmeti) {
		this.predmeti = predmeti;
	}


	public List<OcenaEntity> getOcena() {
		return ocena;
	}


	public void setOcena(List<OcenaEntity> ocena) {
		this.ocena = ocena;
	}


	public List<ZakljucnaOcenaEntity> getUcenikZakljucnaOcena() {
		return ucenikZakljucnaOcena;
	}


	public void setUcenikZakljucnaOcena(List<ZakljucnaOcenaEntity> ucenikZakljucnaOcena) {
		this.ucenikZakljucnaOcena = ucenikZakljucnaOcena;
	}


	public UcenikEntity(String ime, String prezime, Integer id, String username, String password,
			UlogaKorisnika ulogaKorisnika) {
		super(ime, prezime, id, username, password, ulogaKorisnika);
		// TODO Auto-generated constructor stub
	}
	
}
