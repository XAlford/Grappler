package com.alford.grappler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DetailView extends AppCompatActivity {
    public static final String MOVE_KEY = "give me that position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        long id = getIntent().getLongExtra(MOVE_KEY, -1);

        final Positions positions = DatabaseHelper.getInstance(this).getPositionById(id);

        if (positions == null) {
            Toast.makeText(this, "Thats not a GrAPPling art", Toast.LENGTH_SHORT).show();
            finish();
        }


        ((TextView) findViewById(R.id.item_name)).setText(positions.getmPositionName());
            ((TextView) findViewById(R.id.payment)).setText(positions.getmCost()+"");
            ((TextView) findViewById(R.id.item_description)).setText(positions.getmDescription());

        Button button = (Button) findViewById(R.id.gotocheckout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailView.this,Checkout.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.buy_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper.getInstance(v.getContext()).addToCArt(positions,1);

                Toast.makeText(v.getContext(),"item in cart",Toast.LENGTH_SHORT).show();

            }
        });






        //((ImageView) findViewById(R.id.item_logo)).(positions.getmImageBig());
            //((TextView) findViewById(R.id.defensive_offensive)).setText(positions.ismDefensive());
    }


}
