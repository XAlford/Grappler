package com.alford.grappler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAssetHelper dbSetup = new DBAssetHelper(this);
        dbSetup.getReadableDatabase();



        List<Positions> myPositions = DatabaseHelper.getInstance(this).getAllPostions();

        for (Positions eachPosition: myPositions
             ) {
            System.out.println(eachPosition.getmPositionName());

        }

        Button button = (Button)findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Store.class);
                MainActivity.this.startActivity(intent);


            }
        });

    }




}
