package com.hfad.mycoffee;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hfad.mycoffee.Coffee.Coffee;
import com.hfad.mycoffee.Coffee.MilkCoffee;
import com.hfad.mycoffee.orders.ListOfOrders;
import com.hfad.mycoffee.orders.OrdersActivity;

public class CoffeeActivity extends AppCompatActivity {

    public static final String EXTRA_COFFEE_NAME = "coffeeName";
    Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int coffeeName = (int)getIntent().getExtras().get(EXTRA_COFFEE_NAME);
        coffee = MilkCoffee.coffee[coffeeName];

        showCoffeeInfo();
    }



    public void showCoffeeInfo(){
        TextView nameOfCoffee = findViewById(R.id.nameCoffee);
        nameOfCoffee.setText(coffee.getName());

        TextView description = findViewById(R.id.describe);
        description.setText(coffee.getDescription());

        ImageView image = findViewById(R.id.photo);
        image.setImageResource(coffee.getImageResourceId());
        image.setContentDescription(coffee.getName());
    }




    public void onCheckBoxClickedSugar(View view){
        boolean checked = ((CheckBox) view).isChecked();
        if(checked){
            coffee.setSugar(true);
        }else{
            coffee.setSugar(false);
        }
    }


    public void onCheckBoxClickedDouble(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if(checked){
            coffee.setDouble(true);
        } else {
            coffee.setDouble(false);
        }
    }

    public void onClickDrink(View view){
        EditText name = (EditText) findViewById(R.id.name_milk_client);
        ListOfOrders.makeOrder(name.getText().toString(), coffee);
        showDialog();
    }

    private void showDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Dodano do listy!")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(CoffeeActivity.this, MainActivity.class);
                                intent.putExtra("add", true);
                                startActivity(intent);
                            }
                        })
                .show();
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
