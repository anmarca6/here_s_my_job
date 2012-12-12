/**
 * @author: Angel Martinez-Cavero (anmarca6@gmail.com)
 * Date: 09/12/2012
 * Project name: HereIsMyJob
 * License:
 * 
 */

package com.infojobs.hereismyjob.httpmanager;


import java.io.IOException;

import java.net.MalformedURLException;


import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.infojobs.hereismyjob.main.Constants;


public class HttpManager {
	
	private DefaultHttpClient client = null;
	private HttpHost targetHost = null;
	private HttpGet request = null;
	private HttpResponse response = null;

	public HttpManager(String str) {
		try {
			client = new DefaultHttpClient();   
			targetHost = new HttpHost(Constants.HOST_NAME,Constants.PORT_NUMBER,Constants.HOST_SCHEME);  	  
			// Client credentials
			client.getCredentialsProvider().setCredentials(  
					new AuthScope(targetHost.getHostName(),targetHost.getPort()),        
					new UsernamePasswordCredentials("Aladdin", "open sesame")  
					);	          
			// create a GET method that queries some API operation  
			request = new HttpGet(str);  
			// execute the operation  
			response = client.execute(targetHost,request);  


			// print the status and the contents of the response  
			System.out.println(response.getStatusLine());  
			System.out.println(EntityUtils.toString(response.getEntity()));  

		} catch (MalformedURLException ex) {
			Constants.showException("Malformed URL exception: "+ex);
		} catch (IOException ex) {
			Constants.showException("Input/Output exception: "+ex);
		} finally {  
			// release any connection resources used by the method  
			client.getConnectionManager().shutdown();  
		}
	}
	
	
//	public boolean isNetworkAvailable() {
//	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//	    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
//	    // if no network is available networkInfo will be null
//	    // otherwise check if we are connected
//	    if (networkInfo != null && networkInfo.isConnected()) {
//	        return true;
//	    }
//	    return false;
//	}
}	
