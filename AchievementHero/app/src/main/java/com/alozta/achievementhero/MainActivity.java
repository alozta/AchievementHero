package com.alozta.achievementhero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by alozta on 8/9/16.
 *
 * Includes some Android noob comments
 */
public class MainActivity extends AppCompatActivity {   // Make this change for every activity in your app that uses a Toolbar as an app bar.
    MenuItem addEntryItem, moreOptionsItem;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity","onCreate");

        //Starts with welcome layout
        setContentView(R.layout.welcome);

        startButton = (Button)findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main);  //Load main layout

                addEntryItem = (MenuItem) findViewById(R.id.plus_button);            //add buttons to toolbar
                moreOptionsItem = (MenuItem) findViewById(R.id.action_settings_button);

                Toolbar myToolbar = (Toolbar) findViewById(R.id.main_toolbar);
                myToolbar.inflateMenu(R.menu.actionbar_items);
                myToolbar.setTitle(R.string.app_name);
                myToolbar.setOnMenuItemClickListener(
                        new Toolbar.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                // Handle menu item click event
                                switch (item.getItemId()) {
                                    case R.id.plus_button:
                                        Log.i("MainActivity","PLUS");
                                        return true;
                                    case R.id.action_settings_button:
                                        Log.i("MainActivity","MORE");
                                        return true;
                                }
                                return false;
                            }
                        });
            }
        });

        DBHandler db = new DBHandler(this);

        //CONNECT BUTTONS W/ DB METHODS, DB method usages are in below
        /*
        // Inserting Shop/Rows
        Log.d(“Insert: “, “Inserting ..”);
        db.addShop(new Shop(“Dockers”, ” 475 Brannan St #330, San Francisco, CA 94107, United States”));
        db.addShop(new Shop(“Dunkin Donuts”, “White Plains, NY 10601”));
        db.addShop(new Shop(“Pizza Porlar”, “North West Avenue, Boston , USA”));
        db.addShop(new Shop(“Town Bakers”, “Beverly Hills, CA 90210, USA”));

        // Reading all shops
        Log.d(“Reading: “, “Reading all shops..”);
        List<Shop> shops = db.getAllShops();

        for (Shop shop : shops) {
            String log = “Id: ” + shop.getId() + ” ,Name: ” + shop.getName() + ” ,Address: ” + shop.getAddress();
            // Writing shops to log
            Log.d(“Shop: : “, log);
        }
        */
    }
}
