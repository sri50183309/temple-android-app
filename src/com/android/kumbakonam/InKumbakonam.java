package com.android.kumbakonam;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class InKumbakonam extends AbstractActivity {

	/**
	 * Shown as instructions.
	 */
	
	private String[] comboxArray = null;
	
	private String assetFilePath = "Kumbakonam/InKumbakonam/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.kmu_InKumbakonam);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);
		
	}



}
