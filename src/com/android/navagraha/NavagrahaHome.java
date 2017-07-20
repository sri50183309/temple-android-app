package com.android.navagraha;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractDisplayActivity;

public class NavagrahaHome extends AbstractDisplayActivity {
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "Navagraha/Home.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundAP);
		//super.callOnCreate(comboxArray, assetFilePath);
		super.callOnCreate(assetFilePath);
		super.onCreate(savedInstanceState);

	}
}
