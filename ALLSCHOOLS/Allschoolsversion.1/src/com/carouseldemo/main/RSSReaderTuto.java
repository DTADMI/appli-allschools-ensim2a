
package com.carouseldemo.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * AADJOU ADIL
 *
 */
public class RSSReaderTuto extends Activity implements OnItemClickListener{
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/

	//the URL of the RSS feed
	public final String RSSURL = "http://www.univ-lemans.fr/fr/rss.xml";
	
	//THe RSS feed
	private RSSFeed feed = null;
	
	//the list of the news
	private List<Data> myItems;

	//the hashmpa that links Title and content of Rss post
	ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
	
	/** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mainn);
        
        // get the feed
        feed = getFeed(RSSURL);

        // display all the RSS
        displayRSS();
        Button next1 = (Button) findViewById(R.id.button1);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TabBarExample.class);
                startActivityForResult(myIntent, 0);
            }
        });
        
    }

    //Parse and Get the RSS Feed
    private RSSFeed getFeed(String urlToRssFeed)
    {
    	try
    	{
    	   // setup the url
    	   URL url = new URL(urlToRssFeed);

           // create the parser factory
           SAXParserFactory factory = SAXParserFactory.newInstance();
           // create a parser. The parser will parse the XML file of the RSS feed
           SAXParser parser = factory.newSAXParser();

           // create the reader (scanner)
           XMLReader xmlreader = parser.getXMLReader();
           // instantiate our handler
           RSSParser theRssHandler = new RSSParser();
           // assign our handler
           xmlreader.setContentHandler(theRssHandler);
           // get our data via the url class
           InputSource is = new InputSource(url.openStream());
           // perform the synchronous parse           
           xmlreader.parse(is);
           // get the results - should be a fully populated RSSFeed instance, or null on error
           //les handlers ca marche pas comme ca bordel!
           return theRssHandler.getFeed();
    	}
    	catch (Exception ee)
    	{
    		return null;
    	}
    }
    
    
    //display the RSS
    private void displayRSS()
    {
    	
        ListView itemlist = (ListView) findViewById(R.id.itemlist);

        HashMap<String, String> map;

        //Get all items into an aray
        myItems = feed.getAllItems();
        
        //For each item in array, put it in the hashmap ...
        for(Data rss : myItems){
        	map = new HashMap<String, String>();
        	map.put("titre", rss.getTitle());
        	map.put("description", rss.getDescription());
        	//and add the hashmap to the list
        	listItem.add(map);
        }
        
        //create the adapter, which take a context, the list and a layout at parameters 
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.item,
                new String[] {"titre", "description"}, new int[] {R.id.titre, R.id.description});

        //set an adapter to the listeview
        itemlist.setAdapter(mSchedule);
        
        //set an itemclickListener to the listView
        itemlist.setOnItemClickListener(this);
        
        itemlist.setSelection(0);
        
    }
    
  
    
    //When user clic on an Item
     @Override
	public void onItemClick(AdapterView parent, View v, int position, long id)
     {
    	
    	 //Instanciation of an intent
    	 Intent myIntent = new Intent().setClass(this,ShowRSS.class);
         
    	 //my a bundle with the feed information
    	 Bundle b = new Bundle();
    	 b.putString("title", feed.getItem(position).getTitle());
    	 b.putString("description", feed.getItem(position).getDescription());
    	 b.putString("link", feed.getItem(position).getLink());
    	 b.putString("pubdate", feed.getItem(position).getPubDate());
    	 
    	 //put the bundle into the intent
    	 myIntent.putExtra("android.intent.extra.INTENT", b);
    	
    	 //start the activity
    	 startActivity(myIntent);
    	 
     }
     
}
