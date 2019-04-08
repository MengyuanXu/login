package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Registration;
    private int counter = 5;  //Initializes the remaining number of inputs


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defining Variables
        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
        Info = (TextView)findViewById(R.id.textinfo);
        Login = (Button)findViewById(R.id.loginbuton);
        Registration = (Button)findViewById(R.id.btnRegistration);

        Info.setText("Number of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());

            }
        });

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPassword){
        // Determine if the username and password are correct
        if(userName.equals("project2") && userPassword.equals("12345")){
            Intent intent = new Intent(MainActivity.this, Main3Activity.class);
            startActivity(intent);
        }else{
            //If the password is entered incorrectly, the number of remaining inputs will decrease, up to 5 times.
            counter--;
            Info.setText("Number of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }

    }


}
