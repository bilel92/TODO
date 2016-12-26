package com.first.sqlite.tekup.bilel.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.first.sqlite.tekup.bilel.todo.DataSource.PositionDataSource;
import com.first.sqlite.tekup.bilel.todo.Model.Position;

public class MainActivity extends AppCompatActivity {


    private PositionDataSource datasource;

    EditText txtlong;
    EditText txtlat;
    Double longitude;
    Double latitude;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        datasource = new PositionDataSource(this);
        datasource.open();

        btnAdd = (Button)findViewById(R.id.add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Position position = null;

                txtlong = (EditText)findViewById(R.id.longitude);
                txtlat = (EditText)findViewById(R.id.latitude);

                longitude = Double.valueOf(txtlong.getText().toString());
                latitude =  Double.valueOf(txtlat.getText().toString());

                position = datasource.createPosition(longitude,latitude);

                Toast.makeText(MainActivity.this,"position creé with id = "+position.getId(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),PositionActivity.class);
                startActivity(i);

            }
        });





    }
}
