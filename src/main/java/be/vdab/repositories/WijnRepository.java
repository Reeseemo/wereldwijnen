package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Land;
import be.vdab.entities.Soort;
import be.vdab.entities.Wijn;

public class WijnRepository extends AbstractRepository {

	public List<Wijn> findBySoort(Soort soort) {
		return getEntityManager().createNamedQuery("Wijn.findBySoort", Wijn.class)
				.setParameter("soortid", soort.getId()).getResultList();
	}

	public Optional<Wijn> read(long id) {
		return Optional.ofNullable(getEntityManager().find(Wijn.class, id));
	}
}
