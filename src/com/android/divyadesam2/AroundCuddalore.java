package com.android.divyadesam2;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class AroundCuddalore extends AbstractActivity {
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "DivyaDesam2/aroundCuddalore/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundCuddalore);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}	
}
