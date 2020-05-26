package com.hfad.mycoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;


import com.hfad.mycoffee.orders.OrdersActivity;
import com.hfad.mycoffee.play.PlayActivity;

import static com.hfad.mycoffee.R.layout.activity_main;

/* This app is created for us and our family. Its goul is make easier our meetings when lot of people wont order a coffee and we
    don't have to remember all orders and we don't have to describe every time each coffee before some one will decide to choice it.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView,
                                            View itemView,
                                            int position,
                                            long id) {
                        if(position == 0){
                            Intent intent = new Intent(MainActivity.this, CoffeeCategoryActivity.class);
                            startActivity(intent);
                        }
                        if(position == 1){
                            Intent intent = new Intent(MainActivity.this, OrdersActivity.class);
                            startActivity(intent);
                        }
                        if(position == 2){
                            Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                            startActivity(intent);
                        }

                    }
                };

        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_show_list:
                Intent intent = new Intent(this, OrdersActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
