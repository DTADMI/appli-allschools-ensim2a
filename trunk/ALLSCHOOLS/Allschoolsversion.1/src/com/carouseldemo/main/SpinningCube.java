package com.carouseldemo.main;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

/**
 * The initial Android Activity, setting and initiating
 * the OpenGL ES Renderer Class @see Lesson06.java
 * 
 * @author Savas Ziplies (nea/INsanityDesign)
 */
public class SpinningCube extends Activity {

	/** The OpenGL View */
	private GLSurfaceView glSurface;

	/**
	 * Initiate the OpenGL View and set our own
	 * Renderer (@see Lesson06.java)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		//Create an Instance with this Activity
		glSurface = new GLSurfaceView(this);
		//Set our own Renderer and hand the renderer this Activity Context
		glSurface.setRenderer(new CubeRenderer(this));
		//Set the GLSurface as View to this Activity
		setContentView(glSurface);
		final int splashScreenDisplay = 10;

		// Change alpha from fully visible to partially visible.
		final Animation animation = new AlphaAnimation(1, (float) .180);
		animation.setDuration(900000000);
		animation.setInterpolator(new LinearInterpolator());
		animation.setRepeatCount(200000000);
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
					//loadingText.startAnimation(animation);

					/**
					 * Use while to get the splash screen time and increase the
					 * wait variable using sleep() for every 100ms.
					 */

					while (wait < splashScreenDisplay) {
						sleep(4000);
						wait += 2000;
					}
				} catch (Exception e) {
					System.out.println("EXc=" + e);
				} finally {

					/**
					 * Called after splash times up. Do some action after splash
					 * times up. Here we moved to another main activity class
					 */

					startActivity(new Intent(SpinningCube.this,
							TabBarExample.class));
					finish();
				}
			}
		};
		splashThread.start();

	}
	

	/**
	 * Remember to resume the glSurface
	 */
	@Override
	protected void onResume() {
		super.onResume();
		glSurface.onResume();
	}

	/**
	 * Also pause the glSurface
	 */
	@Override
	protected void onPause() {
		super.onPause();
		glSurface.onPause();
	}
	
}