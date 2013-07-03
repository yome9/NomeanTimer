package com.nine.yome.nomeantimer.model;

public class Crop {
	private String name;
	private int waterRequired;
	private int initialWater;
	private int price;

	public Crop(String name, int waterRequired, int initialWater, int price) {
		this.name = name;
		this.waterRequired = waterRequired;
		this.initialWater = initialWater;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getWaterRequired() {
		return waterRequired;
	}

	public int getInitialWater() {
		return initialWater;
	}

	public int getPrice() {
		return price;
	}
}
