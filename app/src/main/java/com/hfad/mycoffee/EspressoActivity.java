package com.hfad.mycoffee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hfad.mycoffee.Coffee.Espresso;
import com.hfad.mycoffee.orders.ListOfOrders;
import com.hfad.mycoffee.orders.OrdersActivity;


public class EspressoActivity extends AppCompatActivity {

    private Espresso espresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        espresso = makeCoffee();

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(espresso.getName());

        TextView describe = (TextView) findViewById(R.id.description_espresso);
        describe.setText(espresso.getDescription());

        ImageView image = findViewById(R.id.photo);
        image.setImageResource(espresso.getImageResourceId());
        image.setContentDescription(espresso.getName());
    }

    public void onClickChoice(View view){
        try {
            createEspressoIntensity(view);
            createEspressoCapacity(view);

            ListOfOrders.makeOrder(takeName(), espresso);
            showDialog();
        }catch (NullPointerException e){
            TextView textView = (TextView)findViewById(R.id.warningIntensity);
            textView.setVisibility(View.VISIBLE);
            TextView textView1 = (TextView)findViewById(R.id.warning_capacity);
            textView1.setVisibility(View.VISIBLE);
        }
    }

    private void createEspressoIntensity(View view){
            RadioGroup intensityRadio = findViewById(R.id.intensity);
            choiceIntensity(intensityRadio.getCheckedRadioButtonId(), view);
    }

    private void createEspressoCapacity(View view){
        RadioGroup capacityRadio = findViewById(R.id.capacity);
        choiceCapacity(capacityRadio.getCheckedRadioButtonId(), view);
    }

    public void choiceIntensity(int id, View view){

            RadioButton radioButton = (RadioButton) findViewById(id);
            String intensity = radioButton.getText().toString();
            switch (intensity) {
                case "bardzo łagodna":
                    espresso.setIntensity(Espresso.Intensity.VERY_GENTLE);
                    break;
                case "łagodna":
                    espresso.setIntensity(Espresso.Intensity.GENTLE);
                    break;
                case "normalna":
                    espresso.setIntensity(Espresso.Intensity.NORMAL);
                    break;
                case "mocna":
                    espresso.setIntensity(Espresso.Intensity.STRONG);
                    break;
                case "bardzo mocna":
                    espresso.setIntensity(Espresso.Intensity.VERY_STRONG);
                    break;
                default:
                    break;
            }
    }

    public void choiceCapacity(int id, View view){

        RadioButton radioButton = (RadioButton) findViewById(id);
        String capacity = radioButton.getText().toString();
            switch (capacity) {
                case "bardzo mała":
                    espresso.setCapacity(Espresso.Capacity.VERY_SMALL);
                    break;
                case "mała":
                    espresso.setCapacity(Espresso.Capacity.SMALL);
                    break;
                case "normalna":
                    espresso.setCapacity(Espresso.Capacity.NORMAL);
                    break;
                case "duza":
                    espresso.setCapacity(Espresso.Capacity.LARGE);
                    break;
                case "bardzo duza":
                    espresso.setCapacity(Espresso.Capacity.GREAT_BIG);
                    break;
                default:
                    break;
            }
    }

    public String takeName(){
        EditText name = (EditText) findViewById(R.id.client_name);
        return name.getText().toString();
    }

    public Espresso makeCoffee(){
        return new Espresso();
    }

    private void showDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Dodano do listy!")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(EspressoActivity.this, MainActivity.class);
                                intent.putExtra("add", true);
                                startActivity(intent);
                            }
                        })
                .show();
    }

    public void onCheckBoxClickedSugar(View view){
       boolean checked = ((CheckBox) view).isChecked();
               if(checked){
                   espresso.setSugar(true);
               }else{
                   espresso.setSugar(false);
               }
       }


    public void onCheckBoxClickedDouble(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if(checked){
            espresso.setDouble(true);
        } else {
            espresso.setDouble(false);
        }
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
