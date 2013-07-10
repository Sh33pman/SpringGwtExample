package com.example.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The callback object for the list service
 * 
 * @author Sh33pman
 * @since  24 Feb 2012
 */
public interface ListServiceAsync {
	
	/**
	 * Call back function for the retrieve list function
	 * 
	 * @param callback The object
	 */
	void retrieveList (AsyncCallback<ArrayList<String>> callback) throws IllegalArgumentException;
	
	/**
	 * Call back function for the add item to list function
	 * 
	 * @param item - The item that should be added to the list
	 * @param callback - The object
	 */
	void addItem( String item, AsyncCallback<String> callback )  throws IllegalArgumentException;
}
