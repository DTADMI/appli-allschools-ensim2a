package com.carouseldemo.main;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;








import android.app.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import android.widget.CheckedTextView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This example shows how to read xml file from res/xml folder
 *
 * @author Aadjou adil
 *
 */

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
import android.graphics.PorterDuff;
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

import android.widget.Toast;

/**

 */
public class Annee2 extends Activity {


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
					if(id==0){
						Intent myIntent = new Intent(view.getContext(),Tabtce21.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
					
						 // CheckedTextView check = (CheckedTextView)view;
						    //check.setChecked(!check.isChecked());
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==1){
						Intent myIntent = new Intent(view.getContext(),Tabtce2o.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==2){
						Intent myIntent = new Intent(view.getContext(),Tabtce22.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==3){
						Intent myIntent = new Intent(view.getContext(),Tabtcc21.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
						
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==4){
						Intent myIntent = new Intent(view.getContext(),Tabtcc22.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==5){
						Intent myIntent = new Intent(view.getContext(),Tabtcc23.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					if(id==6){
						Intent myIntent = new Intent(view.getContext(),Tabtcc24.class);
						((ImageView) view).setColorFilter(0x77000000, Mode.SRC_ATOP);
		                startActivityForResult(myIntent, 0);
						
					}
					
				}
	        	
	        });

		    
		    //Use this if you want to use XML layout file
		 //   setContentView(R.layout.main);
		    //coverFlow =  (CoverFlow) findViewById(R.id.coverflow);
		        
		
		}
	public  ArrayList<String> adil(){
		XmlPullParser parser = getResources().getXml(R.xml.cdmapp);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic = new ArrayList<String>();
		try { 
			while ((parser.next() != XmlPullParser.END_DOCUMENT)){
				String name = parser.getName();
				String name1 = parser.getName();
				
				String id = null;
				String ident = null;
				
			
				
			 if((name!= null) && name.equals("card")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
						String attrName1 = parser.getAttributeName(i);
						String attrValue1 = parser.getAttributeValue(i);
					 if ((attrName1 != null) && attrName1.equals("imageName")) {
						 
						 id=attrValue;
					 }
					 if ((attrName1 != null) && attrName1.equals("title")) 	
					 {
					
						 if((attrValue1.equals("Anglais1"))||(attrValue1.equals("Seconde_langue1"))||
									(attrValue1.equals("Management par_les_couts"))||(attrValue1.equals("Gestion_de_projets et_parrainage"))||(attrValue1.equals("Plans_d'expériences"))||(attrValue1.equals("Gestion_des_variations et_aléas"))
									||(attrValue1.equals("Projet")))
								
							   {
	
						ident = attrValue1;
							}
						}
					}
					
					if((ident != null)&&(id != null)) {
						
						listFic.add(new String( id ));

						//stringBuilder.append(ident+ "\n");
						//stringBuilder.append(id+ "\n");
					//	Toast toast = Toast.makeText(getApplicationContext(),
						//		  ident, Toast.LENGTH_LONG);
							//	toast.setGravity(Gravity.CENTER, 0, 0);
								//toast.show(); 
					}
				
			 }
				
				//textView.setText(stringBuilder.toString());
			}
		
		
				}catch(Exception e) {
					//Log.e(APP_TAG, e.getMessage());
				}
			

		return listFic;
	}
	
	public  ArrayList<String> adil1(){
		XmlPullParser parser = getResources().getXml(R.xml.cdmapp);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> listFic = new ArrayList<String>();
		try { 
			while ((parser.next() != XmlPullParser.END_DOCUMENT)){
				String name = parser.getName();
				String name1 = parser.getName();
				
				String id = null;
				String ident = null;
				
			
				
			 if((name!= null) && name.equals("card")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);
						String attrName1 = parser.getAttributeName(i);
						String attrValue1 = parser.getAttributeValue(i);
					 if ((attrName1 != null) && attrName1.equals("imageName")) {
						 
						 id=attrValue;
					 }
					 if ((attrName1 != null) && attrName1.equals("title")) 	
					 {
					
						 if((attrValue1.equals("Anglais1"))||(attrValue1.equals("Seconde_langue1"))||
									(attrValue1.equals("Management par_les_couts"))||(attrValue1.equals("Gestion_de_projets et_parrainage"))||(attrValue1.equals("Plans_d'expériences"))||(attrValue1.equals("Gestion_des_variations et_aléas"))
									||(attrValue1.equals("Projet")))
								
							   {
	
						ident = attrValue1;
							}
						}
					}
					
					if((ident != null)&&(id != null)) {
						
						listFic.add(new String( ident ));

					//	stringBuilder.append(ident+ "\n");
						//stringBuilder.append(id+ "\n");
					//	Toast toast = Toast.makeText(getApplicationContext(),
						//		  ident, Toast.LENGTH_LONG);
							//	toast.setGravity(Gravity.CENTER, 0, 0);
								//toast.show(); 
					}
				
			 }
				
				//textView.setText(stringBuilder.toString());
			}
		
		
				}catch(Exception e) {
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
			
			
			mImages1 = new CarouselImageView[5];
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
				        paint.setTextSize(22);
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
					      
							       canvas.drawText("Seconde_langue1", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==2){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Management par_les_couts", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==3){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Gestion_de_projets et_parrainage", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==4){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Plans_d'expériences", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==5){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Gestion_des_variations et_aléas", 30, 295, paint);
							      
							        
							       break;
							      
					                
					        }
					        }
				        if(position==6){
					        for (String imageId1 : mListImages1) { 
					        //Create a shader that is a linear gradient that covers the reflection 
					      //  Paint paint = new Paint();  
					        // Couleur, alignement et taille de ton texte :
					      
							       canvas.drawText("Projet", 30, 295, paint);
							      
							        
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
