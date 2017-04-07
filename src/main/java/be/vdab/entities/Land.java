package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "landen")
public class Land implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@OneToMany(mappedBy = "land")
	@OrderBy("naam")
	private Set<Soort> soorten;

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Set<Soort> getSoorten() {
		return soorten;
	}

}
