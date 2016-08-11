package com.alozta.achievementhero;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by alozta on 8/9/16.
 *
 * Includes some Android noob comments
 */
public class MainActivity extends AppCompatActivity {   // Make this change for every activity in your app that uses a Toolbar as an app bar.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(myToolbar); // This method sets the toolbar as the app bar for the activity
                                        // By default, the action bar contains just the name of the app and an overflow menu.
        myToolbar.inflateMenu(R.menu.actionbar_items);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.plus:
                // User chose the "Plus" action, add a new item
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
