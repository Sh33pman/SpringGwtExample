package com.a24studio.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Basic service interface example
 * 
 * @author Sh33pman
 * @since  24 Feb 2012
 */
@RemoteServiceRelativePath("list.rpc")
public interface ListService extends RemoteService {
	
	/**
	 * Retrieves a list of strings
	 * 
	 * @return a list of strings
	 */
	ArrayList<String> retrieveList( ) throws IllegalArgumentException;
	
	/**
	 * Adds a item to the list
	 * 
	 * @param item - The item that should be added
	 * @return The item that was added
	 */
	String addItem( String item )  throws IllegalArgumentException;
	
}
