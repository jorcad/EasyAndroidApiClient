package ca.sukhni.net.android.sax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHelper
{
	/**
	 * Internal method to help reduce code duplication. Simply sets up and
	 * parses xml content. The handler is expected to provide access to the
	 * parsed data.
	 * 
	 * @param xml
	 * @param handler
	 * @throws Exception
	 */
	public static void parseXml(String xml, DefaultHandler handler) throws Exception
	{
		parseXml(xml, handler,"UTF-8");
	}
	
	/**
	 * Internal method to help reduce code duplication. Simply sets up and
	 * parses xml content. The handler is expected to provide access to the
	 * parsed data.
	 * @param xml
	 * @param handler
	 * @param charSetType
	 * @throws Exception
	 */
	public static void parseXml(String xml, DefaultHandler handler,String charSetType) throws Exception
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		XMLReader xr = sp.getXMLReader();
		xr.setContentHandler(handler);
		InputStream xmlStream = new ByteArrayInputStream(xml.getBytes(charSetType));
		xr.parse(new InputSource(xmlStream));
	}

}
