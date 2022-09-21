package com.nikhil.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Debug;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Deque;
import java.util.logging.ConsoleHandler;

public class MainActivity extends AppCompatActivity {

    HistoryRecyclerAdapter historyAdapter;
    TextView currentOperation;
    TextView calcResult;
    boolean operationPerformed = false;
    boolean equalPressed = false;
    RecyclerView rv;
    ArrayList<String> historyList = new ArrayList<>();
    ArrayList<String> historyResultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        TableLayout tl;
        LinearLayout linearLayout;
        LayoutInflater li;
        Button b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24;

        rv = findViewById(R.id.rl);
        tl = findViewById(R.id.calcButtons);
        calcResult = findViewById(R.id.calcResult);
        currentOperation = findViewById(R.id.currentOperation);
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
        b24 = findViewById(R.id.button24);


        ViewGroup.LayoutParams tlParams = tl.getLayoutParams();
        tlParams.height = (int) (height*0.62);
        tl.setLayoutParams(tlParams);

        ViewGroup.LayoutParams linearLayoutParams = linearLayout.getLayoutParams();
        linearLayoutParams.height = height - (int) (height*0.62);
        linearLayout.setLayoutParams(linearLayoutParams);

        ViewGroup.LayoutParams calcResultParams = calcResult.getLayoutParams();
        calcResultParams.height = (int) ((height - height*0.62)*0.33*0.35);
        calcResult.setLayoutParams(calcResultParams);

        ViewGroup.LayoutParams currentOperationParams = currentOperation.getLayoutParams();
        currentOperationParams.height = (int) ((height - height*0.62)*0.33*0.65);
        calcResult.setLayoutParams(currentOperationParams);

        ViewGroup.LayoutParams rvParams = rv.getLayoutParams();
        rvParams.height = (int) ((height - height*0.62)*0.50);
        rv.setLayoutParams(rvParams);

//        historyList.add("20/10=");
//        historyResultList.add("200");


        // set up the RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(this));
        historyAdapter = new HistoryRecyclerAdapter(this, historyList, historyResultList);
//        historyAdapter.setClickListener(this);
        rv.setAdapter(historyAdapter);


