package be.vdab.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import be.vdab.entities.Soort;
import be.vdab.entities.Wijn;
import be.vdab.repositories.SoortRepository;
import be.vdab.repositories.WijnRepository;

public class WijnService {

	private final WijnRepository wijnRepository = new WijnRepository();
	private final SoortRepository soortRepository = new SoortRepository();

	public List<Wijn> findBySoort(long id) {
		Optional<Soort> optionalSoort = soortRepository.read(id);
		if (optionalSoort.isPresent()) {
			return wijnRepository.findBySoort(optionalSoort.get());
		}
		return Collections.emptyList();
	}

	public Optional<Wijn> read(long id) {
		return wijnRepository.read(id);
	}
}
