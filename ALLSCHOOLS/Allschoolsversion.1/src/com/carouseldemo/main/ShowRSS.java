package com.carouseldemo.main;


import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;

/**
 *AADJOU ADIL

 */
public class ShowRSS extends Activity {
	
	 @Override
	public void onCreate(Bundle icicle) 
	    {
	        super.onCreate(icicle);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.showrss);
	        
	        String myFeed = null;
	        
	        //get the intent that launch this
	        Intent myIntent = getIntent();
	        
	        //If the intent is not null, use its data
	        if (myIntent != null)
	        {
	        	//retrieve the data send with the intent
	        	Bundle b = myIntent.getBundleExtra("android.intent.extra.INTENT");
	        	//Make the content of the String
	        	myFeed = b.getString("title") + "br"+"\n\n" + b.getString("author") +  b.getString("pubdate") + "\n\n" + b.getString("description").replace('\n',' ') + "\n\nMore information:\n" + b.getString("link");
	    		
	        }
	        //else put "information not found" in the string
	        else
	        {
	        	myFeed = "Information Not Found.";
	        
	        }
	        
	        TextView db= (TextView) findViewById(R.id.storybox);
	        //Set the text of the textview
	        db.setText(myFeed);
	        
	        Button next1 = (Button) findViewById(R.id.button1);
	        next1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), TabBarExample.class);
	                startActivityForResult(myIntent, 0);
	            }
	        });   
	    }
	 
}
