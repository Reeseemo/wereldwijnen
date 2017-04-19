package be.vdab.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import be.vdab.valueobjects.BestelbonLijn;

public class Bestelbon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@Transient
//	@ElementCollection
//	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bonid"))
//	@OrderBy("wijnid")
//	private Set<BestelbonLijn> bestelbonlijnen;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "besteld")
	private Timestamp besteld;
	private String naam;
	private String straat;
	private String huisNr;
	private String postCode;
	private String gemeente;
	private short bestelwijze;

	public Bestelbon() {
	}

	public Bestelbon(String naam, String straat, String huisNr, String postCode, String gemeente, short bestelwijze) {
		setNaam(naam);
		setStraat(straat);
		setHuisNr(huisNr);
		setPostCode(postCode);
		setGemeente(gemeente);
		setBestelwijze(bestelwijze);

	}

	public static boolean isNaamValid(String naam) {
		return naam != null && !naam.trim().isEmpty();
	}

	public static boolean isStraatValid(String straat) {
		return straat != null && !straat.trim().isEmpty();
	}

	public static boolean isHuisNrValid(String huisNr) {
		return huisNr != null && !huisNr.trim().isEmpty();
	}

	public static boolean isPostCodeValid(String postCode) {
		return postCode != null && !postCode.trim().isEmpty();
	}

	public static boolean isGemeenteValid(String gemeente) {
		return gemeente != null && !gemeente.trim().isEmpty();
	}
//
//	public Set<BestelbonLijn> getBestelbonlijnen() {
//		return bestelbonlijnen;
//	}
//
//	public void setBestelbonlijnen(Set<BestelbonLijn> bestelbonlijnen) {
//		this.bestelbonlijnen = bestelbonlijnen;
//	}
//
	public Timestamp getBesteld() {
		return besteld;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (!isNaamValid(naam)) {
			throw new IllegalArgumentException();
		}
		this.naam = naam;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		if (!isStraatValid(straat)) {
			throw new IllegalArgumentException();
		}
		this.straat = straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public void setHuisNr(String huisNr) {
		if (!isHuisNrValid(huisNr)) {
			throw new IllegalArgumentException();
		}
		this.huisNr = huisNr;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		if (!isPostCodeValid(postCode)) {
			throw new IllegalArgumentException();
		}
		this.postCode = postCode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		if (!isGemeenteValid(gemeente)) {
			throw new IllegalArgumentException();
		}
		this.gemeente = gemeente;
	}

	public short getBestelwijze() {
		return bestelwijze;
	}

	public void setBestelwijze(short bestelwijze) {
		this.bestelwijze = bestelwijze;
	}

}
