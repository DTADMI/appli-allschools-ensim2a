package com.carouseldemo.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class SplashScreen extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.splash);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		// Dithers the gradient so it's not banded and patchy
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

		/** set time to splash out */
		final int splashScreenDisplay = 30000000;

		// Change alpha from fully visible to partially visible.
		final Animation animation = new AlphaAnimation(1, (float) .180);
		animation.setDuration(20000);
		animation.setInterpolator(new LinearInterpolator());
		animation.setRepeatCount(20);
		// Reverse animation at the end so the loading text will fade back in.
		animation.setRepeatMode(Animation.REVERSE);
		// Creates a new TextView for the loading text defined in the linear
		// layout.
		final TextView loadingText = (TextView) findViewById(R.id.TextView01);

		/**
		 * Create a new thread to play animation and show the splash screen up
		 * to the splash time.
		 */

		Thread splashThread = new Thread() {

			int wait = 0;

			@Override
			public void run() {
				try {
					super.run();
					// Play the loading text animation
					loadingText.startAnimation(animation);

					/**
					 * Use while to get the splash screen time and increase the
					 * wait variable using sleep() for every 100ms.
					 */

					while (wait < splashScreenDisplay) {
						sleep(1000);
						wait += 500;
					}
				} catch (Exception e) {
					System.out.println("EXc=" + e);
				} finally {

					/**
					 * Called after splash times up. Do some action after splash
					 * times up. Here we moved to another main activity class
					 */

					startActivity(new Intent(SplashScreen.this,
							TabBarExample.class));
					finish();
				}
			}
		};
		splashThread.start();

	}
}
