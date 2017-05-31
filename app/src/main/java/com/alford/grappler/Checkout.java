package com.alford.grappler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Checkout extends AppCompatActivity {
    List<Positions> mPositions;
    CheckoutAdapter mAdapter;



   // public static final String MOVE_KEY = "give me that position";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);



        DatabaseHelper helper = DatabaseHelper.getInstance(this);
      //  List<Positions> positions = helper.getAllPostions();


        //second recycler could have used heterogenius recycler to incorperate in Store and Checkout Activities

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<Positions> positionsInCart = DatabaseHelper.getInstance(this).getAllPostionsInCart();
        mAdapter = new CheckoutAdapter(positionsInCart);



        recyclerView.setAdapter(mAdapter);


        //Clicking button sets quantity column to zero and resets the adapter clearing the entire kart

        findViewById(R.id.final_purchase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper.getInstance(v.getContext()).clearPositionsCartByQuant();

             Toast.makeText(v.getContext(),"You've Checked Out",Toast.LENGTH_SHORT).show();

                mAdapter.resetAdapter();


            }
        });


    }
}
