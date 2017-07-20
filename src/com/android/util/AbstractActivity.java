package com.android.util;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.R;

public abstract class AbstractActivity extends Activity {

	String[] comboxArray = null;
	
	String assetFilePath = null;

	private TextView mInstructionsText;

	private Spinner mSpinner;

	private ImageView mImageView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		// setContentView(R.layout.kmu);
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		// layout.setBackgroundColor(Color.WHITE);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, comboxArray);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		mSpinner = new Spinner(this);
		mSpinner.setId(R.id.spinner);
		mSpinner.setAdapter(adapter);
		layout.addView(mSpinner, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));

		mSpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());

		// Create help text
		mInstructionsText = new TextView(this);

		mImageView = new ImageView(this);
		mImageView
				.setImageURI(Uri
						.parse("http://kumbakonamtemples.in/wp-content/pageflip/images/i_2n17uh4.jpg"));

		// Add the help, make it look decent
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		// lp.setMargins(10, 10, 10, 10);

		// layout.addView(mImageView);

		// mInstructionsText.setBackgroundColor(Color.WHITE);
		// mInstructionsText.setTextColor(Color.BLUE);

		ScrollView scrollView = new ScrollView(this);
		scrollView.addView(mInstructionsText);
		layout.addView(scrollView, lp);

		// Set the layout as our content view
		setContentView(layout);
	}

	public void callOnCreate(String[] comboArray, String asetFilePath ){
		this.comboxArray = comboArray;
		this.assetFilePath = asetFilePath;
		
	}
	
	public class MyOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {

			InputStream is;
			try {
				String Text = mSpinner.getSelectedItem().toString();

				is = getAssets().open(assetFilePath+Text + ".txt");

//				//get the resource id from the file name  
//				Context context = getBaseContext();
//	            int rID = getResources().getIdentifier("com.android:raw/kumbakonam/abimukeswarar",  "raw", "<application package class>");  
//	            //get the file as a stream  
//	            is = getResources().openRawResource(rID); 

				int size = is.available();

				// Read the entire asset into a local byte buffer.
				byte[] buffer = new byte[size];
				is.read(buffer);
				is.close();

				// Convert the buffer into a string.
				String text = new String(buffer);

				mInstructionsText.setText(Html.fromHtml(text));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void onNothingSelected(AdapterView parent) {
			// Do nothing.
		}
	}
}
