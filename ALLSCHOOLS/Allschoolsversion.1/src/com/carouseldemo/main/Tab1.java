
package com.carouseldemo.main;



import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class Tab1 extends TabActivity  {
	
	TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ass);
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
        TabSpec firstTabSpec = tabHost.newTabSpec("tid1");
        TabSpec TestSpec = tabHost.newTabSpec("tid1");
        TabSpec CoverFlowExampleSpec = tabHost.newTabSpec("tid1");
        /* TabSpec setIndicator() is used to set name for the tab. */
        /* TabSpec setContent() is used to set content for a particular tab. */
        firstTabSpec.setContent(new Intent(this,FirstTab.class));
        secondTabSpec.setContent(new Intent(this,SecondTab.class));
        TestSpec.setContent(new Intent(this,TestQuickAction.class));
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
        tabHost.setCurrentTab(1);

	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon:     Toast.makeText(this, "You pressed the icon!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.text:     Toast.makeText(this, "You pressed the text!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.icontext: Toast.makeText(this, "You pressed the icon and text!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.icontext1: Toast.makeText(this, "You pressed the icon and text!", Toast.LENGTH_LONG).show();
            break;
        }
        return true;
    }
	
    
    
}
