package no.tusla.supplyservice.controller;

import java.util.List;
import no.tusla.supplyservice.model.Supply;
import no.tusla.supplyservice.model.SupplyNextSeason;
import no.tusla.supplyservice.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "v1")
public class SupplyController {


  @Autowired
  SupplyService supplyService;

	@Autowired
	public SupplyController(SupplyService supplyService) {
		this.supplyService = supplyService;
	}


	@RequestMapping(value = "/supply/{model}/{season}", method = RequestMethod.GET)
	public List<Supply> checkDeliveryForTires(
			@PathVariable("model") String model,
			@PathVariable("season") String season){

		List<Supply> supplyList = supplyService.checkDeliveryForTire(model, season);
		System.out.println("Response from server:" + supplyList);
		return supplyList;
	}

	@RequestMapping(value = "supply/nextseason/{model}", method = RequestMethod.GET)
	public List<SupplyNextSeason> checkNextSeasonForTires(
			@PathVariable("model") String model) {

		return supplyService.checkNextSeasonForTire(model);

	}

	@Value("${supplyServiceMsg}")
	private String msg;

	@RequestMapping("/msg")
	String getMsg() {
		return this.msg;
	}

}
