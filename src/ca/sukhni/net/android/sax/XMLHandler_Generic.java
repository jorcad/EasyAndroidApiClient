package ca.sukhni.net.android.sax;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler_Generic extends DefaultHandler
{
	private StringBuffer buff = null;
	private LinkedHashMap<String, Object> item = null;
	private boolean buffering = false;
	private LinkedHashMap<String, String> attrs = new LinkedHashMap<String, String>();

	@Override
	public void startDocument() throws SAXException
	{

	}


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException
	{

	}

	@Override
	public void endDocument() throws SAXException
	{

	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException
	{
		if (buffering)
        {
            buff.append(ch, start, length);
        }
	}
	
}
