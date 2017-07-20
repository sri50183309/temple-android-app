package com.android.kumbakonam;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class Around25KM extends AbstractActivity {
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "Kumbakonam/Around25KM/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.kmu_Around25KM);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}
}
