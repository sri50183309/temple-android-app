package com.android.kumbakonam;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class Around10KM extends AbstractActivity {

	/**
	 * Shown as instructions.
	 */
	
	private String[] comboxArray = null;
	
	private String assetFilePath = "Kumbakonam/Around10KM/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.kmu_Around10KM);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);
		
	}
}
