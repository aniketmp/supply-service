/**
 * 
 */
package no.tusla.supplyservice.service;

import java.util.List;

import no.tusla.supplyservice.model.Supply;
import no.tusla.supplyservice.model.SupplyNextSeason;

/**
 * @author akanoong
 *
 */
public interface SupplyService {
	
	public List<Supply> checkDeliveryForTire(String model, String season);

	public List<SupplyNextSeason> checkNextSeasonForTire(String model);

}
