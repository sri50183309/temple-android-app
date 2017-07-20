package com.android.divyadesam1;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractDisplayActivity;

public class Guidance extends AbstractDisplayActivity {
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "DivyaDesam1/Guidance.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundAP);
		//super.callOnCreate(comboxArray, assetFilePath);
		super.callOnCreate(assetFilePath);
		super.onCreate(savedInstanceState);

	}
}
