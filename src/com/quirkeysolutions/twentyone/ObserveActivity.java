package com.quirkeysolutions.twentyone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ObserveActivity extends Activity {
	   /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.observe);
	       
	       TextView txtName = (TextView) findViewById(R.id.method1);
	       Button ObBtn = (Button) findViewById(R.id.goback);
	       
	       String text = " A panic attack can feel like a monster is about to pounce!  " +
	       		"\nYour natural reaction is to run and hide from this terrifying experience";
	       txtName.setText(text);
	       
	       ObBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					
					// Starting a new intent
					Intent obScreen = new Intent(getApplicationContext(), MainActivity.class);
					
					startActivity(obScreen);
					
				}
	        });
	       
	   }
	   
	
	

}
