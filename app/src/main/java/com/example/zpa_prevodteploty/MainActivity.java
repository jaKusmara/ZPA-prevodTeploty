package com.example.zpa_prevodteploty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_prevod;
    private EditText et_first;
    private EditText et_second;
    private RadioButton rb_first;
    private RadioButton rb_second;
    private RadioGroup radioGroup;
    private Switch sw_units;
    private ImageView img;
    private TextView tv_input;
    private TextView tv_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_prevod = findViewById(R.id.btn_prevod);
        et_first = findViewById(R.id.et_first);
        et_second = findViewById(R.id.et_second);
        rb_first = findViewById(R.id.rb_first);
        rb_second = findViewById(R.id.rb_second);
        radioGroup = findViewById(R.id.radioGroup);
        tv_input = findViewById(R.id.tv_input);
        tv_output = findViewById(R.id.tv_output);
        sw_units = findViewById(R.id.sw_units);
        img = findViewById(R.id.img);

        btn_prevod.setOnClickListener(new Prevod(et_first, et_second, rb_first, rb_second, sw_units));

        sw_units.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    if(radioGroup.getCheckedRadioButtonId() == R.id.rb_first){
                        tv_input.setText(R.string.tv_cels);
                        tv_output.setText(R.string.tv_farent);

                        et_first.setHint(R.string.et_celsius);
                    }else if(radioGroup.getCheckedRadioButtonId() == R.id.rb_second){
                        tv_input.setText(R.string.tv_farent);
                        tv_output.setText(R.string.tv_cels);

                        et_first.setHint(R.string.et_fahrendheit);
                    }

                    rb_first.setText(R.string.rb_CF);
                    rb_second.setText(R.string.rb_FC);
                    et_second.setText("");
                    img.setImageResource(R.drawable.teplomer);

                }else{
                    if(radioGroup.getCheckedRadioButtonId() == R.id.rb_first){
                        tv_input.setText(R.string.tv_km);
                        tv_output.setText(R.string.tv_mile);

                        et_first.setHint(R.string.et_km);
                    }else if(radioGroup.getCheckedRadioButtonId() == R.id.rb_second){
                        tv_input.setText(R.string.tv_mile);
                        tv_output.setText(R.string.tv_km);

                        et_first.setHint(R.string.et_mi);
                    }
                    rb_first.setText(R.string.rb_kmmi);
                    rb_second.setText(R.string.rb_mikm);
                    et_second.setText("");
                    img.setImageResource(R.drawable.meter);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(!sw_units.isChecked()){
                    if(radioGroup.getCheckedRadioButtonId() == R.id.rb_first){
                        tv_input.setText(R.string.tv_cels);
                        tv_output.setText(R.string.tv_farent);

                        et_first.setHint(R.string.et_celsius);
                    }else if(radioGroup.getCheckedRadioButtonId() == R.id.rb_second){
                        tv_input.setText(R.string.tv_farent);
                        tv_output.setText(R.string.tv_cels);

                        et_first.setHint(R.string.et_fahrendheit);
                    }
                }else{
                    if(radioGroup.getCheckedRadioButtonId() == R.id.rb_first){
                        tv_input.setText(R.string.tv_km);
                        tv_output.setText(R.string.tv_mile);

                        et_first.setHint(R.string.et_km);
                    }else if(radioGroup.getCheckedRadioButtonId() == R.id.rb_second){
                        tv_input.setText(R.string.tv_mile);
                        tv_output.setText(R.string.tv_km);

                        et_first.setHint(R.string.et_mi);
                    }
                }
            }
        });
    }
}