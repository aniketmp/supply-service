package no.tusla.supplyservice.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.tusla.supplyservice.model.Supply;

import no.tusla.supplyservice.model.SupplyNextSeason;
import no.tusla.supplyservice.model.json.Model;
import no.tusla.supplyservice.model.json.ModelNextSeason;
import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SupplyRepositoryWithPopulator implements ApplicationListener<ContextRefreshedEvent>,
		ApplicationContextAware {

	private final Resource sourceDataSupplyPartner;

	private final Resource sourceDataNextSeason;

	private ApplicationContext applicationContext;

	private List<Supply> supplies = new ArrayList<>();

	private List<SupplyNextSeason> suppliesNewSeason = new ArrayList<>();

	public SupplyRepositoryWithPopulator() {
		sourceDataSupplyPartner = new ClassPathResource("tires-from-supplypartner.json");
		sourceDataNextSeason = new ClassPathResource("tires-for-nextseason.json");

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().equals(applicationContext)) {
			populate();
		}

	}

	@SuppressWarnings("unchecked")
	public void populate() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Model model = null;
		ModelNextSeason modelNextSeason = null;

		try {
			model = mapper.readValue(sourceDataSupplyPartner.getInputStream(), Model.class);
			modelNextSeason = mapper
					.readValue(sourceDataNextSeason.getInputStream(), ModelNextSeason.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (model != null) {
			if (model.getModelX() != null) {
				model.getModelX().stream()
						.forEach(modelx -> {
									supplies.add(new Supply("Model X", modelx.getSeason(), modelx.getTiremodel(),
											Double.parseDouble(modelx.getPrice()), modelx.getDeliverydate()));
								}
						);
			}
			if (model.getModelY() != null) {
				model.getModelY().stream()
						.forEach(modely -> {
									supplies.add(new Supply("Model Y", modely.getSeason(), modely.getTiremodel(),
											Double.parseDouble(modely.getPrice()), modely.getDeliverydate()));
								}
						);
			}
			if (model.getModelZ() != null) {
				model.getModelZ().stream()
						.forEach(modelz -> {
									System.out.println(modelz.getDeliverydate());
									supplies.add(new Supply("Model Z", modelz.getSeason(), modelz.getTiremodel(),
											Double.parseDouble(modelz.getPrice()), modelz.getDeliverydate()));
								}
						);
			}
		}

		if (modelNextSeason != null) {
			if (modelNextSeason.getModelXNextSeason() != null) {
				modelNextSeason.getModelXNextSeason().stream()
						.forEach(modelx -> {
									suppliesNewSeason.add(
											new SupplyNextSeason("Model X", modelx.getSeason(), modelx.getTiremodel(),
													Double.parseDouble(modelx.getPrice())));
								}
						);
			}
			if (modelNextSeason.getModelYNextSeason() != null) {
				modelNextSeason.getModelYNextSeason().stream()
						.forEach(modely -> {
									suppliesNewSeason.add(
											new SupplyNextSeason("Model Y", modely.getSeason(), modely.getTiremodel(),
													Double.parseDouble(modely.getPrice())));
								}
						);
			}
			if (modelNextSeason.getModelZNextSeason() != null) {
				modelNextSeason.getModelZNextSeason().stream()
						.forEach(modelz -> {
									suppliesNewSeason.add(
											new SupplyNextSeason("Model Z", modelz.getSeason(), modelz.getTiremodel(),
													Double.parseDouble(modelz.getPrice())));
								}
						);
			}
		}

	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public List<SupplyNextSeason> getSuppliesNewSeason() {
		return suppliesNewSeason;
	}

}