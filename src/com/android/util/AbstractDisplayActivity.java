package com.android.util;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.R;

public abstract class AbstractDisplayActivity extends Activity {

	String assetFilePath = null;

	private TextView mInstructionsText;

		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.kmu);
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		// layout.setBackgroundColor(Color.WHITE);

		// Create help text
		mInstructionsText = new TextView(this);

		// Add the help, make it look decent
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		InputStream is;
		try {
			is = getAssets().open(assetFilePath);

			int size = is.available();

			// Read the entire asset into a local byte buffer.
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();

			// Convert the buffer into a string.
			String text = new String(buffer);

			mInstructionsText.setText(Html.fromHtml(text));
			
			mInstructionsText.setMovementMethod(LinkMovementMethod.getInstance());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScrollView scrollView = new ScrollView(this);
		layout.addView(mInstructionsText);
		
		if(assetFilePath.equalsIgnoreCase("DivyaDesam1/Guidance.txt")){
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(R.drawable.temple_contact_numbers_1);
			layout.addView(imageView);
		}
		scrollView.addView(layout, lp);

		// Set the layout as our content view
		setContentView(scrollView);
	}

	public void callOnCreate(String asetFilePath){
		this.assetFilePath = asetFilePath;
	}
	
}