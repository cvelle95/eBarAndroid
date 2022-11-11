package com.example.eBarAndroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eBarAndroid.api.API;
import com.example.eBarAndroid.api.ReadDataHandler;
import com.example.eBarAndroid.model.Artikal;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;

import java.util.LinkedList;

public class OrderActivity extends AppCompatActivity {
    int table_id;
    LinearLayout artikalScrollView;
    LayoutInflater inflaterScrollArtikal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().hide();

        Bundle extra = getIntent().getExtras();
        table_id = extra.getInt("table_id");

        artikalScrollView = findViewById(R.id.artikalScrollView);
        inflaterScrollArtikal = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Button categoryButton1 = findViewById(R.id.categoryButton1);
        Button categoryButton2 = findViewById(R.id.categoryButton2);
        Button categoryButton3 = findViewById(R.id.categoryButton3);
        Button categoryButton4 = findViewById(R.id.categoryButton4);

        categoryButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtikli(1);
            }
        });

        categoryButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtikli(2);
            }
        });

        categoryButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtikli(3);
            }
        });

        categoryButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtikli(4);
            }
        });




    }

    void getArtikli(int categoryId){
        String getArtikliURL = "http://192.168.8.106:8080/artikal/getartiklibykategorijaid?kategorija_id="+categoryId;

        API.getJSON(getArtikliURL,new ReadDataHandler(){
            @Override
            public void handleMessage(Message msg){
                String odgovor = getJson();
                try {
                    JSONArray array= new JSONArray(odgovor);
                    LinkedList<Artikal> artikli = Artikal.getArtikliPoKategoriji(array);
                    for(Artikal artikal : artikli){
                        ConstraintLayout artikalButton = (ConstraintLayout) inflaterScrollArtikal.inflate(R.layout.artikalbutton,null);
                        TextView artikalLabel = artikalButton.findViewById(R.id.artikalLabel);
                        artikalLabel.setText(artikal.getNaziv());

                        artikalButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int artikalId = artikal.getId();
                                /////////provera toast///pomeri posle

                                Context context = getApplicationContext();
                                String text = "Kliknut je item sa id-om: "+artikalId;
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                //////////////////////////////////////

                            }
                        });


                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}