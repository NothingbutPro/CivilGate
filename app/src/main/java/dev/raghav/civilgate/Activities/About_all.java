package dev.raghav.civilgate.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import dev.raghav.civilgate.Api.Api;
import dev.raghav.civilgate.Const_Files.Retro_Urls;
import dev.raghav.civilgate.Other_Parsing_Files.Get_level;
import dev.raghav.civilgate.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class About_all extends AppCompatActivity {
    ProgressDialog Aboutusdialog;
    TextView about_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_all);
        Aboutusdialog = new ProgressDialog(this);
        Aboutusdialog.show();
        about_web = findViewById(R.id.about_web);
        Retrofit RetroLogin = new Retrofit.Builder()
                .baseUrl(Retro_Urls.The_Base).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api AbloutApi = RetroLogin.create(Api.class);
        Call<Get_level> Get_levelCall = AbloutApi.getLevelCall();
        Get_levelCall.enqueue(new Callback<Get_level>() {
            @Override
            public void onResponse(Call<Get_level> call, Response<Get_level> response) {
                Aboutusdialog.dismiss();
                if(response.isSuccessful())
                {
                    Toast.makeText(About_all.this, ""+response.body().getData().getDescription(), Toast.LENGTH_SHORT).show();
                    Log.d("responce is" , ""+response.body().getData().getDescription());
//                    about_web.loadData(response.body().getData().getDescription() , "text/html" , "UTF-8");

                    about_web.setText(Html.fromHtml(response.body().getData().getDescription()));
                }else {
                    Toast.makeText(About_all.this, ""+response.body().getData().getDescription(), Toast.LENGTH_SHORT).show();
                    Log.d("responce is" , ""+response.body().getData().getDescription());
                }

            }

            @Override
            public void onFailure(Call<Get_level> call, Throwable t) {

            }
        });

    }
}
