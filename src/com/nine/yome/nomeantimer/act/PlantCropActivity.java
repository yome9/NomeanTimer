package com.nine.yome.nomeantimer.act;

import java.util.ArrayList;
import java.util.List;

import com.nine.yome.nomeantimer.R;
import com.nine.yome.nomeantimer.app.Controller;
import com.nine.yome.nomeantimer.app.Pseudo;
import com.nine.yome.nomeantimer.model.Crop;
import com.nine.yome.nomeantimer.model.UserCrop;
import com.nine.yome.nomeantimer.utils.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PlantCropActivity extends Activity {
	private static final String TAG = PlantCropActivity.class.getSimpleName();
	
	// views
	private Spinner spiBreed;
	private Spinner spiCharactor;
	private Spinner spiChannel;
	private Button btnPlant;

	// member
	private ArrayList<String> breedList;
	private ArrayList<String> charactorList;
	private ArrayList<String> channelList;
	private String breed;
	private String charactor;
	private String channel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant_crop);

		breedList = (ArrayList<String>) getBreeds();
		charactorList = new ArrayList<String>();
		for (int i = 0; i < Pseudo.pCharactors.length; i++) {
			charactorList.add(Pseudo.pCharactors[i]);
		}
		channelList = new ArrayList<String>();
		channelList.add("1");
		channelList.add("2");
		channelList.add("3");
		initViews();
	}

	private void initViews() {
		// breed list
		spiBreed = (Spinner) findViewById(R.id.spi_plant_breed_list);
		ArrayAdapter<String> breedAdpter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, breedList);
		breedAdpter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spiBreed.setAdapter(breedAdpter);
		spiBreed.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				breed = (String) arg0.getItemAtPosition(arg2);
				changeItemState();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				breed = null;
			}
		});

		// charactor list
		spiCharactor = (Spinner) findViewById(R.id.spi_plant_charactor_list);
		ArrayAdapter<String> charactorAdpter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, charactorList);
		breedAdpter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spiCharactor.setAdapter(charactorAdpter);
		spiCharactor.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				charactor = (String) arg0.getItemAtPosition(arg2);
				changeItemState();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				charactor = null;
			}
		});

		// channel list
		spiChannel = (Spinner) findViewById(R.id.spi_plant_channel_list);
		ArrayAdapter<String> channelAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, channelList);
		breedAdpter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spiChannel.setAdapter(channelAdapter);
		spiChannel.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				channel = (String) arg0.getItemAtPosition(arg2);
				changeItemState();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				channel = null;
			}
		});

		// plant button
		btnPlant = (Button) findViewById(R.id.btn_plant_plant);
		btnPlant.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Crop crop = Pseudo.getCropDataByName(breed,
						PlantCropActivity.this);
				Utils.logD(TAG, "planted crop data");
				Utils.logD(TAG, "name = " + crop.getName());
				Utils.logD(TAG, "required = " + crop.getWaterRequired());
				Utils.logD(TAG, "initial = " + crop.getInitialWater());
				Utils.logD(TAG, "price = " + crop.getPrice());
				UserCrop userCrop = new UserCrop(crop, charactor, Integer
						.parseInt(channel));
				userCrop.startPlanting();
				Controller.getInstance().setTimer(PlantCropActivity.this,
						userCrop);
				finish();
			}
		});
	}

	private void changeItemState() {
		if (breed != null && charactor != null && channel != null) {
			btnPlant.setVisibility(View.VISIBLE);
		} else {
			btnPlant.setVisibility(View.GONE);
		}
	}

	private List<String> getBreeds() {
		ArrayList<String> breeds = new ArrayList<String>();

		breeds.add(getString(R.string.cropname_000));
		breeds.add(getString(R.string.cropname_001));
		breeds.add(getString(R.string.cropname_002));
		breeds.add(getString(R.string.cropname_003));
		breeds.add(getString(R.string.cropname_004));
		breeds.add(getString(R.string.cropname_005));

		return breeds;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
