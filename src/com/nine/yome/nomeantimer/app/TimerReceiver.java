package com.nine.yome.nomeantimer.app;

import com.nine.yome.nomeantimer.act.NotificationActivity;
import com.nine.yome.nomeantimer.common.Consts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TimerReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent intent) {
		String action = intent.getAction();
		
		if(Consts.INTENT_CROP_ALARM.equals(action)) {
			String name = intent.getStringExtra(Consts.EXTRA_TYPE_CROPNAME);
			
			Intent notify = new Intent(arg0, NotificationActivity.class);
			notify.putExtra(Consts.EXTRA_TYPE_CROPNAME, name);
			notify.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			arg0.startActivity(notify);
		}
	}

}
