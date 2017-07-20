package com.android.misc;

import com.android.util.AbstractDisplayActivity;

import android.os.Bundle;

public class FAQs extends AbstractDisplayActivity{
	//
	private String assetFilePath = "Misc/Faq.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.callOnCreate(assetFilePath);
		super.onCreate(savedInstanceState);
	}


}
