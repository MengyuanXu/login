package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Username = (EditText)findViewById(R.id.txtUsername);
        Password = (EditText)findViewById(R.id.txtPassword);
        ConfirmPassword = (EditText)findViewById(R.id.txtConfirmPassword);
        FirstName = (EditText)findViewById(R.id.txtFirstName);
        LastName = (EditText)findViewById(R.id.txtLastName);
        Email = (EditText)findViewById(R.id.txtEmail);
        Phone = (EditText)findViewById(R.id.txtPhone);
        Address = (EditText)findViewById(R.id.txtAddress);
        City = (EditText)findViewById(R.id.txtCity);
        State = (EditText)findViewById(R.id.txtState);
        PostalCode = (EditText)findViewById(R.id.txtPostalCode);
        Registration = (Button)findViewById(R.id.btnRegister);

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRegistration();
            }
        });
        
    }

    private void submitRegistration(){

    }
}
