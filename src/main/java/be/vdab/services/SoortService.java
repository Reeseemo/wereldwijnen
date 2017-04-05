package be.vdab.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import be.vdab.entities.Land;
import be.vdab.entities.Soort;
import be.vdab.repositories.LandRepository;
import be.vdab.repositories.SoortRepository;

public class SoortService {
	private final SoortRepository soortRepository = new SoortRepository();
	private final LandRepository landRepository = new LandRepository();

	public List<Soort> findByCountry(long id) {
		Optional<Land> optionalLand = landRepository.read(id);
		if (optionalLand.isPresent()) {
			return soortRepository.findByCountry(optionalLand.get());
		}
		return Collections.emptyList();
	}

	public Optional<Soort> read(long id) {
		return soortRepository.read(id);
	}
}
