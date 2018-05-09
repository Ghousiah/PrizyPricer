package com.prizy.pricer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	@Id
	private String barcode;
	private String name;
	private double price;
	private String description;
	private double avgPrice;
	private double lowestPrice;
	private double highestPrice;
	private double idealPrice;
	private int priceCollectCount;

	public Product() {
	}

	public Product(String name, double price, String description, double avgPrice, double lowestPrice,
			double highestPrice, double idealPrice, int priceCollectCount) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.avgPrice = avgPrice;
		this.lowestPrice = lowestPrice;
		this.highestPrice = highestPrice;
		this.idealPrice = idealPrice;
		this.priceCollectCount = priceCollectCount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public double getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}

	public double getIdealPrice() {
		return idealPrice;
	}

	public void setIdealPrice(double idealPrice) {
		this.idealPrice = idealPrice;
	}

	public int getPriceCollectCount() {
		return priceCollectCount;
	}

	public void setPriceCollectCount(int priceCollectCount) {
		this.priceCollectCount = priceCollectCount;
	}

	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", avgPrice=" + avgPrice + ", lowestPrice=" + lowestPrice + ", highestPrice=" + highestPrice
				+ ", idealPrice=" + idealPrice + ", priceCollectCount=" + priceCollectCount + "]";
	}

}
