package com.example.binoy1001;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List<String> banner;
    HashMap<String, List<Item>> items;
    private int lastExpandedGroup = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        expandableListView = findViewById(R.id.expandable_listview);
        setData();
        ExpandableListAdapter adapter =  new ExpandableListAdapter(this, banner, items);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            String groupText = banner.get(groupPosition);
            Toast.makeText(getApplicationContext(), groupText, Toast.LENGTH_SHORT).show();
            return false;
        });
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Item item = items.get(banner.get(groupPosition)).get(childPosition);
            Toast.makeText(getApplicationContext(), item.getDescription(), Toast.LENGTH_SHORT).show();
            return false;
        });
        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedGroup != -1 && lastExpandedGroup != groupPosition) {
                expandableListView.collapseGroup(lastExpandedGroup);
            }
            lastExpandedGroup = groupPosition;
        });
    }

    private void setData() {
        final String[] titles = {"Apple", "Banana", "Orange", "Pineapple"};
        final String[] subTitles = {"Apple is red", "Banana is yellow", "Orange is orange", "Pineapple is brown-orange"};
        final int[] images = {R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.pineapple};
        final String[] descriptions = getResources().getStringArray(R.array.descriptions);
        banner = new ArrayList<>();
        items = new HashMap<>();
        for(int i=0; i<titles.length; i++) {
            banner.add(titles[i]);
            List<Item> group = new ArrayList<>();
            Item item = new Item(titles[i], descriptions[i], images[i], subTitles[i]);
            group.add(item);
            items.put(banner.get(i), group);
        }
    }
}