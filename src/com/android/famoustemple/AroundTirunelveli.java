package com.android.famoustemple;

import android.os.Bundle;

import com.android.R;
import com.android.util.AbstractActivity;

public class AroundTirunelveli extends AbstractActivity {

	/**
	 * Shown as instructions.
	 */

	private String[] comboxArray = null;

	private String assetFilePath = "FamousTemple/aroundTirunelveli/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		comboxArray = getResources().getStringArray(R.array.famous_intirunelveli);
		super.callOnCreate(comboxArray, assetFilePath);
		super.onCreate(savedInstanceState);

	}	
}
