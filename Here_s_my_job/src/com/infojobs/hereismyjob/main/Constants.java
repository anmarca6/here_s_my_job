/**
 * @author: Angel Martinez-Cavero (anmarca6@gmail.com)
 * Date: 09/12/2012
 * Project name: HereIsMyJob
 * License:
 * 
 */

package com.infojobs.hereismyjob.main;

import android.util.Log;


public class Constants {
	
	/** HTTP parameters */		
	public static final String HOST_NAME = "api.infojobs.net";
	public static final int PORT_NUMBER = 443;
	public static final String HOST_SCHEME = "https";
	public static final String CLIENT_ID_AUTHENTICATION = "13b3c5bdd3724c35beef36b03387006e";
	public static final String CLIENT_SECRET_AUTHENTICATION = "5q4Yq2t+JG/likKEP9yIHVW3uXrrrizs3N9mxrqnW5SEuhvIT8";
	
	// callback uri http://www.infojobs.net/core/oauth2vc/index.xhtml
	
	/** API available operations */
	public static final String API_HEADER = "https://api.infojobs.net/api/";
	// Job search	
	public static final String API_OPERATION_JOB_SEARCH = API_HEADER+"1/offer/";
	
	// Job application and tracking
	public static final String API_OPERATION_JOB_APP_AND_TRACKING = API_HEADER+"1/application/";
	
	// CV visualization and edition
	public static final String API_OPERATION_CV_VISUALIZATION_AND_EDITION = API_HEADER+"1/curriculum/";
	
	// Candidate
	public static final String API_OPERATION_CANDIDATE = API_HEADER+"2/candidate/";
	
	// Dictionary
	public static final String API_OPERATION_DICTIONARY = API_HEADER+"1/dictionary/";
	
	/** Output logs */
	public static void showLog(String str) {
		Log.d("<LOG> ",str);
	}
	
	public static void showException(String str) {
		Log.d("<EXCEPTION> ",str);
	}
}
