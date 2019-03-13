package dev.raghav.civilgate.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import dev.raghav.civilgate.R;

public class RegisterActivity extends AppCompatActivity {
     EditText email , password , passing_year , ful_name , mobile,address ;
     Spinner type;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();
        init();
//        Intent intent  = new Intent(RegisterActivity.this , Main2Activity.class);
//        startActivity(intent);

    }

    private void init() {
        Log.d("init" , "works");
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passing_year = findViewById(R.id.passout_year);
        ful_name = findViewById(R.id.ful_nam);
        mobile = findViewById(R.id.mobile);
        type = findViewById(R.id.type);
    }

}
