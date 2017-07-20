package com.android.divyadesam1;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class AroundKumbakonam extends AbstractActivity {

	/**
	 * Shown as instructions.
	 */
	
	private String[] comboxArray = null;
	
	private String assetFilePath = "DivyaDesam1/aroundkmu/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundKumbakonam);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);
		
	}


}
