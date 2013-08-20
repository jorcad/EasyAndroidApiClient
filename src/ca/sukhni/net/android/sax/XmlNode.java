package ca.sukhni.net.android.sax;

import java.util.LinkedHashMap;

public class XmlNode
{
	private LinkedHashMap<String, String> 				attributesMap 				= new LinkedHashMap<String, String>();
	private String 										content						= new String();
	private LinkedHashMap<String, XmlNode> 				childsMap					= new LinkedHashMap<String, XmlNode>();
	
	/**
	 * @return the attributesMap
	 */
	public LinkedHashMap<String, String> getAttributesMap()
	{
		return attributesMap;
	}
	/**
	 * @return the content
	 */
	public String getContent()
	{
		return content;
	}
	/**
	 * @return the childsMap
	 */
	public LinkedHashMap<String, XmlNode> getChildsMap()
	{
		return childsMap;
	}
	
	
	
}
