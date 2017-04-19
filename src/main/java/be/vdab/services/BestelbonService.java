package be.vdab.services;

import java.util.Optional;

import be.vdab.entities.Bestelbon;
import be.vdab.repositories.BestelbonRepository;

public class BestelbonService extends AbstractService {

	private final BestelbonRepository bestelbonRepository = new BestelbonRepository();

	public Optional<Bestelbon> read(long id) {
		return bestelbonRepository.read(id);
	}

	public void create(Bestelbon bestelbon) {
		beginTransaction();
		try {
			bestelbonRepository.create(bestelbon);
			commit();
		} catch (RuntimeException ex) {
			rollback();
			throw ex;
		}
	}

}
