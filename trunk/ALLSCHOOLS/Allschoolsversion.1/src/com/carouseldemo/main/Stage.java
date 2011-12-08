package com.carouseldemo.main;


import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;


import java.io.*;
import org.json.*;





public class Stage extends Activity {
	//Button btnXML;
	//Button btnJSON;
	TextView tvData;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage);
        
        
       
       // btnXML = (Button) findViewById(R.id.btnXML);
        tvData = (TextView) findViewById(R.id.txtData);
        

      
        		examineJSONFile();
        		
        
        
    }
    
   
    void examineJSONFile()
    {
    	try
    	{
    
    		String x1 = "";
    		InputStream is = this.getResources().openRawResource(R.raw.stagejson);
    		byte [] buffer = new byte[is.available()];
    		while (is.read(buffer) != -1);
    		String jsonString = new String(buffer);
    		//JSONArray entries = new JSONArray(jsontext);
    		JSONObject jObject = new JSONObject(jsonString);
    		//x1 = "JSON parsed.\nThere are [" + jObject.length() + "]\n\n";
    		
    	
    		
    		JSONObject menuObject = jObject.getJSONObject("en");
    		
    		JSONObject popupObject = menuObject.getJSONObject("DataSource");
           // JSONArray menuitemArray = popupObject.getJSONArray("menuitem");
            //x = "JSON parsed.\nThere are [" + menuitemArray.length() + "]\n\n";
           // x1 += "------------\n";
			x1 +=  popupObject.getString("Text") + "\n";
			//x1 += "VALUE222:" +popupObject.getString("CellStyle") + "\n\n";

    		//for (i=0;i<menuitemArray.length();i++)
    			
    		{
    			
    			//x1 += menuitemArray.getJSONObject(i).getString("value")
                //.toString() + "\n";
    		//	x1 += menuitemArray.getJSONObject(i).getString(
              //  "onclick").toString()  + "\n";
    		}
    		tvData.setText(x1);
    		tvData.setText(x1);
    	}
    	catch (Exception je)
    	{
    		tvData.setText("Error w/file: " + je.getMessage());
    	}
    }
    
}
