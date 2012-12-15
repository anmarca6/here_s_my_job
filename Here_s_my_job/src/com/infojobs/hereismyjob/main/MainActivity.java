/**
 * @author: Angel Martinez-Cavero (anmarca6@gmail.com) & Miguel-Angel Llorente-Carmona (mallorente@gmail.com)
 * Date: 09/12/2012
 * Project name: HereIsMyJob
 * License:
 * 
 */

package com.infojobs.hereismyjob.main;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;

public class MainActivity extends Activity {

//	private HttpManager httpManager = null;
	 private DefaultHttpClient client = null;
		private HttpHost targetHost = null;
		private HttpGet request = null;
		private HttpResponse response = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState); 
        StrictMode.ThreadPolicy policy = new StrictMode.
        		ThreadPolicy.Builder().permitAll().build();
        		StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.layout_main_activity);        
        //httpManager = new HttpManager("https://api.infojobs.net/api/1/offer");
        //HttpManager("https://api.infojobs.net/api/1/offer?contractType=indefinido&province=valencia&category=java");        
        HttpManager("https://api.infojobs.net/api/1/offer");
    }    
    
   

	public void HttpManager(String str) {		
		try {
			client = new DefaultHttpClient();			
			targetHost = new HttpHost(Constants.HOST_NAME,Constants.PORT_NUMBER,Constants.HOST_SCHEME);			
			// Client credentials
			client.getCredentialsProvider().setCredentials(  
					new AuthScope(targetHost.getHostName(),targetHost.getPort()),        
					new UsernamePasswordCredentials(Constants.CLIENT_ID_AUTHENTICATION,Constants.CLIENT_SECRET_AUTHENTICATION)  
					);	          
			
			// create a GET method that queries some API operation  
			request = new HttpGet(str);  
			
System.out.println(str);
			
			// execute the operation  
			response = client.execute(targetHost,request);  


			// print the status and the contents of the response  
			Constants.showLog(""+response.getStatusLine());  
			Constants.showLog(EntityUtils.toString(response.getEntity()));  

		} catch (MalformedURLException ex) {
			Constants.showException("Malformed URL exception: "+ex);
		} catch (IOException ex) {
			Constants.showException("Input/Output exception: "+ex);
		} finally {  
			// release any connection resources used by the method  
			client.getConnectionManager().shutdown();  
		}
	}
}