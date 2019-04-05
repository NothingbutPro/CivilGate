package dev.raghav.civilgate.Test_Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dev.raghav.civilgate.Api.Api;
import dev.raghav.civilgate.Const_Files.Questions_jJava;
import dev.raghav.civilgate.Const_Files.Retro_Urls;
import dev.raghav.civilgate.Other_Parsing_Files.Exam_Test;
import dev.raghav.civilgate.Other_Parsing_Files.Test_Question;
import dev.raghav.civilgate.Parsingfiles.LoginReg.Login_Responce;
import dev.raghav.civilgate.R;
import dev.raghav.civilgate.Test_Activities.Dapter.Questions_Adapter;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main_Test_Activity extends AppCompatActivity {
        Questions_Adapter questions_adapter;
        RecyclerView quelinrecy;
        static int no_of_questions;
        Toolbar toolbar_col;
        String student_id;

    List<Questions_jJava> questions_jJavaList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar_col = findViewById(R.id.toolbar_col);
        setSupportActionBar(toolbar_col);
        setContentView(R.layout.activity_main__test_);
        student_id = getIntent().getStringExtra("sub_id");
        quelinrecy = findViewById(R.id.gridlay);

        GridLayoutManager manager = new GridLayoutManager(this, 9, GridLayoutManager.VERTICAL, false);
        quelinrecy.setLayoutManager(manager);
      //  quelinrecy.setAdapter(new SampleAdapter(getCurrentActivity()));
//        quelinrecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
//        quelinrecy.setHasFixedSize(true);
//        quelinrecy.setHasFixedSize(true);
    //     set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),5, LinearLayoutManager.HORIZONTAL,false);
    //    quelinrecy.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
     //     call the constructor of CustomAdapter to send the reference and data to Adapter

//        Log.e("jhsadsa" , ""+main_test_activity.student_id);
        
        getAllQuestions(student_id);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void getAllQuestions(String student_id) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(300,TimeUnit.SECONDS).writeTimeout(100, TimeUnit.SECONDS).build();
        Retrofit QueRetrofit = new Retrofit.Builder().client(client)
                .baseUrl(Retro_Urls.The_Base).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api QueApi = QueRetrofit.create(Api.class);
        Call<Test_Question> testQuestionCall = QueApi.GetQuestion(student_id);
        testQuestionCall.enqueue(new Callback<Test_Question>() {
            @Override
            public void onResponse(Call<Test_Question> call, Response<Test_Question> response) {
                no_of_questions = response.body().getData().size();
                for (int k=0;k<no_of_questions;k++)
                {
                 //   questions_jJavaList.add(new Questions_jJava(Integer.valueOf(response.body().getData().get(k).getId())));
                    questions_jJavaList.add(new Questions_jJava(1));
                    Log.e("no of questiobn",""+questions_jJavaList.get(k).getId());
                }
                questions_adapter = new Questions_Adapter(Main_Test_Activity.this, questions_jJavaList);
                quelinrecy.setHasFixedSize(true);
                //   quelinrecy.setAdapter(questions_adapter); // set the Adapter to RecyclerView
                //getAllQuestions(student_id);
            //    questions_adapter = new Questions_Adapter(Main_Test_Activity.this ,questions_jJavaList);
                Log.e("no of questiobn","jsdajksd");
                quelinrecy.setAdapter(questions_adapter);
            }

            @Override
            public void onFailure(Call<Test_Question> call, Throwable t) {
                getAllQuestions( student_id);
                Log.d("cause" , ""+t.getCause());
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
              //      mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
   //                 mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



}
