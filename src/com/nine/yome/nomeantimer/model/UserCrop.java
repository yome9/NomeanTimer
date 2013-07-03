package com.nine.yome.nomeantimer.model;

import java.util.Calendar;

import com.nine.yome.nomeantimer.common.Consts;

public class UserCrop {
	private Crop crop;
	private String charactorName;
	private int channel;
	private int givenWater;
	private Calendar startDay;
	private Calendar endDay;

	public UserCrop(Crop crop, String charactor, int channel) {
		this.crop = crop;
		this.charactorName = charactor;
		this.channel = channel;
	}

	public void startPlanting() {
		this.startDay = Calendar.getInstance();
		this.endDay = (Calendar) startDay.clone();
		endDay.add(Calendar.SECOND, crop.getWaterRequired());
	}

	public String getName() {
		return crop.getName();
	}

	public String getCharactor() {
		return charactorName;
	}

	public int getChannel() {
		return channel;
	}

	public String getDisplayDate(Calendar calendar) {
		String display = (calendar.get(Calendar.MONTH) + 1) + "/"
				+ calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.HOUR_OF_DAY) + ":"
				+ calendar.get(Calendar.MINUTE) + ":"
				+ calendar.get(Calendar.SECOND);
		
		return display;
	}

	public Calendar getCloneOfEndday() {
		return (Calendar) this.endDay.clone();
	}

	public void setWater(int type) {
		int water = 0;

		switch (type) {
		case Consts.WATER_TYPE_SMALL:
			water = Consts.WATER_AMOUNT_SMALL;
			break;
		case Consts.WATER_TYPE_MEDIUM:
			water = Consts.WATER_AMOUNT_MEDIUM;
			break;
		case Consts.WATER_TYPE_LARGE:
			water = Consts.WATER_AMOUNT_LARGE;
			break;
		}

		givenWater += water;
	}

	private int calculateRquiredSec(int initial, int required) {
		long completion = -1;

		completion = (required - initial) / 10;

		return (int) completion;
	}
}
