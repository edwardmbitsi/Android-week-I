package com.moringaschool.plenty20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] shops = new String[] {"Jim's Phone Place", "Book-Wormers",
            "Uk Thrifts", "Baus Optics", "MacCoffee", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};
    private String[] items = new String[] {"Smartphones", "Books", "Shoes",
            "Glasses", "Coffee Beans", "Groceries", "Bags", "Home Appliances",
            "Decor", "Children Toys", "Chairs", "Computers", "X-box", "Sports Gears",
            "Bicycles", "Motorparts" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shops);
        ButterKnife.bind(this);

        ShopArrayAdapter adapter = new ShopArrayAdapter(this, android.R.layout.simple_list_item_1, shops, items);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String shops = ((TextView)view).getText().toString();
                Log.v("ShopActivity", "In the onItemClickListener!");
                Toast.makeText(ShopActivity.this, shops, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Shops near: " + location);
        Log.d("ShopActivity", "In the onCreate method!");
    }
}

