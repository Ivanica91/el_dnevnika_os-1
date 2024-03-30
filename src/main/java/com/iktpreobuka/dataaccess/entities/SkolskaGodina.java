package com.iktpreobuka.dataaccess.entities;

import jakarta.persistence.Column;

public class SkolskaGodina {
	
	@Column
	private Polugodiste polugodiste;

	public Polugodiste getPolugodiste() {
		return polugodiste;
	}

	public void setPolugodiste(Polugodiste polugodiste) {
		this.polugodiste = polugodiste;
	}

	public SkolskaGodina() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
