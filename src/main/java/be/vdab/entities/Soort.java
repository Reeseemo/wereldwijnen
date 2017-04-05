package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "soorten")
public class Soort implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	private long landid;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "landid", insertable = false, updatable = false)
	private Land land;
	@OneToMany(mappedBy = "soort")
	@OrderBy("jaar")
	private Set<Wijn> wijnen;

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public long getLandid() {
		return landid;
	}

	public Land getLand() {
		return land;
	}

	public Set<Wijn> getWijnen() {
		return wijnen;
	}

}
