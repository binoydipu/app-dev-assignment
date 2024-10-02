package com.example.binoy1001;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class FormActivity extends AppCompatActivity {

    private TextInputEditText etName, etID, etEmail, etPassword, etMobile;
    private Spinner countrySpinner;
    private String name, id, email, password, mobile, country;
    private ConstraintLayout inputLayout;
    private LinearLayout outputLayout;
    private TextView tvOutput;
    private Button btnSubmit, btnEditForm, btnConfirm;

    private static final Pattern namePattern = Pattern.compile("^[a-zA-Z .-]+$"); // letters, space, dot, dash
    private static final Pattern idPattern = Pattern.compile("^[0-9]{16}$"); // 16 digits number
    private static final Pattern emailPattern = Pattern.compile("^[a-z0-9]+@[a-z]+\\.[a-z]{2,}$"); // abc@something.com
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{6,32}$"); // aA@12345
    private static final Pattern phonePattern = Pattern.compile("^(\\+88)?01[2-9][0-9]{8}$"); // (+88) 01 7 12345678

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etName = findViewById(R.id.name_et);
        etID = findViewById(R.id.id_et);
        etEmail = findViewById(R.id.email_et);
        etPassword = findViewById(R.id.password_et);
        etMobile = findViewById(R.id.mobile_et);
        countrySpinner = findViewById(R.id.country_spinner);
        inputLayout = findViewById(R.id.input_layout);
        btnSubmit = findViewById(R.id.submit_btn);
        btnEditForm = findViewById(R.id.edit_form_btn);
        btnConfirm = findViewById(R.id.confirm_btn);
        outputLayout = findViewById(R.id.output_layout);
        tvOutput = findViewById(R.id.filled_form_tv);
        String[] items = new String[]{"Select Country", "Australia", "Argentina", "Brazil", "Bangladesh", "Canada", "China", "Thailand", "Japan", "Germany", "Russia", "Singapore", "USA"};
        countrySpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items));
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = countrySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country = "none";
            }
        });
        btnSubmit.setOnClickListener(v -> {
            name = etName.getText().toString().trim();
            id = etID.getText().toString().trim();
            email = etEmail.getText().toString().trim();
            password = etPassword.getText().toString().trim();
            mobile = etMobile.getText().toString().trim();
            if (name.isEmpty()) {
                etName.setError("Required field!");
                etName.requestFocus();
            } else if(!namePattern.matcher(name).matches()) {
                etName.setError("Invalid name. Use [a-z, A-Z, space, - and .] only");
                etName.requestFocus();
            } else if (id.isEmpty()) {
                etID.setError("Required field!");
                etID.requestFocus();
            } else if(!idPattern.matcher(id).matches()) {
                etID.setError("Invalid Student ID");
                etID.requestFocus();
            } else if (email.isEmpty()) {
                etEmail.setError("Required field!");
                etEmail.requestFocus();
            } else if(!emailPattern.matcher(email).matches()) {
                etEmail.setError("Invalid Email");
                etEmail.requestFocus();
            } else if (password.isEmpty()) {
                etPassword.setError("Required field!");
                etPassword.requestFocus();
            } else if(!passwordPattern.matcher(password).matches()) {
                etPassword.setError("Invalid Password");
                etPassword.requestFocus();
            } else if (mobile.isEmpty()) {
                etMobile.setError("Required field!");
                etMobile.requestFocus();
            } else if(!phonePattern.matcher(mobile).matches()) {
                etMobile.setError("Invalid Mobile Number");
                etMobile.requestFocus();
            } else if(country.equals("none") || country.equals("Select Country")) {
                Toast.makeText(this, "Select Country", Toast.LENGTH_SHORT).show();
            } else {
                inputLayout.setVisibility(View.GONE);
                outputLayout.setVisibility(View.VISIBLE);
                String res = "Name: " + name + "\nID: " + id + "\nEmail: " + email +
                        "\nPassword: ****" + "\nMobile: " + mobile + "\nCountry: " + country;
                tvOutput.setText(res);
            }
        });
        btnEditForm.setOnClickListener(v -> {
            inputLayout.setVisibility(View.VISIBLE);
            outputLayout.setVisibility(View.GONE);
        });
        btnConfirm.setOnClickListener(v -> {
            etName.setText("");
            etID.setText("");
            etEmail.setText("");
            etPassword.setText("");
            etMobile.setText("");
            countrySpinner.setSelection(0);
            inputLayout.setVisibility(View.VISIBLE);
            outputLayout.setVisibility(View.GONE);
        });
    }
}