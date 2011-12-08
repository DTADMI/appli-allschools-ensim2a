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

public class Tabpar3 extends ListActivity {
	Animation anim = null;
	/** Called when the activity is first created. */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		//anim = AnimationUtils.loadAnimation( this, R.anim.magnify );
		ArrayList<String> mListImages;
		mListImages = adil();
		//String[] names = new String[] { "Linux", "Windows7", "Eclipse", "Suse",
			//	"Ubuntu", "Solaris", "Android", "iPhone"};
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
		//String keyword = o.toString();
		//Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_LONG)
			//	.show();
		 //v.startAnimation( anim );
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
	public  ArrayList<String> adil(){
		XmlPullParser parser = getResources().getXml(R.xml.cdmapp);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic = new ArrayList<String>();
		try { 
			while ((parser.next() != XmlPullParser.END_DOCUMENT)){
				String name = parser.getName();
				
				String ident = null;
		
			
				
			 if((name!= null) && name.equals("partner")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("name")) 
						{
					
						 if((attrValue.contains("Syntec informatique"))||(attrValue.contains("Jessica France"))||(attrValue.contains("CELAD"))||
								 (attrValue.contains("NTN Transmission Europe"))||(attrValue.contains("SNCF"))||(attrValue.contains("OBEO"))||
								 (attrValue.contains("VITY Technology"))||(attrValue.contains("SILICOM Région Ouest"))||(attrValue.contains("AVISTO"))
								 ||(attrValue.contains("SPIDCOM Technologies"))||(attrValue.contains("ELSYS Design"))||(attrValue.contains("CINEACT"))
								 ||(attrValue.contains("Mitsubishi Electric ITE-TCL"))||(attrValue.contains("Haption"))||(attrValue.contains("Delta Technologies"))
								 ||(attrValue.contains("NXP Semiconductors"))||(attrValue.contains("ASTELLIA"))||(attrValue.contains("TeamCast"))
								 ||(attrValue.contains("EDIXIA"))||(attrValue.contains("RECMI industrie"))||(attrValue.contains("Microchip"))
								 ||(attrValue.contains("ESTAR"))||(attrValue.contains("ENENSYS Technologies"))||(attrValue.contains("CORONIS Systems"))
								 ||(attrValue.contains("RCOS-Pi"))||(attrValue.contains("ConstructiveCard Technologies"))||(attrValue.contains("Néosoft Services"))
								 ||(attrValue.contains("Alsim"))||(attrValue.contains("Institut Automobile du Mans"))||(attrValue.contains("Eurogiciel Ingenierie"))
								 ||(attrValue.contains("Matlog"))||(attrValue.contains("Xerox Research Centre Europe"))||(attrValue.contains("Sofrel lacroix"))
								 ||(attrValue.contains("Wind River"))||(attrValue.contains("Quartz Ingenierie"))||(attrValue.contains("CLIPS"))||
								 (attrValue.contains("Ecole polytechnique de Montréal")))
						   
						 
						 {
							 
						ident = attrValue;
							}
						}
					}
					
					if((ident != null)) {
						
						listFic.add(new String( ident ));

						stringBuilder.append(listFic + "\n");
					}
				
			 }
				
				//textView.setText(stringBuilder.toString());
			}
		
		}
		
		catch(Exception e) {
			//Log.e(APP_TAG, e.getMessage());
		}

		return listFic;
	}
}

