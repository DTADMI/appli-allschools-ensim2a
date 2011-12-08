package com.carouseldemo.main;



import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;

import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;

import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.ImageView.ScaleType;


public class Map extends Activity {
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	   
	    CoverFlow coverFlow;
	    coverFlow = new CoverFlow(this);
	    
	    coverFlow.setAdapter(new ImageAdapter(this));

	    ImageAdapter coverImageAdapter =  new ImageAdapter(this);
	    
	    coverImageAdapter.createReflectedImages();
	    
	    coverFlow.setAdapter(coverImageAdapter);

	    setContentView(coverFlow);
	    coverFlow.setOnItemClickListener(new CoverAdapterView.OnItemClickListener(){

			public void onItemClick(CoverAdapterView<?> parent, View view,
					int position, long id) {
				
				if(id==0){
					Intent myIntent = new Intent(view.getContext(),	Tabmap.class);
					
	                startActivityForResult(myIntent, 0);
					
				}
				
			}
        	
        });
	    
	    //Use this if you want to use XML layout file
	    //setContentView(R.layout.main);
	    //coverFlow =  (CoverFlow) findViewById(R.id.coverflow);
	        
	
	}
	public  ArrayList<String> adil(){
		XmlPullParser parser = getResources().getXml(R.xml.cdmapp);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic = new ArrayList<String>();
		try { 
			while ((parser.next() != XmlPullParser.END_DOCUMENT)){
				String name = parser.getName();
			
				String ident = null;
				
			
				
			 if((name!= null) && name.equals("localisation")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
					
						String attrName1 = parser.getAttributeName(i);
						String attrValue1 = parser.getAttributeValue(i);
					
					 if ((attrName1 != null) && attrName1.equals("url")) 	
					 {
					
							
						ident = attrValue1;
						
						}
					}
					
					if((ident != null)) {
						
						listFic.add(new String( ident ));

						stringBuilder.append(listFic + "\n");
						//Toast toast = Toast.makeText(getApplicationContext(),
							//	  ident, Toast.LENGTH_LONG);
								//toast.setGravity(Gravity.CENTER, 0, 0);
								//toast.show(); 
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

	
	public class ImageAdapter extends BaseAdapter {
	    int mGalleryItemBackground;
	    private Context mContext;
	    private ArrayList<String> mListImages;
 private Integer[] mImageIds = {
	    		
	    };
	       
	

	    private ImageView[] mImages;
	    
	    public ImageAdapter(Context c) {
	    	mContext = c;
	    	mImages = new ImageView[0];
	    }
		public boolean createReflectedImages() {
		        //The gap we want between the reflection and the original image
		      //  final int reflectionGap = 4;
		        
		        
		        //The gap we want between the reflection and the original image 
			mListImages = adil();		
			mImages = new ImageView[mListImages.size()];
		      
		        for (String imageId : mListImages) { 
		        	Bitmap originalImage;
		        	try {
		        	originalImage = BitmapFactory.decodeStream(getResources().getAssets().open(imageId )); 
		     
		       ; 
		        
		        
		     

		        ImageView imageView = new ImageView(mContext); 
		        imageView.setImageBitmap(originalImage);
		      
		   ;
		   imageView.setLayoutParams(new CoverFlow.LayoutParams(130, 130));
		        mImages[0] = imageView; 
		    		} catch (IOException e) {
					
						e.printStackTrace();
					}
				
			}
		    	return true;
		}

	    public int getCount() {
	        return  mImages.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    public View getView(int position, View convertView, ViewGroup parent) {

	    	//Use this code if you want to load from resources
	        //ImageView i = new ImageView(mContext);
	        //i.setImageResource(mImageIds[position]);
	    	
	        //i.setScaleType(ImageView.ScaleType.MATRIX);	        
	       // return i;
	    	
	    	return mImages[position];
	    }
		 /** Returns the size (0.0f to 1.0f) of the views 
	     * depending on the 'offset' to the center. */ 
	     

	}

}
