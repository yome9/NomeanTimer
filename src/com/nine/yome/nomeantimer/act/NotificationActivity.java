package com.nine.yome.nomeantimer.act;

import com.nine.yome.nomeantimer.R;
import com.nine.yome.nomeantimer.common.Consts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class NotificationActivity extends Activity {
	private static final String TAG = NotificationActivity.class
			.getSimpleName();
	
	private String cropName;

	TextView txtCropName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);

		Intent intent = getIntent();
		if(intent != null) {
			cropName = intent.getStringExtra(Consts.EXTRA_TYPE_CROPNAME);
		}
		initViews();
	}

	private void initViews() {
		txtCropName = (TextView) findViewById(R.id.txt_notification_crop_name);
		txtCropName.setText(cropName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
