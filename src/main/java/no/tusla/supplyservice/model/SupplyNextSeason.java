package no.tusla.supplyservice.model;

public class SupplyNextSeason {

	private String model;

	private String season;

	private String tireModel;

	private Double price;

	public SupplyNextSeason() {
	}

	public SupplyNextSeason(String model, String season, String tireModel, double price) {
		this.model = model;
		this.season = season;
		this.tireModel = tireModel;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTireModel() {
		return tireModel;
	}

	public void setTireModel(String tireModel) {
		this.tireModel = tireModel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
