package com.nine.yome.nomeantimer.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.nine.yome.nomeantimer.common.Consts;
import com.nine.yome.nomeantimer.model.UserCrop;
import com.nine.yome.nomeantimer.utils.Utils;

/**
 * コントローラ<br>
 * 
 * @author yome9
 * 
 */
public class Controller {
	private static final String TAG = Controller.class.getSimpleName();

	private static Controller instance;
	private static final Object singleLock = new Object();

	// for debug
	public ArrayList<UserCrop> userCropList;

	private Controller() {
	}

	/**
	 * <{@link Controller}>クラスのインスタンスを取得する<br>
	 * シングルトンパターン
	 * 
	 * @return <{@link Controller}>クラスのインスタンス
	 */
	public static Controller getInstance() {
		synchronized (singleLock) {
			if (instance == null)
				instance = new Controller();
		}

		return instance;
	}

	public List<UserCrop> getCropsList() {
		List<UserCrop> crops = new ArrayList<UserCrop>();
		// TODO 作物データの取得
		return crops;
	}

	/**
	 * アラームのセット
	 * 
	 * @param context
	 *            コンテキスト
	 * @param crop
	 *            栽培する作物
	 */
	public void setTimer(Context context, UserCrop crop) {
		Utils.logD(TAG, "[CALL] setTimer");
		Intent intent = new Intent(Consts.INTENT_CROP_ALARM);
		intent.putExtra(Consts.EXTRA_TYPE_CROPNAME, crop.getName());
		PendingIntent sender = PendingIntent
				.getBroadcast(context, 0, intent, 0);
		AlarmManager am = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
		Calendar end = crop.getCloneOfEndday();
		am.set(AlarmManager.RTC_WAKEUP, end.getTimeInMillis(), sender);

		// TODO 作物データのDB保存

		// TODO debug
		if (userCropList == null)
			userCropList = new ArrayList<UserCrop>();
		userCropList.add(crop);
	}

}
