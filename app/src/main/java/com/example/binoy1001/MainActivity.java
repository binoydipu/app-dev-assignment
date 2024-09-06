package com.example.binoy1001;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button audi, bugatti;
    private TextView textView, toastTv;
    private ImageView imageView, toastIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audi = findViewById(R.id.audi_btn);
        bugatti = findViewById(R.id.bugatti_btn);
        textView = findViewById(R.id.textview);
        imageView = findViewById(R.id.imageview);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_layout));

        toastIv = layout.findViewById(R.id.toast_iv);
        toastTv = layout.findViewById(R.id.toast_tv);

        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        audi.setOnClickListener(v -> {
            textView.setText("This is a picture of Audi R8");
            imageView.setImageResource(R.drawable.audi);
            toastIv.setImageResource(R.drawable.audi_icon);
            toastTv.setText("Audi R8");
            toast.show();
        });
        bugatti.setOnClickListener(v -> {
            textView.setText("This is a picture of Bugatti W16 Mistral");
            imageView.setImageResource(R.drawable.bugatti);
            toastIv.setImageResource(R.drawable.bugatti_icon);
            toastTv.setText("Bugatti W16 Mistral");
            toast.show();
        });
    }
}