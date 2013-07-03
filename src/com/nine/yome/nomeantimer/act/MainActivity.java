package com.nine.yome.nomeantimer.act;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.nine.yome.nomeantimer.R;
import com.nine.yome.nomeantimer.utils.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String TAG = MainActivity.class.getSimpleName();

	Button btnShowCrops;
	Button btnShowCropsByChara;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
//		TimeZone zone = TimeZone.getDefault();
//		String timezone = zone.getID();
//		Utils.logD(TAG, "timezone = " + timezone);
//		long unix = System.currentTimeMillis();
//		Utils.logD(TAG, "unix time = " + unix);
//		Time time = new Time(timezone);
//		time.setToNow();
//		Utils.logD(TAG, "time = " + time.year + "/" + time.month + "/"
//				+ time.monthDay + "/" + time.hour + "/" + time.minute + "/"
//				+ time.second);
//		Utils.logD(TAG, "time(toMillis) = " + time.toMillis(false));
//		Utils.logD(TAG, "timezone = " + time.timezone);
//		Calendar calendar = Calendar.getInstance();
//		Utils.logD(
//				TAG,
//				"calender = " + calendar.get(Calendar.YEAR) + "/"
//						+ calendar.get(Calendar.MONTH) + "/"
//						+ calendar.get(Calendar.DAY_OF_MONTH) + "/"
//						+ calendar.get(Calendar.HOUR_OF_DAY) + "/"
//						+ calendar.get(Calendar.MINUTE) + "/"
//						+ calendar.get(Calendar.SECOND));
//		Utils.logD(TAG, "calender(toMillis) = " + calendar.getTimeInMillis());
//		Utils.logD(TAG, "timezone = " + calendar.getTimeZone().getID());
//		try {
//			Thread.sleep(1000 * 3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Utils.logD(
//				TAG,
//				"calender = " + calendar.get(Calendar.YEAR) + "/"
//						+ calendar.get(Calendar.MONTH) + "/"
//						+ calendar.get(Calendar.DAY_OF_MONTH) + "/"
//						+ calendar.get(Calendar.HOUR_OF_DAY) + "/"
//						+ calendar.get(Calendar.MINUTE) + "/"
//						+ calendar.get(Calendar.SECOND));
//		Utils.logD(TAG, "calender(toMillis) = " + calendar.getTimeInMillis());
//		Calendar calendar2 = Calendar.getInstance();
//		Utils.logD(
//				TAG,
//				"calender = " + calendar2.get(Calendar.YEAR) + "/"
//						+ calendar2.get(Calendar.MONTH) + "/"
//						+ calendar2.get(Calendar.DAY_OF_MONTH) + "/"
//						+ calendar2.get(Calendar.HOUR_OF_DAY) + "/"
//						+ calendar2.get(Calendar.MINUTE) + "/"
//						+ calendar2.get(Calendar.SECOND));
//		Utils.logD(TAG, "calender(toMillis) = " + calendar2.getTimeInMillis());
//		calendar2.add(Calendar.SECOND, 10);
//		Utils.logD(
//				TAG,
//				"calender = " + calendar2.get(Calendar.YEAR) + "/"
//						+ calendar2.get(Calendar.MONTH) + "/"
//						+ calendar2.get(Calendar.DAY_OF_MONTH) + "/"
//						+ calendar2.get(Calendar.HOUR_OF_DAY) + "/"
//						+ calendar2.get(Calendar.MINUTE) + "/"
//						+ calendar2.get(Calendar.SECOND));
//		Utils.logD(TAG, "calender(toMillis) = " + calendar2.getTimeInMillis());
//		calendar2.add(Calendar.SECOND, 60 * 60 * 24);
//		Utils.logD(
//				TAG,
//				"calender = " + calendar2.get(Calendar.YEAR) + "/"
//						+ calendar2.get(Calendar.MONTH) + "/"
//						+ calendar2.get(Calendar.DAY_OF_MONTH) + "/"
//						+ calendar2.get(Calendar.HOUR_OF_DAY) + "/"
//						+ calendar2.get(Calendar.MINUTE) + "/"
//						+ calendar2.get(Calendar.SECOND));
//		Utils.logD(TAG, "calender(toMillis) = " + calendar2.getTimeInMillis());
	}

	private void initViews() {
		btnShowCrops = (Button) findViewById(R.id.btn_main_show_crops);
		// set event: displaying a crops list
		btnShowCrops.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,
						CropsListActivity.class));
			}
		});

		btnShowCropsByChara = (Button) findViewById(R.id.btn_main_show_crops_by_chara);
		btnShowCropsByChara.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO set event
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
