package com.example.zpa_prevodteploty;

import android.view.View;
import android.view.inputmethod.EditorBoundsInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class Prevod implements View.OnClickListener {
    private EditText et_first;
    private EditText et_second;
    private RadioButton rb_first;
    private RadioButton rb_second;

    private Switch sw_unit;

    public Prevod(EditText et_first, EditText et_second, RadioButton rb_first, RadioButton rb_second, Switch sw_unit){
        this.et_first = et_first;
        this.et_second = et_second;
        this.rb_first = rb_first;
        this.rb_second = rb_second;
        this.sw_unit = sw_unit;
    }

    @Override
    public void onClick(View v) {
        if(!sw_unit.isChecked()){
            if (rb_first.isChecked()){
                double celsius = Double.parseDouble(et_first.getText().toString());
                double fahrenheit = (celsius * 9/5) + 32;
                et_second.setText(String.valueOf(fahrenheit));
            } else if (rb_second.isChecked()) {
                double fahrenheit = Double.parseDouble(et_first.getText().toString());
                double celsius = (fahrenheit - 32) * 5/9;
                et_second.setText(String.valueOf(celsius));
            }
        }else{
            if (rb_first.isChecked()){
                double miles = Double.parseDouble(et_first.getText().toString());
                double kilometers = miles * 0.621371;
                et_second.setText(String.valueOf(kilometers));
            } else if (rb_second.isChecked()) {
                double  kilometers = Double.parseDouble(et_first.getText().toString());
                double  miles = kilometers * 1.60934;
                et_second.setText(String.valueOf(miles));
            }

        }

    }
}
