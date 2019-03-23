package dev.raghav.civilgate.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.raghav.civilgate.Api.Api;
import dev.raghav.civilgate.Const_Files.Retro_Urls;
import dev.raghav.civilgate.Parsingfiles.LoginReg.Login_Credential;
import dev.raghav.civilgate.Parsingfiles.LoginReg.Login_Responce;
import dev.raghav.civilgate.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity  extends AppCompatActivity {
    TextView NewRegister;
    Button Btn_Signin;
    EditText emailfx , passwordtxt;
    AlertDialog.Builder  builder;
    final String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    private int MY_PERMISSIONS_REQUESTS = 141;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         builder = new AlertDialog.Builder(this);
       // getSupportActionBar().hide();
        emailfx = findViewById(R.id.emailfx);
        passwordtxt = findViewById(R.id.passwordtxt);
        NewRegister=findViewById(R.id.new_reg);
        Btn_Signin=findViewById(R.id.button_signin);

        checkforpermission();

        NewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

       Btn_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkvalidem())
                {
//                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                    startActivity(intent);
                    Retrofit RetroLogin = new Retrofit.Builder()
                .baseUrl(Retro_Urls.The_Base).addConverterFactory(GsonConverterFactory.create())
                .build();
                    Api RegApi = RetroLogin.create(Api.class);
                    Call<Login_Responce> login_responceCall = RegApi.Login_that_dk(emailfx.getText().toString() , passwordtxt.getText().toString());
                    login_responceCall.enqueue(new Callback<Login_Responce>() {
                        @Override
                        public void onResponse(Call<Login_Responce> call, Response<Login_Responce> response) {
                            Log.d("string" , ""+response.body().getResponceString());
//                            if(!response.body().getResponceString().equals(false))
//                            {
                                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
//                            }else{
//                                Toast.makeText(LoginActivity.this, "Either Email is wrong or Password", Toast.LENGTH_SHORT).show();
//                            }

                        }

                        @Override
                        public void onFailure(Call<Login_Responce> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Network problem", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    Toast.makeText(LoginActivity.this, "Check Credential", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private boolean checkvalidem() {
        Boolean wth = false;
        if(emailfx.getText().toString().length() ==0 && passwordtxt.getText().toString().length() ==0)
        {

            return wth;
        }if(!emailfx.getText().toString().contains("@") && !emailfx.getText().toString().contains(".") && !emailfx.getText().toString().contains("com")&& passwordtxt.getText().toString().length() ==0)
        {
             emailfx.setError("Email is invalid");
             passwordtxt.setError("Password is too short");
            return wth;
        }
        if(passwordtxt.getText().toString().length() ==0)
        {
            passwordtxt.setError("Password is too short");
        }
        wth = true;
        return wth;
    }

    private void checkforpermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUESTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }else{
            Toast.makeText(this, "Permission all done", Toast.LENGTH_SHORT).show();
        }// Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "permission has been denied ", Toast.LENGTH_SHORT).show();

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUESTS);
                Toast.makeText(this, "permission has been denied ", Toast.LENGTH_SHORT).show();
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
        else {
            Toast.makeText(this, "Permission all done", Toast.LENGTH_SHORT).show();
            // Permission has already been granted
        }
//                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this, permissions, ALL_PERMISSIONS);
//            // Permission is not granted
//        }      if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, permissions, ALL_PERMISSIONS);
//            // Permission is not granted
//        }
    }


}
