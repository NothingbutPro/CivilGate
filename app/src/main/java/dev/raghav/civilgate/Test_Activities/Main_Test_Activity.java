package dev.raghav.civilgate.Test_Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
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
import dev.raghav.civilgate.Test_Activities.Test_Types.Fill_In_Que_Test;
import dev.raghav.civilgate.Test_Activities.Test_Types.Multiple_Que_Test;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main_Test_Activity extends AppCompatActivity {
        Questions_Adapter questions_adapter;
        public static int queposition =0;
        RecyclerView quelinrecy;
        static int no_of_questions;
        Toolbar toolbar_col;
        public static LinkedList<Questions_jJava> questionsJJavaLinkedList = new LinkedList<>();
        String student_id;

    List<Questions_jJava> questions_jJavaList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        toolbar_col = findViewById(R.id.toolbar_col);
//        setSupportActionBar(toolbar_col);
        //setContentView(R.layout.activity_main__test_);
        setContentView(R.layout.activity_main_test_collpase);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        student_id = getIntent().getStringExtra("sub_id");
        Toast.makeText(this, "student naME IS"+student_id, Toast.LENGTH_SHORT).show();
        quelinrecy = findViewById(R.id.gridlay);

        GridLayoutManager manager = new GridLayoutManager(this, 9, GridLayoutManager.VERTICAL, false);
        quelinrecy.setLayoutManager(manager);
      //  quelinrecy.setAdapter(new SampleAdapter(getCurrentActivity()));
//        quelinrecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
//        quelinrecy.setHasFixedSize(true);
//        quelinrecy.setHasFixedSize(true);
    //     set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),5, LinearLayoutManager.HORIZONTAL,false);
//        quelinrecy.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
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
                String whatque = response.body().getData().get(0).getQue();
                for (int k=0;k<no_of_questions;k++)
                {
                    questions_jJavaList.add(new Questions_jJava(Integer.valueOf(response.body().getData().get(k).getId() ),response.body().getData().get(k).getType()));
//
//
                  // questions_jJavaList.add(new Questions_jJava(questions_jJavaList.get(k).getId() ,questions_jJavaList.get(k).getType()));
                   Log.e("no of questiobn",""+questions_jJavaList.get(k).getType());

                    if(response.body().getData().get(k).getType() == 1 )
                    {
                        questionsJJavaLinkedList.add(new Questions_jJava(response.body().getData().get(k).getId(),response.body().getData().get(k).getSubId()
                                ,response.body().getData().get(k).getMinusmark() ,response.body().getData().get(k).getMarks(),response.body().getData().get(k).getSolution(),
                                response.body().getData().get(k).getStatus() ,response.body().getData().get(k).getCreatedate() ,response.body().getData().get(k).getVideo()
                                ,response.body().getData().get(k).getQue(),response.body().getData().get(k).getAns1(),response.body().getData().get(k).getAns2(),response.body().getData().get(k).getAns3()
                                ,response.body().getData().get(k).getAns4(),response.body().getData().get(k).getAns(),response.body().getData().get(k).getVideoUrl()));
                    }else{
                        questionsJJavaLinkedList.add(new Questions_jJava(response.body().getData().get(k).getId(),response.body().getData().get(k).getSubId() ,
                                response.body().getData().get(k).getMarks() ,response.body().getData().get(k).getMarks(),response.body().getData().get(k).getSolution(),
                                response.body().getData().get(k).getStatus() ,response.body().getData().get(k).getCreatedate() ,response.body().getData().get(k).getVideo()
                                ,response.body().getData().get(k).getQue(),response.body().getData().get(k).getVideoUrl()));
                    }
                }
                questions_adapter = new Questions_Adapter(Main_Test_Activity.this, questions_jJavaList);
//                quelinrecy.setHasFixedSize(true);
                   quelinrecy.setAdapter(questions_adapter); // set the Adapter to RecyclerView
                //getAllQuestions(student_id);
            //    questions_adapter = new Questions_Adapter(Main_Test_Activity.this ,questions_jJavaList);
                Log.e("no of questiobn","jsdajksd "+questionsJJavaLinkedList.get(0).getType());
               if(questions_jJavaList.get(0).getType() == 1)
               {

                   FragmentManager fragmentManager = getSupportFragmentManager();
                   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   fragmentTransaction.replace(R.id.container_dik , new Multiple_Que_Test()).commit();

               }else{
                   FragmentManager fragmentManager = getSupportFragmentManager();
                   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   fragmentTransaction.replace(R.id.container_dik , new Fill_In_Que_Test()).commit();
               }
                //quelinrecy.setAdapter(questions_adapter);

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
                case R.id.navigation_forward:
//                    if()
                    int next = ++queposition ;
                    if(questions_jJavaList.get(next).getType() == 1)
                    {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_dik , new Multiple_Que_Test()).commit();
                    }else{
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_dik , new Fill_In_Que_Test()).commit();
                    }
              //      mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_save:
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_back:
                    int back = --queposition ;
                    if(questions_jJavaList.get(back).getType() == 1)
                    {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_dik , new Multiple_Que_Test()).commit();
                    }else{
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_dik , new Fill_In_Que_Test()).commit();
                    }
   //                 mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



}
