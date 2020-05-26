package com.hfad.mycoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hfad.mycoffee.orders.OrdersActivity;

public class CoffeeCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView,
                                            View itemView,
                                            int position,
                                            long id) {
                        if (position == 0) {
                            Intent intent = new Intent(CoffeeCategoryActivity.this,
                                    EspressoActivity.class);
                            startActivity(intent);
                        }
                        if (position > 0) {
                            Intent intent = new Intent(CoffeeCategoryActivity.this,
                                    CoffeeActivity.class);

                            switch (position) {
                                case 1:
                                    intent.putExtra(CoffeeActivity.EXTRA_COFFEE_NAME, (int) 0);
                                    startActivity(intent);
                                    break;
                                case 2:
                                    intent.putExtra(CoffeeActivity.EXTRA_COFFEE_NAME, 1);
                                    startActivity(intent);
                                    break;
                                case 3:
                                    intent.putExtra(CoffeeActivity.EXTRA_COFFEE_NAME, 2);
                                    startActivity(intent);
                                    break;
                                case 4:
                                    intent.putExtra(CoffeeActivity.EXTRA_COFFEE_NAME, 3);
                                    startActivity(intent);
                                    break;
                                case 5:
                                    intent.putExtra(CoffeeActivity.EXTRA_COFFEE_NAME, 4);
                                    startActivity(intent);
                                    break;
                            }
                        }
                    }
                };

        ListView listView = (ListView) findViewById(R.id.list_coffees);
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

