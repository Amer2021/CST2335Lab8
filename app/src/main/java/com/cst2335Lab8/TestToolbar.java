package com.cst2335Lab8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class TestToolbar extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);

        /*initializing the toolbar by loading the view attached to this
         *layout bearing the id name : toolbar
         */
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //setting the indicator using the ic_homeic icon
        actionBar.setHomeAsUpIndicator(R.drawable.ic_homeic);


        //Handling click events on the navigation drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //using switch statement to handle different item click events on the navigation drawer
                switch(item.getItemId()){

                    //handle event when chat item is clicked (goto chat activity)
                    case R.id.chat:
                        Intent chatIntent = new Intent(TestToolbar.this, ChatRoomActivity.class);
                        startActivity(chatIntent);
                        return true;

                    //handle event when weather item is clicked (goto weather forecast activity)
                    case R.id.weather:
                        Intent weatherIntent = new Intent(TestToolbar.this, WeatherForecast.class);
                        startActivity(weatherIntent);
                        return true;

                    //handle event when goback item is clicked (return to profile activity)
                    case R.id.goback:
                        //set the result(500) to be returned after activity finishes.
                        setResult(500);

                        //Finnish TestToolbar activity and return to Profile Activity
                        finish();

                        return true;

                    default:
                        return true;
                }
            }
        });
    }

    //Overriding the onCreateOptionsMenu to add the menu to the layout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //creating an object of the MenuInflater to inflate the menu
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    //Overriding onOptionsItemSelected to handle Menu Item event click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Using a switch to determine which item was clicked and then perfomrming a desired action
        switch(item.getItemId()){

            //handle item1 click event
            case R.id.item1:
                Toast.makeText(this, "you clicked on item1", Toast.LENGTH_SHORT).show();
                return true;

            //handle item2 click event
            case R.id.item2:
                Toast.makeText(this, "you clicked on item2", Toast.LENGTH_SHORT).show();
                return true;

            //handle item3 click event (overflow menu)
            case R.id.item3:
                Toast.makeText(this, "you clicked on the overflow menu", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.sub_item1:
                Toast.makeText(this, "you clicked on item3", Toast.LENGTH_SHORT).show();
                return true;

            //handle navigation click event
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}