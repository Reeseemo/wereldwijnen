package be.vdab.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.vdab.valueobjects.BestelbonLijn;

public class Bestelbon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bonid"))
	@OrderBy("wijnid")
	private Set<BestelbonLijn> bestelbonlijnen;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp besteld;
	private String naam;
	private String straat;
	private String huisNr;
	private String postCode;
	private String gemeente;
	private short bestelwijze;

	protected Bestelbon() {
	}

	protected Bestelbon(String naam, String straat, String huisNr, String postCode, String gemeente,
			short bestelwijze) {
		super();
		this.naam = naam;
		this.straat = straat;
		this.huisNr = huisNr;
		this.postCode = postCode;
		this.gemeente = gemeente;
		this.bestelwijze = bestelwijze;
		this.bestelbonlijnen = new LinkedHashSet<>();
	}

}
