package com.hfad.mycoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.TextView;


import com.hfad.mycoffee.orders.OrdersActivity;
import com.hfad.mycoffee.play.PlayActivity;
import com.hfad.mycoffee.quotes.ApiService;
import com.hfad.mycoffee.quotes.Quote;

import static com.hfad.mycoffee.R.layout.activity_main;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

/* This app is created for us and our family. Its goul is make easier our meetings when lot of people wont order a coffee and we
    don't have to remember all orders and we don't have to describe every time each coffee before some one will decide to choice it.
 */

public class MainActivity extends AppCompatActivity {

    private final ApiService service = ApiService.getClient();
    private Disposable disposable = null;

    private List<Quote> quotes = new ArrayList<>();
    private Handler handler = new Handler(Looper.getMainLooper());
    private static final int POLLING_INTERVAL = 7000;

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

        startChangingQuotes();
    }

    private void startChangingQuotes() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getQuotes();
                handler.postDelayed(this, POLLING_INTERVAL);
            }
        }, 0);
    }

    private void getQuotes() {
        disposable = service.getQuotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(quotes -> {
                            this.quotes.clear();
                            this.quotes.addAll(quotes);
                            for(int i = 0; i<quotes.size(); i++){
                                TextView textView = (TextView)findViewById(R.id.quote);
                                textView.setText(this.quotes.get(0).getQuote() + "\n" + this.quotes.get(0).getAuthor());
                            }
                        },
                        throwable -> {
                            TextView textView = (TextView)findViewById(R.id.quote);
                            textView.setText("Nie można pobrać cytatu...");
                        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
        handler.removeCallbacksAndMessages(null);
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
