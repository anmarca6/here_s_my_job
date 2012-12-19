package com.example.infojobsmapsgui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	// Attributes  0269 3656 3400  +++++ 4582 842
	private EditText upperEditText = null;
	private EditText middleEditText = null;
	private EditText bottomEditText = null;
	private Button searchButton = null;
	
	private String getURL = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Get reference layout components
		upperEditText = (EditText) findViewById(R.id.buscoOfertasTextField);
		middleEditText = (EditText) findViewById(R.id.deTextField);
		bottomEditText = (EditText) findViewById(R.id.enTextField);
		searchButton = (Button) findViewById(R.id.encuentraOfertasButton);
		searchButton.setOnClickListener(this);
	}

	/** OnClickListener method for button */
	public void onClick(View v) {
		if((upperEditText.getText().toString().equals(""))&&(middleEditText.getText().toString().equals(""))&&(bottomEditText.getText().toString().equals(""))) {
			Constants.showLog("todos los campos estan vacios");
		}
		
	}
}
