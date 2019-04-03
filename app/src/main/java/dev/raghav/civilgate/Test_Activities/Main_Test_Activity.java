package dev.raghav.civilgate.Test_Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import dev.raghav.civilgate.Api.Api;
import dev.raghav.civilgate.Const_Files.Retro_Urls;
import dev.raghav.civilgate.Other_Parsing_Files.Exam_Test;
import dev.raghav.civilgate.Other_Parsing_Files.Test_Question;
import dev.raghav.civilgate.Parsingfiles.LoginReg.Login_Responce;
import dev.raghav.civilgate.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main_Test_Activity extends AppCompatActivity {
        RecyclerView quelinrecy;
        String student_id;
        static int no_of_questions;
    private TextView mTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__test_);
        quelinrecy = findViewById(R.id.quelinrecy);
        student_id = getIntent().getStringExtra("sub_id");
        getAllQuestions(student_id);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void getAllQuestions(String student_id) {

        Retrofit QueRetrofit = new Retrofit.Builder()
                .baseUrl(Retro_Urls.The_Base).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api QueApi = QueRetrofit.create(Api.class);
        Call<Test_Question> testQuestionCall = QueApi.GetQuestion(student_id);
        testQuestionCall.enqueue(new Callback<Test_Question>() {
            @Override
            public void onResponse(Call<Test_Question> call, Response<Test_Question> response) {
                no_of_questions = response.body().getData().size();
                Log.e("no of questiobn",""+no_of_questions);
            }

            @Override
            public void onFailure(Call<Test_Question> call, Throwable t) {

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
