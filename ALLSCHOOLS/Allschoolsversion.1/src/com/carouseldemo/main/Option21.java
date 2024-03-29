package com.carouseldemo.main;


import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * This example shows how to read xml file from res/xml folder
 *
 * @author FaYnaSoft Labs
 *
 */
public class Option21 extends Activity {
	private static String APP_TAG = "tag";
	private TextView textView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jensim);
		textView = (TextView) findViewById(R.id.txtData);
		//final TextView textView1 = (TextView) findViewById(R.id.description);
		
		
				XmlPullParser parser = getResources().getXml(R.xml.cdm);
				StringBuilder stringBuilder = new StringBuilder();
				StringBuilder stringBuilder1 = new StringBuilder();
				try {
					while (parser.next() != XmlPullParser.END_DOCUMENT) {
						String name = parser.getName();
						String name1 = parser.getName();
						int position = 0 ;
						String brand = null;
						
						if((name != null) && (name.equals("text"))) {
							int size = parser.getAttributeCount();
							for(int i = 0; i < size; i++) {
								String attrName = parser.getAttributeName(i);
								String attrValue = parser.getAttributeValue(i);
							   //  String bb	=parser.getText();	
							}
							
							
							if(parser.next() == XmlPullParser.TEXT)
				    		{if(parser.getText().equals("OPTION2-1 Architecture et administration des reseaux")){
				    			stringBuilder.append("\n\n"+parser.getText()+"\n\n");}
				    		}
							
							//	stringBuilder.append(  position + "\n");
							
						}
						if((name != null) && (name.equals("courseCode"))) {
							int size = parser.getAttributeCount();
							for(int i = 0; i < size; i++) {
								String attrName = parser.getAttributeName(i);
								String attrValue = parser.getAttributeValue(i);
							   //  String bb	=parser.getText();	
							}
							
							
							if(parser.next() == XmlPullParser.TEXT)
				    		{if(parser.getText().equals("OPTION2-1")){
				    			stringBuilder.append("\nCode   : "+parser.getText());}
				    		}
							
							//	stringBuilder.append(  position + "\n");
							
						}
						if((name != null) && (name.equals("credits"))) {
							int size = parser.getAttributeCount();
							for(int i = 0; i < size; i++) {
								String attrName = parser.getAttributeName(i);
								String attrValue = parser.getAttributeValue(i);
							   //  String bb	=parser.getText();	
							}
							
							
							if(parser.next() == XmlPullParser.TEXT)
				    		{if(parser.getText().equals("3")){
				    			stringBuilder.append("\nCresdits (ECTS): "+parser.getText());
				    		}
				    		}
							
							//	stringBuilder.append(  position + "\n");
							
						}
						if((name != null) && (name.equals("subBlock"))) {
							int size = parser.getAttributeCount();
							for(int i = 0; i < size; i++) {
								String attrName = parser.getAttributeName(i);
								String attrValue = parser.getAttributeValue(i);
							   //  String bb	=parser.getText();	
							}
							
							
							if(parser.next() == XmlPullParser.TEXT)
				    		{if(parser.getText().equals("35.0")){
				    			stringBuilder.append("\nGlobal Horaire: "+parser.getText());
				    		}
				    		}
							
							//	stringBuilder.append(  position + "\n");
							
						}
						if((name != null) && (name.equals("infoBlock"))) {
							int size = parser.getAttributeCount();
							for(int i = 0; i < size; i++) {
								String attrName = parser.getAttributeName(i);
								String attrValue = parser.getAttributeValue(i);
							   //  String bb	=parser.getText();	
							}
							
							
							if(parser.next() == XmlPullParser.TEXT)
				    		{if(parser.getText().contains("� Evolution d�un reseau.")){
				    			stringBuilder.append("\n\n\nDescription : "+parser.getText()+"\n\n");
				    		}
				    		}
							
							//	stringBuilder.append(  position + "\n");
							
						}
				
						textView.setText(stringBuilder.toString());
						//textView1.setText(stringBuilder1.toString());
					}
				}catch(Exception e) {
					Log.e(APP_TAG, e.getMessage());
				}
			}
		
	}

