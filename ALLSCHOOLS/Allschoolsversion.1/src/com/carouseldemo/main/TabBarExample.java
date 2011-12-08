package com.carouseldemo.main;



import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class TabBarExample extends TabActivity  {
	
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
       // tabHost.setOnTabChangedListener(this);
        
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
        firstTabSpec.setIndicator("Ecole", getResources().getDrawable(R.drawable.ecole));
        secondTabSpec.setIndicator("Programmes", getResources().getDrawable(R.drawable.ensignement));
        TestSpec.setIndicator("Professionnels", getResources().getDrawable(R.drawable.pratique));
        CoverFlowExampleSpec.setIndicator("Pratique", getResources().getDrawable(R.drawable.professionnel));
        
        /* Add tabSpec to the TabHost to display. */
        tabHost.addTab(firstTabSpec);
        tabHost.addTab(secondTabSpec);
        tabHost.addTab(TestSpec);
        tabHost.addTab(CoverFlowExampleSpec);
        tabHost.setCurrentTab(0);
        
       
     
        
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
            case R.id.icon:LayoutInflater factory = LayoutInflater.from(this);
            final View alertDialogView = factory.inflate(R.layout.server, null);
            
            //Création de l'AlertDialog
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
     
            //On affecte la vue personnalisé que l'on a crée à notre AlertDialog
            adb.setView(alertDialogView);
     
            //On donne un titre à l'AlertDialog
            adb.setTitle("Moodle Server");
     
            //On modifie l'icône de l'AlertDialog pour le fun ;)
            adb.setIcon(R.drawable.server);
     
            //On affecte un bouton "OK" à notre AlertDialog et on lui affecte un évènement
            adb.setPositiveButton("Activer", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
     
                	//Lorsque l'on cliquera sur le bouton "OK", on récupère l'EditText correspondant à notre vue personnalisée (cad à alertDialogView)
                	//EditText et = (EditText)alertDialogView.findViewById(R.id.EditText1);
                	//EditText et = (EditText)alertDialogView.findViewById(R.id.EditText2);
                //	EditText et = (EditText)alertDialogView.findViewById(R.id.EditText3);
     
                	//On affiche dans un Toast le texte contenu dans l'EditText de notre AlertDialog
                	//Toast.makeText(Tutoriel18_Android.this, et.getText(), Toast.LENGTH_SHORT).show();
              } });
     
            //On crée un bouton "Annuler" à notre AlertDialog et on lui affecte un évènement
            adb.setNegativeButton("Desactiver", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	//Lorsque l'on cliquera sur annuler on quittera l'application
                	finish();
              } });
            adb.show();

                                break;
            case R.id.text:    // Toast.makeText(this, "Synchronisation", Toast.LENGTH_SHORT).show();
            	 AlertDialog.Builder alt_bld1 = new AlertDialog.Builder(this);
             	alt_bld1.setMessage("Do you want to synchronize?")
             	.setCancelable(false)
             	.setPositiveButton("Activer", new DialogInterface.OnClickListener() {
             	public void onClick(DialogInterface dialog, int id) {
             	// Action for 'Yes' Button
             	}
             	})
             	.setNegativeButton("Desactiver", new DialogInterface.OnClickListener() {
             	public void onClick(DialogInterface dialog, int id) {
             	//  Action for 'NO' Button
             	dialog.cancel();
             	}
             	});
             	AlertDialog alert1 = alt_bld1.create();
             	// Title for AlertDialog
             	alert1.setTitle("synchronisation");
             	// Icon for AlertDialog
             	alert1.setIcon(R.drawable.synchro);
             	alert1.show();
                                break;
            case R.id.icontext:  // Toast.makeText(this, "Synchronisation", Toast.LENGTH_SHORT).show();
           	 AlertDialog.Builder alt_bld2 = new AlertDialog.Builder(this);
          	alt_bld2.setMessage("")
          	.setCancelable(false)
          	.setPositiveButton("Montion légales", new DialogInterface.OnClickListener() {
          	public void onClick(DialogInterface dialog, int id) {
          	// Action for 'Yes' Button
          	}
          	})
          	.setNegativeButton("Version ", new DialogInterface.OnClickListener() {
          	public void onClick(DialogInterface dialog, int id) {
          	
          		
          	}
          	});
          	AlertDialog alert2 = alt_bld2.create();
          	// Title for AlertDialog
          	alert2.setTitle("informations");
          	// Icon for AlertDialog
          	alert2.setIcon(R.drawable.inf);
          	alert2.show();
                                break;
            case R.id.icontext1:LayoutInflater factory1 = LayoutInflater.from(this);
            final View alertDialogView1 = factory1.inflate(R.layout.main0, null);
            final CharSequence[] digitList= { "ENSIM", "Université Du Maine", "Résidence Universitaire" };
            
            //Création de l'AlertDialog
            AlertDialog.Builder adb4 = new AlertDialog.Builder(this);
     
            //On affecte la vue personnalisé que l'on a crée à notre AlertDialog
            adb4.setView(alertDialogView1);
     
            //On donne un titre à l'AlertDialog
            adb4.setTitle("Flux RSS");
     
            //On modifie l'icône de l'AlertDialog pour le fun ;)
            adb4.setIcon(R.drawable.rss);
            adb4.setMultiChoiceItems(digitList, new boolean[] { false, true,
            		false },
            		new DialogInterface.OnMultiChoiceClickListener() {
            			public void onClick(DialogInterface dialog,
            			int whichButton, boolean isChecked) {

            			}
            			});
            adb4.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            			@Override
            			public void onClick(DialogInterface dialog, int which) {

            			ListView list = ((AlertDialog)dialog).getListView();

            			StringBuilder sb = new StringBuilder();
            			for (int i=0; i<list.getCount(); i++) {
            			boolean checked = list.isItemChecked(i);

            			if (checked) {
            			if (sb.length()>0) sb.append(", ");
            			sb.append(list.getItemAtPosition(i));
            			}
            			}

            			Toast.makeText(getApplicationContext(),
            			"Vous Avez Sélecionner: " + sb.toString(),
            			Toast.LENGTH_SHORT).show();

            			}
            			});
            adb4.setNegativeButton("Cancel",
            			new DialogInterface.OnClickListener() {
            			@Override
            			public void onClick(DialogInterface dialog, int which) {

            			}
            			});

            			AlertDialog alert = adb4.create();
            			alert.show();
           // adb4.show();

                                break;
        }
        return true;
    }
	
   
    
	
	
	
    
    
}
