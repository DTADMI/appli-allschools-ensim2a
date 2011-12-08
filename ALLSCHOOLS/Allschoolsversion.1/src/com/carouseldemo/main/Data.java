
package com.carouseldemo.main;

/**
 AADJOU ADIL
 * <ul><li>transform the feed into model object</li></ul>
 */
public class Data {
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/
	
	//the title of the news
	private String _title = null;
	//the description of the news
    private String _description = null;
    //the link of the news
    private String _link = null;
    //the categry of the news
    private String _category = null;
    //The plublication Date of the news
    private String _pubdate = null;
  
    Data()
    {
    }
    
    //set the title
    void setTitle(String title)
    {
        _title = title;
    }
    
    //set the description
    void setDescription(String description)
    {
        _description = description;
    }
    
    //set the link
    void setLink(String link)
    {
        _link = link;
    }
    
    //set the category
    void setCategory(String category)
    {
        _category = category;
    }
    
    //set the publication date
    void setPubDate(String pubdate)
    {
        _pubdate = pubdate;
    }
    
    //get the article title
    String getTitle()
    {
        return _title;
    }
    
    //get the article description
    String getDescription()
    {
        return _description;
    }
    
    //get the article link
    String getLink()
    {
        return _link;
    }
    
    //get the article category
    String getCategory()
    {
        return _category;
    }
    
    //get the publication date
    String getPubDate()
    {
        return _pubdate;
    }
    
    //if the string is over 25 caractère make "..."
    @Override
	public String toString()
    {
        // limit how much text you display
        if (_title.length() > 25)
        {
            return _title.substring(0, 25) + "...";
        }
        return _title;
    }
}
