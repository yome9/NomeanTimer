package com.nine.yome.nomeantimer.common;

/**
 * 共通クラス<br>
 * 各定数などを記述
 * 
 * @author ksu
 * 
 */
public class Consts {
	/**
	 * 収穫通知アラーム用Intent
	 */
	public static final String INTENT_CROP_ALARM = "com.nine.yome.nomeantimer.clop.alarm";
	public static final String EXTRA_TYPE_CROPNAME = "crop_name";
	/**
	 * ジョウロ種別(小)
	 */
	public static final int WATER_TYPE_SMALL = 0;
	/**
	 * ジョウロ種別(中)
	 */
	public static final int WATER_TYPE_MEDIUM = 1;
	/**
	 * ジョウロ種別(大)
	 */
	public static final int WATER_TYPE_LARGE = 2;
	/**
	 * ジョウロ水量(小)
	 */
	public static final int WATER_AMOUNT_SMALL = 100;
	/**
	 * ジョウロ水量(中)
	 */
	public static final int WATER_AMOUNT_MEDIUM = 1000;
	/**
	 * ジョウロ水量(大)
	 */
	public static final int WATER_AMOUNT_LARGE = 100000;
}
