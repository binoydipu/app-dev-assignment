package com.example.binoy1001;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Assignment2Activity extends AppCompatActivity {

    private CheckBox cbPizza, cbBurger, cbPasta, cbChips;
    private TextView tvSelectedItems;
    private Button btnSelectItems;
    private ArrayList<String> selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment2);

        cbPizza = findViewById(R.id.pizza_cb);
        cbBurger = findViewById(R.id.burger_cb);
        cbPasta = findViewById(R.id.pasta_cb);
        cbChips = findViewById(R.id.chips_cb);
        tvSelectedItems = findViewById(R.id.selected_items_tv);
        btnSelectItems = findViewById(R.id.select_items_btn);
        selected = new ArrayList<>();

        cbPizza.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CheckSelectedItemsChange(buttonView.getText().toString(), isChecked);
        });
        cbBurger.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CheckSelectedItemsChange(buttonView.getText().toString(), isChecked);
        });
        cbPasta.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CheckSelectedItemsChange(buttonView.getText().toString(), isChecked);
        });
        cbChips.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CheckSelectedItemsChange(buttonView.getText().toString(), isChecked);
        });
        
        btnSelectItems.setOnClickListener(v -> {
            String items = "none.";
            if(!tvSelectedItems.getText().toString().trim().isEmpty()) items = tvSelectedItems.getText().toString();
            Toast.makeText(this, "Selected: " + items, Toast.LENGTH_SHORT).show();
        });
    }

    void CheckSelectedItemsChange(String itemName, boolean isAdded) {
        if(isAdded) {
            selected.add(itemName);
        } else {
            selected.remove(itemName);
        }
        StringBuilder items = new StringBuilder();
        for(String item : selected) {
            items.append(item);
            items.append(" ");
        }
        tvSelectedItems.setText(items);
    }
}