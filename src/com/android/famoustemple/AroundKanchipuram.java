package com.android.famoustemple;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class AroundKanchipuram extends AbstractActivity {

	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "FamousTemple/aroundKanchi/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundKanchi);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}	
}
