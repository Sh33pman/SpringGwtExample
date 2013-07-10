package com.example.server;

import java.util.ArrayList;

import com.example.client.ListService;

/**
 * The list service implementation
 * 
 * @author Sh33pman
 * @since  24 Feb 2012
 */
public class ListServiceImpl implements ListService {
	
	/**
	 * The list of items
	 */
	public static ArrayList<String> theList = new ArrayList<String>();
	
	/**
	 * Retrieves the list of items
	 * 
	 * @return the list of items
	 */
	@Override
	public ArrayList<String> retrieveList() throws IllegalArgumentException {
		return theList;
	}

	/**
	 * Adds a item to the list
	 * 
	 * @return the item that was added
	 */
	@Override
	public String addItem(String item) throws IllegalArgumentException {
		theList.add( item );
		return item;
	}

}
