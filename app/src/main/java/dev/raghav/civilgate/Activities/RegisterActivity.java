package dev.raghav.civilgate.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import dev.raghav.civilgate.Parsingfiles.LoginReg.RegisPars_responce;
import dev.raghav.civilgate.R;
import dev.raghav.civilgate.Api.Api;

import dev.raghav.civilgate.Api.RetrofitClientApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
     EditText email , password , passing_year , ful_name , mobile,address ;
     Spinner type;
     Api  apiInterface;
     int a;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
//         a=10;
//        Toast.makeText(this, "a value at oncreate is"+a, Toast.LENGTH_SHORT).show();
        getSupportActionBar().hide();
        apiInterface = RetrofitClientApi.getClient().create(Api.class);
        getitdone();


//        Log.d("init" , "workssdfsdf a"+a);
//        Intent intent  = new Intent(RegisterActivity.this , Main2Activity.class);
//        startActivity(intent);

    }

    private void getitdone() {
        Call<RegisPars_responce> regisPars_responceCall = apiInterface.Register_to_app("pro1" ,"82240984561" , "pjk@gmail1.com","1234561","20001","nojkt1","near everything1",null,null );
        regisPars_responceCall.enqueue(new Callback<RegisPars_responce>() {
            @Override
            public void onResponse(Call<RegisPars_responce> call, Response<RegisPars_responce> response) {
                Toast.makeText(RegisterActivity.this, ""+response.body().getResponce(), Toast.LENGTH_SHORT).show();
                Log.e("hey yory", "responce is"+response.body().getResponce());
            }

            @Override
            public void onFailure(Call<RegisPars_responce> call, Throwable t) {

            }
        });

    }

    private void init() {
//        this.a = a+10;
//        Log.d("init" , "works a"+a);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passing_year = findViewById(R.id.passout_year);
        ful_name = findViewById(R.id.ful_nam);
        mobile = findViewById(R.id.mobile);
        type = findViewById(R.id.type);
    }

}
