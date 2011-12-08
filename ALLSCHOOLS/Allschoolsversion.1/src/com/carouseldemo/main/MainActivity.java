package com.carouseldemo.main;


import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

import com.carouseldemo.controls.Carousel;
import com.carouseldemo.controls.CarouselAdapter;
import com.carouseldemo.controls.CarouselImageView;
import com.carouseldemo.controls.CarouselAdapter.OnItemClickListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
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

/**

 */
public class MainActivity extends Activity {


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  Carousel coverFlow;
		    coverFlow = new Carousel(this);
		    
		    
		    coverFlow.setAdapter(new ImageAdapter(this));

		    ImageAdapter ImageAdapter =  new ImageAdapter(this);
		    
		    ImageAdapter.SetImages();
		    
		    coverFlow.setAdapter(ImageAdapter);
		  

		    // next time we go through layout with this value
	       // setNextSelectedPositionInt(selectedItem);

		    setContentView(coverFlow);
		  
		    coverFlow.setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(CarouselAdapter<?> parent, View view,
						int position, long id) {
					//Toast.makeText(MainActivity.this, "id=" + id, Toast.LENGTH_SHORT).show();
					// TODO Auto-generated method stub
					
					if(id==0){
						Intent myIntent = new Intent(view.getContext(),Tabmap.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==1){
						Intent myIntent = new Intent(view.getContext(),Tabcont.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					
					if(id==2){
						Intent myIntent = new Intent(view.getContext(),Tabgui.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==3){
						Intent myIntent = new Intent(view.getContext(),Tabtra.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==4){
						Intent myIntent = new Intent(view.getContext(),Tabhou.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==5){
						Intent myIntent = new Intent(view.getContext(),Tabrest.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					
				}
	        	
	        });

		    
		    //Use this if you want to use XML layout file
		 //   setContentView(R.layout.main);
		    //coverFlow =  (CoverFlow) findViewById(R.id.coverflow);
		        
		
		}
	
	public  ArrayList<String> adil1(){
		XmlPullParser parser = getResources().getXml(R.xml.cdmapp);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic = new ArrayList<String>();
		try { 
			while ((parser.next() != XmlPullParser.END_DOCUMENT)){
				String name = parser.getName();
				
				String ident = null;
		
			
				
			 if((name!= null) && name.equals("map")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("id")) 
						{
						 if(((attrValue.equals("Map"))))
							
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
			
			 if((name!= null) && name.equals("contacts")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("id")) 
						{
						 if(((attrValue.equals("Contacts"))))
							
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
			 if((name!= null) && name.equals("guide")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("id")) 
						{
						 if(((attrValue.equals("Guide"))))
							
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
			 
			 if((name!= null) && name.equals("transport")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("id")) 
						{
						 if(((attrValue.equals("Transport"))))
							
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
			 if((name!= null) && name.equals("housing")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("id")) 
						{
						 if(((attrValue.equals("Housing"))))
							
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
			 if((name!= null) && name.equals("restoration")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("id")) 
						{
						 if(((attrValue.equals("Restoration"))))
							
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
	
	
	public  ArrayList<String> adil(){
		XmlPullParser parser = getResources().getXml(R.xml.cdmapp);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic = new ArrayList<String>();
		try { 
			while ((parser.next() != XmlPullParser.END_DOCUMENT)){
				String name = parser.getName();
			
				String ident = null;
		
			
				
			 if((name!= null) && name.equals("card")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
					 if ((attrName != null) && attrName.equals("imageName")) 
						{
					
						 if(((attrValue.equals("IconeLocauxB.png")))||((attrValue.equals("IconeBoussoleO.png")))
									||(attrValue.equals("IconeInfoV.png"))||
							(attrValue.equals("IconeContactB.png"))||(attrValue.equals("IconeInfoR.png"))||
							(attrValue.equals("IconeInfoO.png")))
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

	public class ImageAdapter extends BaseAdapter {
		private ArrayList<String> mListImages;
		private ArrayList<String> mListImages1;
		private Context mContext;
	
	    
		private CarouselImageView[] mImages1;		
		
		public ImageAdapter(Context c) {
			mContext = c;
			
			
			mImages1 = new CarouselImageView[6];
		}	
		
	
						
	
		public boolean SetImages(){
			
		
			 mListImages = adil();	
			 mListImages1 = adil1();	
			mImages1 = new CarouselImageView[mListImages.size()];
			int position = 0;
			 final int reflectionGap = 0; 

			for (String imageId : mListImages)
			{
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
				        canvas.drawRect(0, height, width, height + reflectionGap, deafaultPaint); 
				        //Draw in the reflection 
				        canvas.drawBitmap(reflectionImage,0, height + reflectionGap, null); 

				        //Create a shader that is a linear gradient that covers the reflection 
				        Paint paint = new Paint(); 
				        paint.setARGB(250, 255, 255, 255);
				        //paint.setAntiAlias(true);
		                paint.setTextAlign(Align.LEFT);
				        paint.setTextSize(30);
				        paint.setTypeface(Typeface.SERIF);
				        paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));  
				        paint.setColor(Color.WHITE);
				        paint.setLinearText(true);
				        if(position==0){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
					        	 int i=0;
							      i++;
					        	
							        canvas.drawText(imageId1, 30, 295, paint);
							      
							        
							       break;
					        	  
					        }
					        }
				        if(position==1){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Contacts", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==2){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Guide", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==3){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Transport", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==4){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Housing", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==5){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Restoration", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				       
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
					    CarouselImageView imageView = new CarouselImageView(mContext);
					    imageView.setImageBitmap(bitmapWithReflection);
					    imageView.setIndex(position);
		
					    mImages1[position++] = imageView;
					
					
				
				
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			return true;
		}
		public int getCount() {
			if(mImages1 == null)
				return 0;
			else
				return mImages1.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			return mImages1[position];
		}

	}	

		
	}

