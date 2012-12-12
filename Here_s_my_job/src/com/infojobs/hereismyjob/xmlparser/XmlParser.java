/**
 * @author: Angel Martinez-Cavero (anmarca6@gmail.com)
 * Date: 09/12/2012
 * Project name: HereIsMyJob
 * License:
 * 
 */

package com.infojobs.hereismyjob.xmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.infojobs.hereismyjob.main.Constants;

public class XmlParser {
	
	private XmlPullParserFactory factory = null;
	private XmlPullParser xpp = null;
	private URL inputURL = null;
	
	public XmlParser(String str) throws XmlPullParserException,IOException {
		// URL parser
		try {
			inputURL = new URL(str);
        } catch (MalformedURLException ex) {
            Constants.showException("Malformed URL exception: "+ex);
        }		
		// We need to create an instance of the XML parser
		factory = XmlPullParserFactory.newInstance();
	    factory.setNamespaceAware(true);
	    xpp = factory.newPullParser();	
	    initXmlParser();
	}
	
	public void initXmlParser() throws XmlPullParserException,IOException {
		// Parser input URL
		xpp.setInput(getInputStream(),null);
		// We can start the parser process
		int eventType = xpp.getEventType();
		while(eventType != XmlPullParser.END_DOCUMENT) {
			if(eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start document");
			} else if(eventType == XmlPullParser.START_TAG) {
				System.out.println("Start tag "+xpp.getName());
			} else if(eventType == XmlPullParser.END_TAG) {
				System.out.println("End tag "+xpp.getName());
			} else if(eventType == XmlPullParser.TEXT) {
				System.out.println("Text "+xpp.getText());
			}
			eventType = xpp.next();
		}
		System.out.println("End document");	
	}
	
	/** Get the input stream to be processed as xml parser input */
	public InputStream getInputStream() {
		InputStream output = null;
		try	{
			if(inputURL != null)
				output = inputURL.openConnection().getInputStream();
		} catch (IOException ex) {
			Constants.showException("Input/Output exception: "+ex);
		}
		return output;
	}
}