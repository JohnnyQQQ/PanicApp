package com.quirkeysolutions.twentyone;



import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener  {
	
	Button ObBtn;
	
	protected Button start;
	protected Button emBtn;
	protected Button startB;
	protected MyCountDownTimer countDownTimer;
	public TextView text;
	private final long startTime = 21 * 1000;
	private final long interval = 1 * 1000;
	private boolean timerHasStarted = false;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ObBtn = (Button) findViewById(R.id.observeBtn);		
		emBtn = (Button) findViewById(R.id.embrace);	
		
		// CountDown Timer
		startB = (Button) this.findViewById(R.id.start);
		startB.setOnClickListener(this);
		
		text = (TextView) this.findViewById(R.id.timer);
		
	 countDownTimer = new MyCountDownTimer(startTime, interval);		
	 text.setText(text.getText() + String.valueOf(startTime/1000));
	  
	    
		//Listening to button event
		ObBtn.setOnClickListener(new View.OnClickListener() {

			@Override
		public void onClick(View v) {
				
				// Starting a new intent
				Intent obScreen = new Intent(getApplicationContext(), ObserveActivity.class);
				startActivity(obScreen);
			}
        });
		
		
		
	}// end OnCreate
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View arg0) {
		
		if (!timerHasStarted) {
			countDownTimer.start();
			timerHasStarted = true;
			startB.setText("STOP");
			
			} else {
				
			countDownTimer.cancel();
			timerHasStarted = false;
			startB.setText("RESTART");
			}
		
		
	}
	
	

	public class MyCountDownTimer extends CountDownTimer{
		
		public MyCountDownTimer(long startTime, long interval) {
			
			super(startTime, interval);
	}

		@Override
		public void onFinish() {
		
		text.setText("Time's up!");
		
		}
		
		@Override
		public void onTick(long millisUntilFinished) {
		
			text.setText("" + millisUntilFinished/1000);
			}
		
		
		
	}// end public inner class

	

}// end code
