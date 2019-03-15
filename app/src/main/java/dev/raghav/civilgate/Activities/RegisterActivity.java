package dev.raghav.civilgate.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
   // private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = ;
    EditText email , password , passing_year , ful_name , mobile,address ;
     Spinner type;
     Api  apiInterface;
     int a;
    private static final int MY_PERMISSIONS_REQUESTS = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
//         a=10;
//        Toast.makeText(this, "a value at oncreate is"+a, Toast.LENGTH_SHORT).show();
        getSupportActionBar().hide();
        apiInterface = RetrofitClientApi.getClient().create(Api.class);
        checkforpermission();
      //  getitdone();


//        Log.d("init" , "workssdfsdf a"+a);
//        Intent intent  = new Intent(RegisterActivity.this , Main2Activity.class);
//        startActivity(intent);

    }

    private void checkforpermission() {

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
//            checkforpermission(0);
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
//            checkforpermission(0);
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
                checkforpermission();
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
        else {
            Toast.makeText(this, "Permission all done2", Toast.LENGTH_SHORT).show();
            // Permission has already been granted
        }

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
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String[] permissions, int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUESTS: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(this, "Permission is"+grantResults[0], Toast.LENGTH_SHORT).show();
//                    // permission was granted, yay! Do the
//                    // contacts-related task you need to do.
//                }
//                else
//                    {
//                    Toast.makeText(this, "Permission is"+grantResults[0], Toast.LENGTH_SHORT).show();
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//                return;
//            }
//
//            // other 'case' lines to check for other
//            // permissions this app might request.
//        }
//    }
}
