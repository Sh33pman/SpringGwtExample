package com.a24studio.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SpringGwt implements EntryPoint {
	
	protected TextBox theTextBox;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		//Adds a Text box
		theTextBox = new TextBox( );
		RootPanel.get().add(theTextBox);
		
		//Create the label for the list
		final Label quoteText = new Label();
		
		//Adds a button to the page
		Button addButton = new Button( "Add" );
		RootPanel.get().add( addButton );
		
		//Add click event handler
		addButton.addClickHandler( new ClickHandler( ) {
			
			@Override
			public void onClick(ClickEvent event) {
				if ( theTextBox.getText().length() > 0 ) {
					AsyncCallback<String> callback = new AsyncCallback<String>() {
						
						public void onFailure(Throwable t) {
							// display error text if we can't get the quote:
							quoteText.setText("Failed to get a quote");
						}

						public void onSuccess(String result) {
							
						}
						
					};
					//Makes a addItem RPC call
					ListServiceAsync service = GWT.create(ListService.class);
					service.addItem( theTextBox.getText(), callback );
				
				}
			}
		});
		
		//Create time to retrieve the list every 3 seconds
		Timer timer = new Timer() {

			public void run() {
				// create an async callback to handle the result:
				AsyncCallback<ArrayList<String>> callback = new AsyncCallback<ArrayList<String>>() {

					public void onFailure(Throwable t) {
						// display error text if we can't get the quote:
						quoteText.setText("Failed to get a quote");
					}
					
					// Test the text of the list on the label
					public void onSuccess(ArrayList<String> result) {
						// display the retrieved quote in the label:
						String list = "";
						boolean first = true;
						for ( String x : result ) {
							if ( first ) {
								first = false;
							} else {
								list += ", ";
							}
							list += x;
						}
						quoteText.setText( list );
					}
				};
				// Retrieve all the list items
				ListServiceAsync service = GWT.create(ListService.class);
				service.retrieveList(callback);
			}
		};
		//Set the time interval
		timer.scheduleRepeating(3000);
		RootPanel.get().add(quoteText);
		
	}
}
