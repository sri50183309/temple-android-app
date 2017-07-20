package com.android.navagraha;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class NavagrahaTempleInfos extends AbstractActivity {
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "Navagraha/TempleInfos/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.navgraha_temple);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}	
}
