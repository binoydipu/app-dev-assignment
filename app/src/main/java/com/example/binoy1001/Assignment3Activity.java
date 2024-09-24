package com.example.binoy1001;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Assignment3Activity extends AppCompatActivity {

    private RatingBar rbRatingBar;
    private TextView tvRating, tvSeekbar, tvRateMe, tvCopyright;
    private SeekBar seekBar;
    private SwitchCompat scDarkMode;
    private ConstraintLayout clBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment3);

        rbRatingBar = findViewById(R.id.ratingBar);
        tvRating = findViewById(R.id.rating_tv);
        seekBar = findViewById(R.id.seekbar_sb);
        tvSeekbar = findViewById(R.id.seekbar_progress_tv);
        tvRateMe = findViewById(R.id.rateme_tv);
        scDarkMode = findViewById(R.id.dark_mode_switch);
        clBackground = findViewById(R.id.main);
        tvCopyright = findViewById(R.id.copyright_tv);

        rbRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                tvRating.setText(String.format("Rating: %s", rating)));

        // default theme
        clBackground.setBackgroundColor(getResources().getColor(R.color.white, getTheme()));

        // seekbar listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeekbar.setText(String.format("Progress: " + progress + "/" + seekBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // switch on or off listener
        scDarkMode.setOnCheckedChangeListener((buttonView, isChecked) ->
                isDarkModeEnabled(isChecked));

    }

    private void isDarkModeEnabled(boolean isChecked) {
        if(isChecked) {
            clBackground.setBackgroundColor(getResources().getColor(R.color.darkBackground, getTheme()));
            tvRateMe.setTextColor(getResources().getColor(R.color.white, getTheme()));
            tvRating.setTextColor(getResources().getColor(R.color.white, getTheme()));
            tvSeekbar.setTextColor(getResources().getColor(R.color.white, getTheme()));
            scDarkMode.setTextColor(getResources().getColor(R.color.white, getTheme()));
            tvCopyright.setTextColor(getResources().getColor(R.color.white, getTheme()));
        }
        else {
            clBackground.setBackgroundColor(getResources().getColor(R.color.white, getTheme()));
            tvRateMe.setTextColor(getResources().getColor(R.color.black, getTheme()));
            tvRating.setTextColor(getResources().getColor(R.color.black, getTheme()));
            tvSeekbar.setTextColor(getResources().getColor(R.color.black, getTheme()));
            scDarkMode.setTextColor(getResources().getColor(R.color.black, getTheme()));
            tvCopyright.setTextColor(getResources().getColor(R.color.black, getTheme()));
        }
    }
}