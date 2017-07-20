package com.android.divyadesam2;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class AroundTirunelveli extends AbstractActivity {
	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "DivyaDesam2/aroundTirunelveli/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.dd_aroundTirunelveli);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}	
}
