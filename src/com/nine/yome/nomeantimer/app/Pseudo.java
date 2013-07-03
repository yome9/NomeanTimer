package com.nine.yome.nomeantimer.app;

import android.content.Context;

import com.nine.yome.nomeantimer.R;
import com.nine.yome.nomeantimer.model.Crop;

public class Pseudo {
	// charactors
	public static final String pCharactor0 = "charactor1";
	public static final String pCharactor1 = "charactor2";
	public static final String pCharactor2 = "EnnuiTouko";
	public static final String[] pCharactors = {
			pCharactor0, pCharactor1, pCharactor2
	};

	// crop time
	public static final int pCropTime0 = 20;
	public static final int pCropTime1 = 360;
	public static final int pCropTime2 = 1800;
	public static final int pCropTime3 = 5400;
	public static final int pCropTime4 = 86400;
	public static final int pCropTime5 = 172800;
	public static final int[] pCropTimes = {
			pCropTime0, pCropTime1, pCropTime2, pCropTime3, pCropTime4,
			pCropTime5
	};

	// initial water
	public static final int pInitialCropTime0 = 500;
	public static final int pInitialCropTime1 = 3240;
	public static final int pInitialCropTime2 = 16200;
	public static final int pInitialCropTime3 = 48600;
	public static final int pInitialCropTime4 = 714000;
	public static final int pInitialCropTime5 = 900000;
	public static final int[] pInitialCropTimes = {
			pInitialCropTime0, pInitialCropTime1, pInitialCropTime2,
			pInitialCropTime3, pInitialCropTime4, pInitialCropTime5
	};

	public static int getCropIndexByName(Context context, String name) {
		int index = -1;

		if (name.equals(context.getString(R.string.cropname_000))) {
			index = 0;
		} else if (name.equals(context.getString(R.string.cropname_001))) {
			index = 1;
		} else if (name.equals(context.getString(R.string.cropname_002))) {
			index = 2;
		} else if (name.equals(context.getString(R.string.cropname_003))) {
			index = 3;
		} else if (name.equals(context.getString(R.string.cropname_004))) {
			index = 4;
		} else if (name.equals(context.getString(R.string.cropname_005))) {
			index = 5;
		}

		return index;
	}

	public static Crop getCropDataByName(String name, Context context) {
		Crop crop = null;
		int index = getCropIndexByName(context, name);

		if (index >= 0)
			crop = new Crop(name, pCropTimes[index], pInitialCropTimes[index],
					0);

		return crop;
	}
}
