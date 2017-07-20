package com.android.divyadesam1;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class AroundMayavaram extends AbstractActivity {
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "DivyaDesam1/aroundMayavaram/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundMayavaram);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}
}
