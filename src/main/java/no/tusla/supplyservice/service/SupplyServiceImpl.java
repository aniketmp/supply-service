package no.tusla.supplyservice.service;

import java.util.List;
import java.util.stream.Collectors;

import no.tusla.supplyservice.model.SupplyNextSeason;
import no.tusla.supplyservice.repository.SupplyRepositoryWithPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.tusla.supplyservice.model.Supply;

@Service
public class SupplyServiceImpl implements SupplyService {

	private SupplyRepositoryWithPopulator repository;

	@Autowired
	public SupplyServiceImpl(SupplyRepositoryWithPopulator repository) {
		this.repository = repository;
	}

	//service to get the tire details along with delivery date for supplied season and model
	public List<Supply> checkDeliveryForTire(String model, String season) {
		return repository.getSupplies().stream().filter(
				supply -> model.equalsIgnoreCase(supply.getModel()) && season
						.equalsIgnoreCase(supply.getSeason()))
				.collect(Collectors.toList());

	}

	//service to get the tire details for supplied model
	public List<SupplyNextSeason> checkNextSeasonForTire(String model) {
		return repository.getSuppliesNewSeason().stream()
				.filter(supply -> model.equalsIgnoreCase(supply.getModel()))
				.collect(Collectors.toList());
	}

}
