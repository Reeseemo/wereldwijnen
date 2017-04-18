package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.repositories.BestelbonLijnRepository;
import be.vdab.valueobjects.BestelbonLijn;

public class BestelbonLijnService extends AbstractService {

	private final BestelbonLijnRepository bestelbonLijnRepository = new BestelbonLijnRepository();

	public List<BestelbonLijn> findAll() {
		return bestelbonLijnRepository.findAll();
	}

	public Optional<BestelbonLijn> read(long id) {
		return bestelbonLijnRepository.read(id);
	}

	public void create(BestelbonLijn bestelbonLijn) {
		beginTransaction();
		try {
			bestelbonLijnRepository.create(bestelbonLijn);
			commit();
		} catch (RuntimeException ex) {
			rollback();
			throw ex;
		}
	}

}
