package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    private TextView DebugMessage;

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

        DebugMessage = findViewById(R.id.txtStatus);

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRegistration();
            }
        });

    }

    private void submitRegistration(){
        String host = "home-automation.cvcd3rwhftui.us-east-2.rds.amazonaws.com";
        String username = "teamumbrella";
        String password = "2az$pgK974";

        try{
            Connection con = DriverManager.getConnection(host, username, password);
            Statement stmt = con.createStatement();

            if(con.isValid(0)){
                DebugMessage.setText("Connected.");
            }
            else{
                DebugMessage.setText("Not Connected.");
            }
        }
        catch (SQLException err){
            DebugMessage.setText("Error Connecting." + err.toString());
        }

    }
}
