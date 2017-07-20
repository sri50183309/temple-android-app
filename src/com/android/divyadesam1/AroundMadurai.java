package com.android.divyadesam1;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class AroundMadurai extends AbstractActivity {
	/**
	 * Shown as instructions.
	 */
	
	private String[] comboxArray = null;
	
	private String assetFilePath = "DivyaDesam1/aroundMadurai/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundMadurai);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);
		
	}
}
