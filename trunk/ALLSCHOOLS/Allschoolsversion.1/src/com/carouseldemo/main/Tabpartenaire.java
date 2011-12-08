package com.carouseldemo.main;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class Tabpartenaire extends TabActivity  {
	
	TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ass);
        Button next = (Button) findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TabBarExample.class);
                startActivityForResult(myIntent, 0);
            }

        });
   
        Button next1 = (Button) findViewById(R.id.bouton4);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RSSReaderTuto.class);
                startActivityForResult(myIntent, 0);
            }
        });
        /* TabHost will have Tabs */
        tabHost = (TabHost)findViewById(android.R.id.tabhost);
        
        
        /* TabSpec used to create a new tab. 
         * By using TabSpec only we can able to setContent to the tab.
         * By using TabSpec setIndicator() we can set name to tab. */
        
        /* tid1 is firstTabSpec Id. Its used to access outside. */
        
        TabSpec secondTabSpec = tabHost.newTabSpec("tid1");
        TabSpec firstTabSpec = tabHost.newTabSpec("tid3");
        TabSpec TestSpec = tabHost.newTabSpec("tid2");
        TabSpec CoverFlowExampleSpec = tabHost.newTabSpec("tid3");
        /* TabSpec setIndicator() is used to set name for the tab. */
        /* TabSpec setContent() is used to set content for a particular tab. */
        firstTabSpec.setContent(new Intent(this,FirstTab.class));
        secondTabSpec.setContent(new Intent(this,SecondTab.class));
        TestSpec.setContent(new Intent(this,Partenaire.class));
        CoverFlowExampleSpec.setContent(new Intent(this,MainActivity.class));
        firstTabSpec.setIndicator("     Ecole             ", getResources().getDrawable(R.drawable.ecole));
        secondTabSpec.setIndicator("    Programmes        ", getResources().getDrawable(R.drawable.ensignement));
        TestSpec.setIndicator("       Professionnels     ", getResources().getDrawable(R.drawable.pratique));
        CoverFlowExampleSpec.setIndicator("     Pratique         ", getResources().getDrawable(R.drawable.professionnel));
        
        /* Add tabSpec to the TabHost to display. */
        tabHost.addTab(firstTabSpec);
        tabHost.addTab(secondTabSpec);
        tabHost.addTab(TestSpec);
        tabHost.addTab(CoverFlowExampleSpec);
       tabHost.setCurrentTab(2);
        
       
        
    }

    
    
    
    
	
	
	
	
	
	
	
    
    
}
