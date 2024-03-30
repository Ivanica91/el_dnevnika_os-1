package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PredmetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name= "Naziv_predmeta")
	private String naziv; //naziv predmeta
	@Column(name= "Nedeljni_fond_casova_za_predmet")
	private Integer nedeljniFond; //nedeljni fond casova
	@Column(name= "Razred")
	protected RazredEnum Razred;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinTable(
        name = "predmet_nastavnik", 
        joinColumns = @JoinColumn(name = "Predmet_id"), 
        inverseJoinColumns = @JoinColumn(name = "Nastavnik_id")
    )
    protected Set<NastavnikEntity> nastavnici = new HashSet<>();
	
	/*
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "predmet_koji_drzi", joinColumns =
	{ @JoinColumn(name = "Predmet_id") },
	inverseJoinColumns = { @JoinColumn(name = "Nastavnik_id", nullable = false,
	updatable = false) })
	protected Set<NastavnikEntity> nastavnici = new HashSet<NastavnikEntity>();
	*/
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "predmeti")
    protected Set<UcenikEntity> ucenici = new HashSet<>();
	
	/*
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Predmet_koji_pohadja_ucenik", joinColumns =
	{ @JoinColumn(name = "Predmet_id") },
	inverseJoinColumns = { @JoinColumn(name = "Ucenik_id", nullable = false,
	updatable = false) })
	protected Set<UcenikEntity> predmetKojiPohadjaUcenik = new HashSet<UcenikEntity>();
	*/
	@OneToMany(mappedBy = "razredPredmet", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<RazredEntity> predmetURazredu = new ArrayList<RazredEntity>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ocena")
	private OcenaEntity ocena ;
	
	@OneToMany(mappedBy = "zakljucnaPredmet", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ZakljucnaOcenaEntity> predmetZakljucnaOcena = new ArrayList<ZakljucnaOcenaEntity>();
	
	
	
	
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
	public Integer getNedeljniFond() {
		return nedeljniFond;
	}
	public void setNedeljniFond(Integer nedeljniFond) {
		this.nedeljniFond = nedeljniFond;
	}
	public RazredEnum getRazred() {
		return Razred;
	}
	public void setRazred(RazredEnum razred) {
		Razred = razred;
	}
	public PredmetEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PredmetEntity(Integer id, String naziv, Integer nedeljniFond, RazredEnum razred) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
	}
	public Set<NastavnikEntity> getNastavnici() {
		return nastavnici;
	}
	public void setNastavnici(Set<NastavnikEntity> nastavnici) {
		this.nastavnici = nastavnici;
	}
	
	
	public List<RazredEntity> getPredmetURazredu() {
		return predmetURazredu;
	}
	public void setPredmetURazredu(List<RazredEntity> predmetURazredu) {
		this.predmetURazredu = predmetURazredu;
	}
	public OcenaEntity getOcena() {
		return ocena;
	}
	public void setOcena(OcenaEntity ocena) {
		this.ocena = ocena;
	}
	public List<ZakljucnaOcenaEntity> getPredmetZakljucnaOcena() {
		return predmetZakljucnaOcena;
	}
	public void setPredmetZakljucnaOcena(List<ZakljucnaOcenaEntity> predmetZakljucnaOcena) {
		this.predmetZakljucnaOcena = predmetZakljucnaOcena;
	}
	public PredmetEntity(Integer id, String naziv, Integer nedeljniFond, RazredEnum razred,
			Set<NastavnikEntity> nastavnici, Set<UcenikEntity> predmetKojiPohadjaUcenik,
			List<RazredEntity> predmetURazredu, OcenaEntity ocena, List<ZakljucnaOcenaEntity> predmetZakljucnaOcena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
		this.nastavnici = nastavnici;
		this.predmetURazredu = predmetURazredu;
		this.ocena = ocena;
		this.predmetZakljucnaOcena = predmetZakljucnaOcena;
	}
	
	
}
