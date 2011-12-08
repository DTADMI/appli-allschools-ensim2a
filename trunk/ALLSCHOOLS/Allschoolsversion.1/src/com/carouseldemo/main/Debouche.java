package com.carouseldemo.main;


import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;

import java.io.*;
import org.json.*;



public class Debouche extends Activity {
	//Button btnXML;
	//Button btnJSON;
	TextView tvData;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage);
        
        
        tvData = (TextView) findViewById(R.id.txtData);
       // btnXML = (Button) findViewById(R.id.btnXML);
      
        

      
        		examineJSONFile();
        
        
    }
    
   
    void examineJSONFile()
    {
    	try
    	{
    		
    		String x1 = "";
    		InputStream is = this.getResources().openRawResource(R.raw.debouche);
    		byte [] buffer = new byte[is.available()];
    		while (is.read(buffer) != -1);
    		String jsonString = new String(buffer);
    		//JSONArray entries = new JSONArray(jsontext);
    		JSONObject jObject = new JSONObject(jsonString);
    		//x1 = "JSON parsed.\nThere are [" + jObject.length() + "]\n\n";
    		
    		int i;
    		
    		JSONObject menuObject = jObject.getJSONObject("fr");
    		
    		//JSONObject popupObject = menuObject.getJSONObject("DataSource");
            JSONArray menuitemArray = menuObject.getJSONArray("DataSource");
            
           // x1 =   menuitemArray.length() + "\n\n";
           // x1 += "------------\n";
			//x1 += "Stage:" + menuitemArray.getString("Name") + "\n"+"\n"+"\n"+"\n"+"\n";
			//x1 += "VALUE222:" +popupObject.getString("CellStyle") + "\n\n";
         

    		for (i=0;i<menuitemArray.length();i++)
    			
    		{
    			
    			x1 += menuitemArray.getJSONObject(i).getString("Name")
                .toString() + "\n";
    			if(x1=="0"){
    			x1 += menuitemArray.getJSONObject(i).getString(
                "Text").toString()  + "\n";}
    		}
for (i=0;i<menuitemArray.length();i++)
    			
    		{
    			
    			
    			x1 += menuitemArray.getJSONObject(i).getString(
                "Text").toString()  + "\n";
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
