package no.tusla.supplyservice.model;

public class Supply {

	private String model;

	private String season;

	private String tireModel;

	private Double price;

	private String deliveryDate;

	public Supply() {
	}

	public Supply(String model, String season, String tireModel, double price, String deliveryDate) {
		this.model = model;
		this.season = season;
		this.tireModel = tireModel;
		this.price = price;
		this.deliveryDate = deliveryDate;
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

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
