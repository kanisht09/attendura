package com.example.attendura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Input_Activity extends AppCompatActivity {
    EditText mNameEt, mAgeEt;

    Button mSaveBtn, mInfoBtn;
    TextView mInfoTv;
    SharedPreferences sharedPreferances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_);

        mNameEt = findViewById(R.id.nameEt);
        mAgeEt = findViewById(R.id.ageEt);
        mSaveBtn = findViewById(R.id.saveBtn);
        mInfoBtn = findViewById(R.id.showBtn);
        mInfoTv = findViewById(R.id.infoTv);

        sharedPreferances = getSharedPreferences( "SP_NAME", MODE_PRIVATE);
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int name = Integer.parseInt(mNameEt.getText().toString().trim());
                int age = Integer.parseInt(mAgeEt.getText().toString().trim());

                SharedPreferences.Editor editor = sharedPreferances.edit();
                editor.putInt("NAME", name);
                editor.putInt("AGE", age);

                editor.apply();
            }
        });

        mInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int name = sharedPreferances.getInt( "NAME", 0);
                int age = sharedPreferances.getInt("AGE", 0);

                mInfoTv.setText("First Roll No:" + name + "\t \t \t \t \t \t \t \t \t \t \t Last Roll No: " + age );
            }


        });


    }
}


