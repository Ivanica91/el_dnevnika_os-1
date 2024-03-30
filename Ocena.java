package com.iktpreobuka.dataaccess.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ocena {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column (name= "Ocena")
	private Integer ocena; 
	@Column (name= "Naziv_ocene")
	private NazivOcene nazivOcene;
	@Column (name= "Datum ")
	private LocalDate date;
	@Column (name= "Polugodiste")
	private Polugodiste polugodiste;

	
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	@JoinTable(name = "Ocenjivanje", joinColumns =
//	{ @JoinColumn(name = "Ocena_id", nullable = false, updatable = false) },
//	inverseJoinColumns = { @JoinColumn(name = "Predmet_id", nullable = false,
//	updatable = false) })
//	protected Set<Predmet> predmeti = new HashSet<Predmet>();

	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Ocena> Ocenjivanje = new ArrayList<Ocena>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Nastavnik_ocena", joinColumns =
	{ @JoinColumn(name = "Ocena_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Nastavnik_id", nullable = false,
	updatable = false) })
	protected Set<Nastavnik> nastavnikOcena = new HashSet<Nastavnik>();
	

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ocenjenivanje_ucenika")
	private Ucenik ocenjivanjeUcenika ;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ocenaZakljucivanje_id")
	private ZakljucnaOcena zakljucivanjeOcena ;
	
	
	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public List<Ocena> getOcenjivanje() {
		return Ocenjivanje;
	}




	public void setOcenjivanje(List<Ocena> ocenjivanje) {
		Ocenjivanje = ocenjivanje;
	}




	public Ocena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste,
			List<Ocena> ocenjivanje) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.nazivOcene = nazivOcene;
		this.date = date;
		this.polugodiste = polugodiste;
		Ocenjivanje = ocenjivanje;
	}




	public Set<Nastavnik> getNastavnikOcena() {
		return nastavnikOcena;
	}




	public void setNastavnikOcena(Set<Nastavnik> nastavnikOcena) {
		this.nastavnikOcena = nastavnikOcena;
	}




	public Ocena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste,
			List<Ocena> ocenjivanje, Set<Nastavnik> nastavnikOcena) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.nazivOcene = nazivOcene;
		this.date = date;
		this.polugodiste = polugodiste;
		Ocenjivanje = ocenjivanje;
		this.nastavnikOcena = nastavnikOcena;
	}




	public Ucenik getOcenjivanjeUcenika() {
		return ocenjivanjeUcenika;
	}




	public void setOcenjivanjeUcenika(Ucenik ocenjivanjeUcenika) {
		this.ocenjivanjeUcenika = ocenjivanjeUcenika;
	}





	public Ocena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste,
			List<Ocena> ocenjivanje, Set<Nastavnik> nastavnikOcena, Ucenik ocenjivanjeUcenika) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.nazivOcene = nazivOcene;
		this.date = date;
		this.polugodiste = polugodiste;
		Ocenjivanje = ocenjivanje;
		this.nastavnikOcena = nastavnikOcena;
		this.ocenjivanjeUcenika = ocenjivanjeUcenika;
	}




	public ZakljucnaOcena getZakljucivanjeOcena() {
		return zakljucivanjeOcena;
	}




	public void setZakljucivanjeOcena(ZakljucnaOcena zakljucivanjeOcena) {
		this.zakljucivanjeOcena = zakljucivanjeOcena;
	}




	public Ocena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste,
			List<Ocena> ocenjivanje, Set<Nastavnik> nastavnikOcena, Ucenik ocenjivanjeUcenika,
			ZakljucnaOcena zakljucivanjeOcena) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.nazivOcene = nazivOcene;
		this.date = date;
		this.polugodiste = polugodiste;
		Ocenjivanje = ocenjivanje;
		this.nastavnikOcena = nastavnikOcena;
		this.ocenjivanjeUcenika = ocenjivanjeUcenika;
		this.zakljucivanjeOcena = zakljucivanjeOcena;
	}




	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Integer getOcena() {
		return ocena;
	}



	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}



	public NazivOcene getNazivOcene() {
		return nazivOcene;
	}



	public void setNazivOcene(NazivOcene nazivOcene) {
		this.nazivOcene = nazivOcene;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public Polugodiste getPolugodiste() {
		return polugodiste;
	}



	public void setPolugodiste(Polugodiste polugodiste) {
		this.polugodiste = polugodiste;
	}



	public Ocena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.nazivOcene = nazivOcene;
		this.date = date;
		this.polugodiste = polugodiste;
	}





}
	
	