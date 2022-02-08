package com.example.operations;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Components

    //TextViews
    TextView inp1;
    TextView inp2;
    TextView result;

    //RadioButtons
    RadioButton rba;
    RadioButton rbs;
    RadioButton rbm;
    RadioButton rbd;

    //Switch
    Switch sw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiation of Text Views
        inp1 = findViewById(R.id.inpt1);
        inp2 = findViewById(R.id.inpt2);
        result = findViewById(R.id.result);

        //Initiation of Radio Buttons
        rba = findViewById(R.id.rba);
        rbs = findViewById(R.id.rbs);
        rbm = findViewById(R.id.rbm);
        rbd = findViewById(R.id.rbd);

        sw = findViewById(R.id.sw);

    }

    public void operate(View view) {
        int value = checkRadioButtons();
        float[] nums = getValues();
        float res = 0;
        String answ;

        switch (value) {
            case 0:
                Toast.makeText(getApplicationContext(),"No operation selected", Toast.LENGTH_LONG).show();
                break;
            case 1:
                res = add(nums);
                break;
            case 2:
                res = subtract(nums);
                break;
            case 3:
                res = multiply(nums);
                break;
            case 4:
                res = divide(nums);
        }

        if (sw.isChecked()) {
            answ = ""+(int)res;
        }
        else {
            answ = ""+res;
        }

        result.setText(answ);
    }

    public float[] getValues() {
        return new float[]{Float.parseFloat(inp1.getText().toString()), Float.parseFloat(inp2.getText().toString())};
    }


    public int checkRadioButtons() {
        if (rba.isChecked()) {
            return 1;
        }
        else if (rbs.isChecked()) {
            return 2;
        }
        else if (rbm.isChecked()) {
            return 3;
        }
        else if (rbd.isChecked()) {
            return 4;
        }
        else {
            return 0;
        }

    }

    public float add(float[] nums) {
        return nums[0]+nums[1];
    }

    public float subtract(float[] nums) {
        return nums[0]-nums[1];
    }

    public float multiply(float[] nums) {
        return nums[0]*nums[1];
    }

    public float divide(float[] nums) {
        if(nums[1] > 0) {
            return nums[0]/nums[1];
        }
        Toast.makeText(getApplicationContext(),"Can't divide by zero", Toast.LENGTH_LONG).show();
        return -1;
    }
}