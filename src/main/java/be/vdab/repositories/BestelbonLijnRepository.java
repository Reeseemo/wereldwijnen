package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.valueobjects.BestelbonLijn;

public class BestelbonLijnRepository extends AbstractRepository {

	public List<BestelbonLijn> findAll() {
		return getEntityManager().createNamedQuery("BestelbonLijn.findAll", BestelbonLijn.class).getResultList();
	}

	public Optional<BestelbonLijn> read(long id) {
		return Optional.ofNullable(getEntityManager().find(BestelbonLijn.class, id));
	}

	public void create(BestelbonLijn bestelbonLijn) {
		getEntityManager().persist(bestelbonLijn);
	}

}
