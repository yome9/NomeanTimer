package com.nine.yome.nomeantimer.utils;

import java.util.Calendar;

import android.util.Log;

public class Utils {
	private static final boolean isLogging = true;
	
	public static void logD(String tag, String msg) {
		if(isLogging)
			Log.d(tag + "@Nomean", msg);
	}

	public static long getNowTime() {
		long time = -1;

		Calendar calendar = Calendar.getInstance();
		calendar.getTimeInMillis();
		return time;
	}

	public static String getDate(long time) {
		String date = null;

		return date;
	}
}
