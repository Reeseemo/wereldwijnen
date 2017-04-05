package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Land;
import be.vdab.entities.Soort;

public class SoortRepository extends AbstractRepository {

	public List<Soort> findByCountry(Land land) {
		return getEntityManager().createNamedQuery("Soort.findByCountry", Soort.class).setParameter("landid", land.getId())
				.getResultList();
	}

	public Optional<Soort> read(long id) {
		return Optional.ofNullable(getEntityManager().find(Soort.class, id));
	}
}
