package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Wijn;

public class WijnRepository extends AbstractRepository {
	public List<Wijn> findAll() {
		return getEntityManager().createNamedQuery("Wijn.findAll", Wijn.class).getResultList();
	}

	public Optional<Wijn> read(long id) {
		return Optional.ofNullable(getEntityManager().find(Wijn.class, id));
	}
}
