package dev.raghav.civilgate.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

import dev.raghav.civilgate.Parsingfiles.LoginReg.RegisPars_responce;
import dev.raghav.civilgate.R;
import dev.raghav.civilgate.Api.Api;

import dev.raghav.civilgate.Api.RetrofitClientApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class RegisterActivity extends AppCompatActivity {
    private static final int PERMISSION_GATE_READ = 141;
    private static final int READ_REQUEST_CODE = 101;
    // private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = ;
    EditText email , password , passing_year , ful_name , mobile,address ;
     ImageView  gate_photo , gate_sign;
     Button reg_btn;
     View gv;
     Api  apiInterface;
     int a = 0;
    private static final int MY_PERMISSIONS_REQUESTS = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        gv = RegisterActivity.this.getApplicationContext();
        init();
//         a=10;
//        Toast.makeText(this, "a value at oncreate is"+a, Toast.LENGTH_SHORT).show();
        getSupportActionBar().hide();
        apiInterface = RetrofitClientApi.getClient().create(Api.class);
        checkforpermission();

        gate_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkforpermission())
                {
                    Toast.makeText(RegisterActivity.this, "all set", Toast.LENGTH_SHORT).show();
                    a=1;
                    opengoddamngallery();

                }else {
                 requestitback();
                }
            }
        });
        gate_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkforpermission())
                {
                    Toast.makeText(RegisterActivity.this, "all set", Toast.LENGTH_SHORT).show();
                    a=2;
                    opengoddamngallery();

                }else {
                    requestitback();
                }
            }
        });

    }

    private void opengoddamngallery() {

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.setType("image/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    private void requestitback() {

        ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PERMISSION_GATE_READ);
//        if (ContextCompat.(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            // Permission is not granted
//            checkforpermission();
//        }if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            // Permission is not granted
//            checkforpermission();
//        }
    }

    private boolean checkforpermission() {

        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
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
        gate_sign = findViewById(R.id.gate_sign);
        gate_photo = findViewById(R.id.gate_photo);
        reg_btn = findViewById(R.id.reg_btn);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_GATE_READ:
                if (grantResults.length > 0) {

                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (locationAccepted && cameraAccepted){
                        Snackbar.make(getWindow().getDecorView().getRootView(), "Permission Granted, Now you can access location data and camera.", Snackbar.LENGTH_LONG).show();

                    }

                    else {

                        Snackbar.make(getWindow().getDecorView().getRootView(), "Permission Denied, You cannot access location data and camera.", Snackbar.LENGTH_LONG).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE)) {
                                showMessageOKCancel("For Validation, We need to access photos (from sd card) of your phone please allow",
                                        (dialog, which) -> {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE},
                                                        MY_PERMISSIONS_REQUESTS);
                                                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;


        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("We go somethihbygf", "Uri: " + uri.toString());
                Toast.makeText(this, "is "+uri, Toast.LENGTH_SHORT).show();
                showImage(uri);
            }
        }
    }

    private Bitmap showImage(Uri uri) {
        ParcelFileDescriptor parcelFileDescriptor =
                null;
        try {
            parcelFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        if(a==1)
        {
            gate_photo.setImageBitmap(image);
        }else{
            gate_sign.setImageBitmap(image);
            reg_btn.requestFocus();

        }

        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private void showMessageOKCancel(String s, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(RegisterActivity.this)
                .setMessage(s)
                .setPositiveButton("OK", onClickListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
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
