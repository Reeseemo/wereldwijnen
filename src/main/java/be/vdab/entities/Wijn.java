package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wijnen")
public class Wijn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long soortid;
	private short jaar;
	private byte beoordeling;
	private BigDecimal prijs;
	private int inBestelling;

	public long getId() {
		return id;
	}

	public long getSoortid() {
		return soortid;
	}

	public short getJaar() {
		return jaar;
	}

	public byte getBeoordeling() {
		return beoordeling;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public int getInBestelling() {
		return inBestelling;
	}

}
