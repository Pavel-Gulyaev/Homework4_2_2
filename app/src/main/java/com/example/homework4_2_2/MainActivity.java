package com.example.homework4_2_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemsDataAdapter adapter;
    List<ItemData> items = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        fillData();
        adapter = new ItemsDataAdapter(this, items);


        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showItemData(position);
                return true;
            }
        });

    }

    private void fillData(){
        items.add(new ItemData(getDrawable(R.drawable.homework211),
                getString(R.string.homework211_title),
                getString(R.string.homework211_subtitle)));
        items.add(new ItemData(getDrawable(R.drawable.homework212),
                getString(R.string.homework212_title),
                getString(R.string.homework212_subtitle)));
        items.add(new ItemData(getDrawable(R.drawable.homework213),
                getString(R.string.homework213_title),
                getString(R.string.homework213_subtitle)));
        items.add(new ItemData(getDrawable(R.drawable.homework221),
                getString(R.string.homework221_title),
                getString(R.string.homework221_subtitle)));
    }

    private void showItemData(int position) {
        ItemData itemData = adapter.getItem(position);
        Toast.makeText(MainActivity.this,
                "Title: " + itemData.getTitle() + "\n" +
                        "Subtitle: " + itemData.getSubtitle(),
                Toast.LENGTH_SHORT).show();
    }
}