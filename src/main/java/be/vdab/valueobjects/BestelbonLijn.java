package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BestelbonLijn implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long bonid;
	private Long wijnid;
	private int aantal;

	public BestelbonLijn() {
	}

	public BestelbonLijn(Long wijnid, int aantal) {
		this.wijnid = wijnid;
		this.aantal = aantal;
	}

	public BestelbonLijn(Long bonid, Long wijnid, int aantal) {
		this.bonid = bonid;
		this.wijnid = wijnid;
		this.aantal = aantal;
	}

	public Long getBonid() {
		return bonid;
	}

	public Long getWijnid() {
		return wijnid;
	}

	public int getAantal() {
		return aantal;
	}

}