        //Calculator Logic
        //0
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(0);
            }
        });
        //1
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(1);
            }
        });
        //2
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(2);

            }
        });
        //3
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(3);

            }
        });
        //4
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(4);

            }
        });
        //5
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(5);

            }
        });
        //6
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(6);

            }
        });
        //7
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(7);

            }
        });
        //8
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(8);

            }
        });
        //9
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber(9);

            }
        });
        //.
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDecimal();

            }
        });

        //Basic Operations
        //+
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterBasicOperators("+");
            }
        });
        //-
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterBasicOperators("-");

            }
        });
        //x
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterBasicOperators("×");

            }
        });
        ///
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterBasicOperators("÷");

            }
        });
        //=
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPendingOperation();
            }
        });

        //Advanced operations
        //%
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentOperation.getText().toString()!="" && calcResult.getText().toString()==""){
                    if(!checkSymbols())
                        currentOperation.setText((Double.parseDouble(currentOperation.getText().toString())/100)+"");
                }
                else if(currentOperation.getText().toString()!="" && calcResult.getText().toString()!=""){
                    calcResult.setText((Double.parseDouble(calcResult.getText().toString())/100)+"");
                }
            }
        });
        //root
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentOperation.getText().toString()!="" && calcResult.getText().toString()==""){
                    if(!checkSymbols())
                        currentOperation.setText(Math.sqrt(Double.parseDouble(currentOperation.getText().toString()))+"");
                }
                else if(currentOperation.getText().toString()!="" && calcResult.getText().toString()!=""){
                    calcResult.setText(Math.sqrt(Double.parseDouble(calcResult.getText().toString()))+"");
                }
            }
        });
        //square
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentOperation.getText().toString()!="" && calcResult.getText().toString()==""){
                    if(!checkSymbols())
                        currentOperation.setText((Double.parseDouble(currentOperation.getText().toString())*Double.parseDouble(currentOperation.getText().toString()))+"");
                }
                else if(currentOperation.getText().toString()!="" && calcResult.getText().toString()!=""){
                    calcResult.setText((Double.parseDouble(calcResult.getText().toString())*Double.parseDouble(calcResult.getText().toString()))+"");
                }
            }
        });
        //reciprocal
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentOperation.getText().toString()!="" && calcResult.getText().toString()==""){
                    if(!checkSymbols())
                        currentOperation.setText((1/Double.parseDouble(currentOperation.getText().toString()))+"");
                }
                else if(currentOperation.getText().toString()!="" && calcResult.getText().toString()!=""){
                    calcResult.setText((1/Double.parseDouble(calcResult.getText().toString()))+"");
                }
            }
        });
        //+-
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operationPerformed && !equalPressed){
                    if(currentOperation.getText().toString()!="" && calcResult.getText().toString()==""){
                        if(!checkSymbols())
                            currentOperation.setText((-Double.parseDouble(currentOperation.getText().toString()))+"");
                    }
                    else if(currentOperation.getText().toString()!="" && calcResult.getText().toString()!=""){
                        calcResult.setText((-Double.parseDouble(calcResult.getText().toString()))+"");
                    }
                    operationPerformed = false;
                    equalPressed = false;

                }
            }
        });


        //Other ops
        //ce
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcResult.setText("");
            }
        });
        //c
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcResult.setText("");
                currentOperation.setText("");
                equalPressed = false;
                operationPerformed = false;

            }
        });
        //bs
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!equalPressed && !operationPerformed){
                    if(calcResult.getText().toString()=="" && currentOperation.getText().toString()!=""){
                        if(!hasDecimal(currentOperation.getText().toString())){
                            if(Double.parseDouble(currentOperation.getText().toString())>9)
                                currentOperation.setText(currentOperation.getText().toString().substring(0,currentOperation.getText().toString().length()-1));
                            else
                                currentOperation.setText("0");

                        }
                        else{
                            currentOperation.setText(currentOperation.getText().toString().substring(0,currentOperation.getText().toString().length()-1));
                        }

                    }
                    else if(calcResult.getText().toString()!=""){
                        if(!hasDecimal(calcResult.getText().toString())){
                            if(Double.parseDouble(calcResult.getText().toString())>9)
                                calcResult.setText(calcResult.getText().toString().substring(0,calcResult.getText().toString().length()-1));
                            else
                                calcResult.setText("0");

                        }
                        else{
                            calcResult.setText(calcResult.getText().toString().substring(0,calcResult.getText().toString().length()-1));
                        }

                    }
                }
            }
        });
    }

    void enterNumber(int number){
        if(!checkSymbols()){
            if(currentOperation.getText().toString()=="" || (!checkSymbols() && Double.parseDouble(currentOperation.getText().toString()) ==0)){
                if(!hasDecimal(currentOperation.getText().toString()))
                    currentOperation.setText(""+number);
                else
                    currentOperation.setText(currentOperation.getText()+""+number);
            }
            else{
                currentOperation.setText(currentOperation.getText().toString() + number);
            }
        }
        else if(!equalPressed){
            if(operationPerformed){
                calcResult.setText(number+"");
            }
            else{
                if(calcResult.getText().toString()!=""){
                    if(Double.parseDouble(calcResult.getText().toString()) != 0) {
                        calcResult.setText(calcResult.getText().toString() + number);
                    }
                    else if(number!=0)
                        calcResult.setText(calcResult.getText().toString() + number);
                }
                else
                    calcResult.setText(number+"");
            }
        }
        else{
            currentOperation.setText(""+number);
            calcResult.setText("");
        }
        operationPerformed = false;
        equalPressed = false;
    }

    void enterDecimal(){
        if(!checkSymbols()){
            if(currentOperation.getText().toString()=="" || (!checkSymbols() && Double.parseDouble(currentOperation.getText().toString()) ==0)){
                currentOperation.setText("0.");
            }
            else if(!hasDecimal(currentOperation.getText().toString())){
                currentOperation.setText(currentOperation.getText().toString() + ".");
            }
        }
        else if(!equalPressed){
            if(operationPerformed || calcResult.getText().toString()==""){
                calcResult.setText("0.");
            }
            else if(!hasDecimal(calcResult.getText().toString())){
                calcResult.setText(calcResult.getText().toString() + ".");
            }
        }
        else{
            currentOperation.setText("0.");
            calcResult.setText("");
        }
        operationPerformed = false;
        equalPressed = false;
    }

    void enterBasicOperators(String symbol){
        if(!checkSymbols()){
            if(currentOperation.getText().toString()!=""){
                Log.d(symbol,symbol);
                currentOperation.setText(currentOperation.getText().toString() + symbol);
            }
        }
        else if(!equalPressed){
            String operation = getPendingOperation();
            String currentOps = currentOperation.getText().toString();
            if (calcResult.getText().toString()==""){
                currentOperation.setText(currentOps.substring(0,currentOps.length()-1)+symbol);
            }
            else if(!operationPerformed){
                currentOps=currentOps.substring(0,currentOps.length()-1);
                Double op1 = Double.parseDouble(currentOps);
                Double op2 = Double.parseDouble(calcResult.getText().toString());
                Double result = 0.0;
                switch (operation){
                    case "+":
                        result = op1+op2;
                        calcResult.setText(result+"");
                        currentOperation.setText(result+""+symbol);
                        historyList.add(op1+"+"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    case "-":
                        result = op1-op2;
                        calcResult.setText(result+"");
                        currentOperation.setText(result+""+symbol);
                        historyList.add(op1+"-"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    case "×":
                        result = op1*op2;
                        calcResult.setText(result+"");
                        currentOperation.setText(result+""+symbol);
                        historyList.add(op1+"×"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    case "÷":
                        result = op1/op2;
                        calcResult.setText(result+"");
                        currentOperation.setText(result+""+symbol);
                        historyList.add(op1+"÷"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    default:
                        break;
                }
                rv.setAdapter(historyAdapter);
                rv.smoothScrollToPosition(historyAdapter.getItemCount()-1);
                operationPerformed = true;
            }
            else{
                currentOperation.setText(currentOps.substring(0,currentOps.length()-1)+symbol);
            }
        }
        else{
            currentOperation.setText(calcResult.getText()+symbol);
            calcResult.setText("");
        }
        equalPressed = false;
    }

    void performPendingOperation(){
        if(checkSymbols()){
            String operation = getPendingOperation();
            String currentOps = currentOperation.getText().toString();
            if(!operationPerformed){
                currentOps=currentOps.substring(0,currentOps.length()-1);
                Double op1 = Double.parseDouble(currentOps);
                Double op2 = Double.parseDouble(calcResult.getText().toString());
                Double result = 0.0;
                switch (operation){
                    case "+":
                        result = op1+op2;
                        currentOperation.setText(currentOperation.getText()+""+calcResult.getText()+"=");
                        calcResult.setText(result+"");
                        historyList.add(op1+"+"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    case "-":
                        result = op1-op2;
                        currentOperation.setText(currentOperation.getText()+""+calcResult.getText()+"=");
                        calcResult.setText(result+"");
                        historyList.add(op1+"-"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    case "×":
                        result = op1*op2;
                        currentOperation.setText(currentOperation.getText()+""+calcResult.getText()+"=");
                        calcResult.setText(result+"");
                        historyList.add(op1+"×"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    case "÷":
                        result = op1/op2;
                        currentOperation.setText(currentOperation.getText()+""+calcResult.getText()+"=");
                        calcResult.setText(result+"");
                        historyList.add(op1+"÷"+op2+"=");
                        historyResultList.add(result+"");
                        break;
                    default:
                        break;
                }
                rv.setAdapter(historyAdapter);
                rv.smoothScrollToPosition(historyAdapter.getItemCount()-1);
                operationPerformed = true;
            }
        }
        equalPressed = true;
    }

    boolean checkSymbols(){
        if(currentOperation.getText().toString().contains("+") || (currentOperation.getText().toString().contains("-") && currentOperation.getText().toString().indexOf("-",1)!=-1 )|| currentOperation.getText().toString().contains("×") || currentOperation.getText().toString().contains("÷"))
            return true;
        else
            return false;
    }

    String getPendingOperation(){
        if(currentOperation.getText().toString().contains("+"))
            return "+";
        if(currentOperation.getText().toString().contains("-") && currentOperation.getText().toString().indexOf("-",1)!=-1)
            return "-";
        if(currentOperation.getText().toString().contains("×"))
            return "×";
        if(currentOperation.getText().toString().contains("÷"))
            return "÷";
        return "";
    }

    boolean hasDecimal(String str){
        if(str.contains("."))
            return true;
        else
            return false;
    }

}