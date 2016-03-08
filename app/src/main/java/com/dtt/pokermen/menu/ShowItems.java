package com.dtt.pokermen.menu;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dtt.pokermen.R;
import com.dtt.pokermen.data.gameDat;


public final class ShowItems {

	private static Activity activity = null;

	private static ListView list;
	private static String[] values;
	
	private ShowItems() {}

	public static void ShowItemsMenu(Activity a){
		activity = a;

		a.setContentView(R.layout.items_screen);

		list = (ListView) a.findViewById(R.id.itemsList);
		createList();
		update();
	}

	private static void update() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, android.R.id.text1, values);
      
       // Assign adapter to ListView
		list.setAdapter(adapter); 
          
          // ListView Item Click Listener
		list.setOnItemClickListener(new OnItemClickListener() {
   
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      
                 // ListView Clicked item index
                	int itemPosition     = position;
                 
                 // ListView Clicked item value
                	String  itemValue    = (String) list.getItemAtPosition(position);

                  // Show Alert
                	Toast.makeText(activity.getApplicationContext(), "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();

                }
        }); 
	
	}
	
	private static void createList(){
		
        // Defined Array values to show in ListView
        values = new String[] { "pokerball", 
	                             "Nutter Key 1",
	                             "Nutter Key 2",
	                             "Nutter Key 3",
	                             "Reviver",
	                             "NattyLite", 
	                             "Potion++", 
	                             "very rly good pokerball", 
	                             "Hypodermic Needles", 
	                             "Broken Bike" 
	                            };
	}
	

}
