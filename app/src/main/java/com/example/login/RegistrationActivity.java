package com.example.login;

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
    private Connection con;
    private String TAG = RegistrationActivity.class.getSimpleName();


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

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database();
                db.insertQuery();
                Log.e(TAG, "Execute Query.");
            }
        });

    }
    public class Database {
        public  void insertQuery ()
        {
            String hostname = "home-automation-bk.cvcd3rwhftui.us-east-2.rds.amazonaws.com";
            String dbName = "umbrella_automation";
            String port = "3306";
            String username = "teamumbrella";
            String password = "a2z$pgK974";

            String jdbcURL = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
            String sql = "insert into umbrella_automation.USER (user_name, password) values (\"user3\", \"password\");";
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection(jdbcURL, username, password);
                c.setAutoCommit(false);
                stmt = c.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
            }
            catch (Exception exc){
                Log.e(TAG, exc.getMessage());
            }
        }
    }

/*    private class submitRegistration extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            con = null;
            boolean result = false;

            String hostname = "home-automation-bk.cvcd3rwhftui.us-east-2.rds.amazonaws.com";
            String dbName = "home-automation";
            String port = "3306";
            String username = "teamumbrella";
            String password = "2az$pgK974";
            String jdbcURL = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
            String sql = "insert into umbrella_automation.USER (user_name, password) values (\"user3\", \"password\");";

            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(jdbcURL, username, password);
                PreparedStatement stmt = con.prepareStatement(sql);
                result = stmt.execute(sql);
                stmt.close();

            }
            catch(SQLException s){
                Log.e(TAG, s.getMessage());
            }
            catch(ClassNotFoundException c){
                Log.e(TAG, c.getMessage());
            }

            return null;
        }
    */
}
