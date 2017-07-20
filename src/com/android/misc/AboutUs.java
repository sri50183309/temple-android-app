package com.android.misc;

import android.os.Bundle;

import com.android.util.AbstractDisplayActivity;

public class AboutUs extends AbstractDisplayActivity {
	//
	private String assetFilePath = "Misc/AboutUs.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.callOnCreate(assetFilePath);
		super.onCreate(savedInstanceState);
	}

}
