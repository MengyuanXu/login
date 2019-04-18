package com.example.login;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class RegistrationActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private EditText ConfirmPassword;
    private EditText FirstName;
    private EditText LastName;
    private EditText Email;
    private EditText Phone;
    private EditText Address;
    private EditText City;
    private EditText State;
    private EditText PostalCode;
    private Button Registration;

    private String TAG = RegistrationActivity.class.getSimpleName();
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Username = findViewById(R.id.txtUsername);
        Password = findViewById(R.id.txtPassword);
        ConfirmPassword = findViewById(R.id.txtConfirmPassword);
        FirstName = findViewById(R.id.txtFirstName);
        LastName = findViewById(R.id.txtLastName);
        Email = findViewById(R.id.txtEmail);
        Phone = findViewById(R.id.txtPhone);
        Address = findViewById(R.id.txtAddress);
        City = findViewById(R.id.txtCity);
        State = findViewById(R.id.txtState);
        PostalCode = findViewById(R.id.txtPostalCode);
        Registration = findViewById(R.id.btnRegister);

        dbHelper = new DatabaseHelper(this);
        final String sql = "INSERT INTO users (username, password) VALUES ('" +
                Username + "','" + Password  + "');";

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.addUser(sql);
                Log.e(TAG, "Execute Query.");
            }
        });

    }


}
