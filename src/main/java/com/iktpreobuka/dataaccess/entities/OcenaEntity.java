package com.iktpreobuka.dataaccess.entities;

import java.time.LocalDate;
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
public class OcenaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column (name= "Ocena")
	private Integer ocena;
	@Column (name= "Naziv_ocene")
	private NazivOcene nazivOcene;
	@Column (name= "Datum")
	private LocalDate date;
	@Column (name= "Polugodiste")
	private Polugodiste polugodiste;
	
	@OneToMany(mappedBy = "ocena", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<PredmetEntity> ocenjivanje = new ArrayList<PredmetEntity>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Nastavnik_ocena", joinColumns =
	{ @JoinColumn(name = "Ocena_id") },
	inverseJoinColumns = { @JoinColumn(name = "Nastavnik_id") })
	private Set<NastavnikEntity> nastavnikOcena = new HashSet<NastavnikEntity>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ocenjenivanje_ucenika")
	private UcenikEntity ocenjivanjeUcenika ;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ocenaZakljucivanje_id")
	private ZakljucnaOcenaEntity zakljucivanjeOcena ;
	
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
	public OcenaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OcenaEntity(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.nazivOcene = nazivOcene;
		this.date = date;
		this.polugodiste = polugodiste;
	}

	public Set<NastavnikEntity> getNastavnikOcena() {
		return nastavnikOcena;
	}
	public void setNastavnikOcena(Set<NastavnikEntity> nastavnikOcena) {
		this.nastavnikOcena = nastavnikOcena;
	}
	public UcenikEntity getOcenjivanjeUcenika() {
		return ocenjivanjeUcenika;
	}
	public void setOcenjivanjeUcenika(UcenikEntity ocenjivanjeUcenika) {
		this.ocenjivanjeUcenika = ocenjivanjeUcenika;
	}
	public ZakljucnaOcenaEntity getZakljucivanjeOcena() {
		return zakljucivanjeOcena;
	}
	public void setZakljucivanjeOcena(ZakljucnaOcenaEntity zakljucivanjeOcena) {
		this.zakljucivanjeOcena = zakljucivanjeOcena;
	}

	public List<PredmetEntity> getOcenjivanje() {
		return ocenjivanje;
	}
	public void setOcenjivanje(List<PredmetEntity> ocenjivanje) {
		this.ocenjivanje = ocenjivanje;
	}
	public OcenaEntity(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste,
			List<PredmetEntity> ocenjivanje, Set<NastavnikEntity> nastavnikOcena, UcenikEntity ocenjivanjeUcenika,
			ZakljucnaOcenaEntity zakljucivanjeOcena) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.nazivOcene = nazivOcene;
		this.date = date;
		this.polugodiste = polugodiste;
		this.ocenjivanje = ocenjivanje;
		this.nastavnikOcena = nastavnikOcena;
		this.ocenjivanjeUcenika = ocenjivanjeUcenika;
		this.zakljucivanjeOcena = zakljucivanjeOcena;
	}
	
	
}
