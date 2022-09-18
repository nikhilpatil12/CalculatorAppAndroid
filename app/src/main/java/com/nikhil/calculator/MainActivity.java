package com.nikhil.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    HistoryRecyclerAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        TableLayout tl;
        TextView calcResult;
        LinearLayout linearLayout;
        RecyclerView rv;
        LayoutInflater li;
        Button b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23;

        rv = findViewById(R.id.rl);
        tl = findViewById(R.id.calcButtons);
        calcResult = findViewById(R.id.calcResult);
        linearLayout =  findViewById(R.id.linearLayout);

        b = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);

        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);

        b13 = findViewById(R.id.button13);
        b14 = findViewById(R.id.button14);
        b15 = findViewById(R.id.button15);
        b16 = findViewById(R.id.button16);

        b17 = findViewById(R.id.button17);
        b18 = findViewById(R.id.button18);
        b19 = findViewById(R.id.button19);
        b20 = findViewById(R.id.button20);

        b21 = findViewById(R.id.button21);
        b22 = findViewById(R.id.button22);
        b23 = findViewById(R.id.button23);
        b23 = findViewById(R.id.button24);


        ViewGroup.LayoutParams tlParams = tl.getLayoutParams();
        tlParams.height = (int) (height*0.62);
        tl.setLayoutParams(tlParams);

        ViewGroup.LayoutParams linearLayoutParams = linearLayout.getLayoutParams();
        linearLayoutParams.height = height - (int) (height*0.62);
        linearLayout.setLayoutParams(linearLayoutParams);

        ViewGroup.LayoutParams calcResultParams = calcResult.getLayoutParams();
        calcResultParams.height = (int) ((height - height*0.62)*0.33);
        calcResult.setLayoutParams(calcResultParams);

        ViewGroup.LayoutParams rvParams = rv.getLayoutParams();
        rvParams.height = (int) ((height - height*0.62)*0.65);
        rv.setLayoutParams(rvParams);

        ArrayList<String> historyList = new ArrayList<>();
        //historyList.add("20/10");


        // set up the RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(this));
        historyAdapter = new HistoryRecyclerAdapter(this, historyList);
//        historyAdapter.setClickListener(this);
        rv.setAdapter(historyAdapter);


        //Calculator Logic
        //0
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //1
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //2
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //3
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //4
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //5
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //6
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //7
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //8
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //9
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Basic Operations
        //+
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //-
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //x
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ///
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Advanced operations
        //%
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //root
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //square
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //reciprocal
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //+-
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //Other ops
        //ce
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //c
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //bs
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}