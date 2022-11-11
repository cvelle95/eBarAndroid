package com.example.eBarAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eBarAndroid.api.API;
import com.example.eBarAndroid.api.ReadDataHandler;
import com.example.eBarAndroid.model.Korisnik;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView labelOdgovor;
    Button validateLoginButton;
    EditText usernameText;
    EditText passwordText;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Sta kada se ucita Login skrin...
        validateLoginButton = (Button)findViewById(R.id.validateLoginButton);
        labelOdgovor = findViewById(R.id.labelOdgovor);
        validateLoginButton.setOnClickListener(this);
        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.userPasswordText);
        intent = new Intent(this,TableMap.class);

    }

    @Override
    public void onClick(View v) {
            String username = usernameText.getText().toString();

            String password = passwordText.getText().toString();
            String loginURL = "http://192.168.8.106:8080/korisnik/loginuser?username="+username+"&password="+password;

            API.getJSON(loginURL,new ReadDataHandler(){
                @Override
                public void handleMessage(Message msg){
                    String odgovor = getJson();
                    try{
                        JSONArray array = new JSONArray(odgovor);
                        LinkedList<Korisnik> korisnik = Korisnik.loginKorisnik(array);
                        System.out.println(korisnik);
                        if(korisnik.size()==0){
                            labelOdgovor.setText("Neispravan username ili password");
                        }else{
                            labelOdgovor.setText("Uspesno ste se ulogovali");
                            //prebaci id korisnika
                            startActivity(intent);

                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        labelOdgovor.setText("Exception//URL: "+loginURL);
                    }
                }
            });


    }
}