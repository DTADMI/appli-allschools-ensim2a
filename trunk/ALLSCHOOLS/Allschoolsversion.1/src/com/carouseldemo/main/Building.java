package com.carouseldemo.main;


import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;

import java.io.*;
import org.json.*;







public class Building extends Activity {
	//Button btnXML;
	//Button btnJSON;
	TextView tvData;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jensim);
        
        
        tvData = (TextView) findViewById(R.id.txtData);
       // btnXML = (Button) findViewById(R.id.btnXML);
      
        

      
        		examineJSONFile();
        
        
    }
    
   
    void examineJSONFile()
    {
    	try
    	{
    		
    		String x1 = "";
    		InputStream is = this.getResources().openRawResource(R.raw.building);
    		byte [] buffer = new byte[is.available()];
    		while (is.read(buffer) != -1);
    		String jsonString = new String(buffer);
    		//JSONArray entries = new JSONArray(jsontext);
    		JSONObject jObject = new JSONObject(jsonString);
    		//x1 = "JSON parsed.\nThere are [" + jObject.length() + "]\n\n";
    		
    		int i;
    		

    		
    		JSONObject menuObject = jObject.getJSONObject("fr");
    		
    		//
            JSONArray menuitemArray = menuObject.getJSONArray("DataSource");
           // JSONObject popupObject = menuObject.getJSONObject("Rows");
           // x1 =   menuitemArray.length() + "\n\n";
           // x1 += "------------\n";
			//x1 += "Stage:" + menuitemArray.getString("Name") + "\n"+"\n"+"\n"+"\n"+"\n";
			//x1 += "VALUE222:" +popupObject.getString("CellStyle") + "\n\n";
            JSONObject jSubObj = new JSONObject(menuitemArray.getJSONObject(0).toString());
            JSONObject jSubObj2 = new JSONObject(menuitemArray.getJSONObject(1).toString());
            JSONObject jSubObj3 = new JSONObject(menuitemArray.getJSONObject(2).toString());
            //JSONObject popupObject = jSubObj.getJSONObject("Rows");
            JSONArray menuitemArray1 = jSubObj.getJSONArray("Rows");
            JSONArray menuitemArray2 = jSubObj2.getJSONArray("Rows");
            JSONArray menuitemArray3 = jSubObj3.getJSONArray("Rows");
           // JSONArray menuitemArray3 = jSubObj3.getJSONArray("Rows");
           //JSONObject jSubObj1 = new JSONObject(menuitemArray1.getJSONObject(0).toString());
         //  JSONObject jSubObj4 = new JSONObject(menuitemArray3.getJSONObject(0).toString());
           // JSONObject jSubObj5 = new JSONObject(menuitemArray3.getJSONObject(0).toString());
			//x1 += "VALUE222:" +popupObject.getString("CellStyle") + "\n\n";
			x1 +=  jSubObj.getString("Header") + "\n\n";
           for (i=0;i<menuitemArray1.length();i++)
    			
    		{
    			
    			//x1 += menuitemArray2.getJSONObject(i).getString("TextLeft")
                //.toString() ;
    			x1 += "    "+menuitemArray1.getJSONObject(i).getString("Text")
    			.toString() + "\n\n";
    		}
			
			x1 +=  jSubObj2.getString("Header") + "\n\n";
			
			
			//x1 +=  jSubObj3.getString("TextLeft") + "\n\n";
			//x1 +=  jSubObj3.getString("TextRight") + "\n\n";

    		for (i=0;i<menuitemArray2.length();i++)
    			
    		{
    			
    			//x1 += menuitemArray2.getJSONObject(i).getString("TextLeft")
                //.toString() ;
    			x1 += "    "+menuitemArray2.getJSONObject(i).getString("Text")
    			.toString() + "\n\n";
    		}
    		x1 +=  jSubObj3.getString("Header") + "\n\n";
    		  for (i=0;i<menuitemArray3.length();i++)
      			
      		{
      			
      			//x1 += menuitemArray2.getJSONObject(i).getString("TextLeft")
                  //.toString() ;
      			x1 += "    "+menuitemArray3.getJSONObject(i).getString("Text")
      			.toString() + "\n\n";
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

