package com.android.misc;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class MuruganTemple extends AbstractActivity{
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "Misc/MuruganTemple/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.misc_muruganTemple);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}	
}
