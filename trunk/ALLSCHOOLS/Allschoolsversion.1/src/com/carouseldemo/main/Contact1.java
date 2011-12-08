package com.carouseldemo.main;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Contact1 extends ListActivity {
	Animation anim = null;
	/** Called when the activity is first created. */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		//anim = AnimationUtils.loadAnimation( this, R.anim.magnify );
		ArrayList<String> mListImages;
		mListImages = adil();
		
		// Create an ArrayAdapter, that will actually make the Strings above
		// appear in the ListView
		this.setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mListImages));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		//Object o = this.getListAdapter().getItem(position);
	//	String keyword = o.toString();
		//Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_LONG)
			//	.show();
		 //v.startAnimation( anim );
	}
	public  ArrayList<String> adil(){
		XmlPullParser parser = getResources().getXml(R.xml.cdm);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic = new ArrayList<String>();
		try  {
			while (parser.next() != XmlPullParser.END_DOCUMENT) {
				String name = parser.getName();
				String name1 = parser.getName();
				int position = 0 ;
				String brand = null;
				String brand1 = null;
				String brand2 = null;
				String brand3 = null;
				String brand4 = null;
				if((name != null) && (name.equals("text"))) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					   //  String bb	=parser.getText();	
					}
					
					
					if(parser.next() == XmlPullParser.TEXT)
		    		{if((parser.getText().equals("Carlier Florent")||(parser.getText().equals("Responsable pédagogique ASTRE")))){
		    			brand1=""+parser.getText();
		    			listFic.add(new String( brand1 ));}
		    		}
					
					//	stringBuilder.append(  position + "\n");
					
				}
				
				
		
				
				if((name != null) && (name.equals("telephone"))) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					   //  String bb	=parser.getText();	
					}
					
					
					if(parser.next() == XmlPullParser.TEXT)
		    		{if(parser.getText().equals("02 43 83 3979")){
		    			brand2="Téléphone :  "+parser.getText();
		    			listFic.add(new String( brand2 ));
		    		}
		    		}
					
					//	stringBuilder.append(  position + "\n");
					
				}
				if((name != null) && (name.equals("fax"))) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					   //  String bb	=parser.getText();	
					}
					
					
					if(parser.next() == XmlPullParser.TEXT)
		    		{if(parser.getText().equals("+33 2 43 83 37 94")){
		    			brand3="Fax : "+parser.getText();
		    			listFic.add(new String( brand3 ));

		    		}
		    		}
					
					//	stringBuilder.append(  position + "\n");
					
				}
				if((name != null) && (name.equals("email"))) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					   //  String bb	=parser.getText();	
					}
					
					
					if(parser.next() == XmlPullParser.TEXT)
		    		{if(parser.getText().contains("florent.carlier")){
		    			brand4="Email"+parser.getText();
		    			listFic.add(new String( brand4 ));
		    		}
		    		}
					
					//	stringBuilder.append(  position + "\n");
					
				}
			}
		}
		catch(Exception e) {
			//Log.e(APP_TAG, e.getMessage());
		}

		return listFic;
	}
}
