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
import android.graphics.Typeface;

import android.graphics.Bitmap.Config;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;

import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.ImageView.ScaleType;


public class SecondTab extends Activity {
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
				//Toast.makeText(SecondTab.this, "id=" + id, Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				if(id==0){
					Intent myIntent = new Intent(view.getContext(),	Tabschool.class);
					((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
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
		
				
				String id = null;
				String ident = null;
				
			
				
			 if((name!= null) && name.equals("card")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
					
						String attrValue = parser.getAttributeValue(i);
						String attrName1 = parser.getAttributeName(i);
						String attrValue1 = parser.getAttributeValue(i);
					 if ((attrName1 != null) && attrName1.equals("imageName")) {
						 
						 id=attrValue;
					 }
					 if ((attrName1 != null) && attrName1.equals("title")) 	
					 {
					
						if((attrValue1.equals("ENSIM")))
							
						   {	
						ident = attrValue1;
							}
						}
					}
					
					if((ident != null)&&(id != null)) {
						
						listFic.add(new String( id ));

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

	public  ArrayList<String> adil1(){
		XmlPullParser parser = getResources().getXml(R.xml.cdmapp);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic1 = new ArrayList<String>();
		try { 
			while ((parser.next() != XmlPullParser.END_DOCUMENT)){
				String name = parser.getName();
		
				
				String id = null;
				String ident = null;
				
			
				
			 if((name!= null) && name.equals("card")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
					
						String attrValue = parser.getAttributeValue(i);
						String attrName1 = parser.getAttributeName(i);
						String attrValue1 = parser.getAttributeValue(i);
					 if ((attrName1 != null) && attrName1.equals("imageName")) {
						 
						 id=attrValue;
					 }
					 if ((attrName1 != null) && attrName1.equals("title")) 	
					 {
					
						if((attrValue1.equals("ENSIM")))
							
						   {	
						ident = attrValue1;
							}
						}
					}
					
					if((ident != null)&&(id != null)) {
						
						listFic1.add(new String( ident ));

						stringBuilder.append(listFic1 + "\n");
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

		return listFic1;
	}

	
	public class ImageAdapter extends BaseAdapter {
	    int mGalleryItemBackground;
	    private Context mContext;
	    private ArrayList<String> mListImages;
	    private ArrayList<String> mListImages1;

	       
	

	    private ImageView[] mImages;
	    
	    public ImageAdapter(Context c) {
	    	mContext = c;
	    	mImages = new ImageView[3];
	    }
		public boolean createReflectedImages() {
		        //The gap we want between the reflection and the original image
		      //  final int reflectionGap = 4;
		        
		        
		        //The gap we want between the reflection and the original image 
			mListImages = adil();
			mListImages1 = adil1();
			mImages = new ImageView[mListImages.size()];
		        final int reflectionGap = 4; 

		        
		        int index = 0; 
		        for (String imageId : mListImages) { 
		        	Bitmap originalImage;
		        	try {
		        	originalImage = BitmapFactory.decodeStream(getResources().getAssets().open(imageId )); 
		        int width = originalImage.getWidth(); 
		        int height = originalImage.getHeight(); 
		        

		        //This will not scale but will flip on the Y axis 
		        Matrix matrix = new Matrix(); 
		        matrix.preScale(1, -1); 

		        //Create a Bitmap with the flip matrix applied to it. 
		        //We only want the bottom half of the image 
		        Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, height/200, width, height/200, matrix, false); 
		        
		        
		        //Create a new bitmap with same width but taller to fit reflection 
		        Bitmap bitmapWithReflection = Bitmap.createBitmap(width 
		        , (height + height/2), Config.ARGB_8888); 
		        
		        //Create a new Canvas with the bitmap that's big enough for 
		        //the image plus gap plus reflection 
		        Canvas canvas = new Canvas(bitmapWithReflection); 
		        //Draw in the original image 
		        canvas.drawBitmap(originalImage, 0, 0, null); 
		        //Draw in the gap 
		        Paint deafaultPaint = new Paint(); 
		        for (String imageId1 : mListImages1) { 
		        canvas.drawRect(0, height, width, height + reflectionGap, deafaultPaint); 
		        //Draw in the reflection 
		        canvas.drawBitmap(reflectionImage,0, height + reflectionGap, null); 

		        //Create a shader that is a linear gradient that covers the reflection 
		        
		        Paint paint = new Paint(); 
			       
			       
		        // Couleur, alignement et taille de ton texte :
		

		       
		        paint.setARGB(250, 255, 255, 255);
		        //paint.setAntiAlias(true);
		        paint.setTextAlign(Align.LEFT);
		        paint.setTextSize(30);
		        paint.setTypeface(Typeface.SERIF);
		        
		        canvas.drawText(imageId1, 60, 295, paint);
		       LinearGradient shader = new LinearGradient(0, originalImage.getHeight(), 0, 
		        bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff, 0x00ffffff, 
		        TileMode.CLAMP); 
		        //Set the paint to use this shader (linear gradient) 
		        paint.setShader(shader); 
		        //Set the Transfer mode to be porter duff and destination in 
		        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN)); 
		        //Draw a rectangle using the paint with our linear gradient 
		        canvas.drawRect(0, height, width, 
		        bitmapWithReflection.getHeight() + reflectionGap, paint); 
		        }
		        ImageView imageView = new ImageView(mContext); 
		        imageView.setImageBitmap(bitmapWithReflection); 
		        imageView.setLayoutParams(new CoverFlow.LayoutParams(120, 180)); 
		        imageView.setScaleType(ScaleType.MATRIX); 
		        mImages[index++] = imageView; 
		    		} catch (IOException e) {
						// TODO Auto-generated catch block
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
	        //i.setLayoutParams(new CoverFlow.LayoutParams(130, 130));
	        //i.setScaleType(ImageView.ScaleType.MATRIX);	        
	       // return i;
	    	
	    	return mImages[position];
	    }
		 /** Returns the size (0.0f to 1.0f) of the views 
	     * depending on the 'offset' to the center. */ 
	     

	}

}
