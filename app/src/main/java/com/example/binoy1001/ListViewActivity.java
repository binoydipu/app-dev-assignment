package com.example.binoy1001;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {

    private final String[] titles = {"Apple", "Banana", "Orange", "Pineapple"};
    private final String[] subTitles = {"Apple is red", "Banana is yellow", "Orange is orange", "Pineapple is brown-orange"};
    private final int[] images = {R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.pineapple};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.item_listview);
        ListViewAdapter adapter = new ListViewAdapter(this, titles, subTitles, images);
        listView.setAdapter(adapter);
    }
}