
package com.carouseldemo.main;

import java.net.URL;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
AADJOU ADIL
 * <ul><li>Manage the RSS feed</li></ul>
 */
public class RSSFeed {
	
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/
	
	//the Title of the news
	private String _title = null;
	
	//the publication date of the news
    private String _pubdate = null;
    
    //The number of news
    private int _itemcount = 0;
    
    //the list of news
    private final List<Data> _itemlist;
    
    RSSFeed()
    {
        _itemlist = new Vector(0); 
    }
    
    //to add an item (news) to the list
    int addItem(Data item)
    {
        _itemlist.add(item);
        _itemcount++;
        return _itemcount;
    }
    
    
    /******************************************************************************************/
	/** Getters & Setters **************************************************************************/
	/******************************************************************************************/
   
    //get the item
    Data getItem(int location)
    {
        return _itemlist.get(location);
    }
    
    //Get all items
    List getAllItems()
    {
        return _itemlist;
    }
    
    //get the number of item
    int getItemCount()
    {
        return _itemcount;
    }
    
    //set a title
    void setTitle(String title)
    {
        _title = title;
    }
    
    //set a publication date
    void setPubDate(String pubdate)
    {
        _pubdate = pubdate;
    }
    
    //get the title
    String getTitle()
    {
        return _title;
    }
    
    //get the publication date
    String getPubDate()
    {
        return _pubdate;
    }
}
