package com.example.eBarAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableMap extends AppCompatActivity implements View.OnClickListener{

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_map);
        getSupportActionBar().hide();

        intent = new Intent(this, OrderActivity.class);

        Button button1 = findViewById(R.id.table1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrdersIntent(1);
            }
        });
    }

        @Override
        public void onClick (View v){
        int table_id;
            switch (v.getId()) {
                case R.id.table1:
                    table_id = 1;
                    openOrdersIntent(table_id);
                    break;

                case R.id.table2:
                    table_id = 2;
                    openOrdersIntent(table_id);
                    break;

                case R.id.table3:
                    table_id = 3;
                    openOrdersIntent(table_id);
                    break;

                case R.id.table4:
                    table_id = 4;
                    openOrdersIntent(table_id);
                    break;

                case R.id.table5:
                    table_id = 5;
                    openOrdersIntent(table_id);
                    break;

                case R.id.table6:
                    table_id = 6;
                    openOrdersIntent(table_id);
                    break;

                case R.id.table8:
                    table_id = 7;
                    openOrdersIntent(table_id);
                    break;

                case R.id.table7:
                    table_id = 8;
                    openOrdersIntent(table_id);
                    break;
            }

        }
    void openOrdersIntent(int table_id) {
        try {
            Bundle extra = new Bundle();
            extra.putInt("table_id", table_id);
            intent.putExtras(extra);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}