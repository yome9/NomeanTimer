package com.nine.yome.nomeantimer.act;

import java.util.ArrayList;
import java.util.List;

import com.nine.yome.nomeantimer.R;
import com.nine.yome.nomeantimer.app.Controller;
import com.nine.yome.nomeantimer.model.UserCrop;
import com.nine.yome.nomeantimer.utils.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class CropsListActivity extends Activity {
	private static final String TAG = CropsListActivity.class.getSimpleName();

	// debug
	private List<String> debugList = new ArrayList<String>();

	// views
	private Button btnAddNewCrop;
	private ListView lstCrops;

	// member
	private ArrayAdapter<String> cropListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crops_list);

		initViews();
	}

	private void initViews() {
		// button to add new crop
		btnAddNewCrop = (Button) findViewById(R.id.btn_crops_addcrop);
		btnAddNewCrop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(CropsListActivity.this,
						PlantCropActivity.class));
			}
		});

		// crops list
		lstCrops = (ListView) findViewById(R.id.lst_crops_croplist);
		cropListAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		lstCrops.setAdapter(cropListAdapter);
	}

	@Override
	protected void onStart() {
		Utils.logD(TAG, "[CALL] onStart");
		super.onStart();

		if (Controller.getInstance().userCropList != null) {
			ArrayList<UserCrop> crops = Controller.getInstance().userCropList;
			Utils.logD(TAG, "--- crops list ---");
			debugList.clear();
			for (int i = 0; i < crops.size(); i++) {
				String cropName = crops.get(i).getName();
				String charaName = crops.get(i).getCharactor();
				int channel = crops.get(i).getChannel();
				String end = crops.get(i).getDisplayDate(crops.get(i).getCloneOfEndday());
				Utils.logD(TAG, "name" + cropName);
				Utils.logD(TAG, "charactor" + charaName);
				Utils.logD(TAG, "channel" + channel);
				debugList.add(cropName + "(" + channel + ")\n" + end + "\n" + charaName);
			}
		}
		updateList();
	}

	private void updateList() {
		cropListAdapter.clear();
		for (String s : debugList) {
			cropListAdapter.add(s);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
