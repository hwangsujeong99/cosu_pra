package com.example.cosu_pra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cosu_pra.DTO.ProjectPost;
import com.example.cosu_pra.DTO.fragment.ChatFragment;
import com.example.cosu_pra.DTO.fragment.MyinfoFramgnet;
import com.example.cosu_pra.DTO.fragment.ProjectFragment;
import com.example.cosu_pra.DTO.fragment.QnAFragment;
import com.example.cosu_pra.DTO.fragment.StudyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;

import static com.example.cosu_pra.R.id.project_recruit;

public class MainActivity extends AppCompatActivity {
    HelpPosting helpPost;
    Map<String, ProjectPost> posts;
    ProjectFragment projectFragment;
    StudyFragment studyFragment;
    QnAFragment qaFragment;
    ChatFragment chatFragment;
    MyinfoFramgnet myinfoFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.project_recruit, new ProjectFragment()).commit();
        projectFragment = new ProjectFragment();
        studyFragment = new StudyFragment();
        qaFragment = new QnAFragment();
        chatFragment = new ChatFragment();
        myinfoFragment = new MyinfoFramgnet();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.project_recruit:
                                getSupportFragmentManager().beginTransaction().replace(R.id.project_recruit, projectFragment).commit();
                                return true;
                            case R.id.study_recruit:
                                getSupportFragmentManager().beginTransaction().replace(R.id.study_recruit, studyFragment).commit();
                                return true;
                            case R.id.qna:
                                getSupportFragmentManager().beginTransaction().replace(R.id.qna, qaFragment).commit();
                                return true;
                            case R.id.chat:
                                getSupportFragmentManager().beginTransaction().replace(R.id.chat, chatFragment).commit();
                                return true;
                            case R.id.mypage:
                                getSupportFragmentManager().beginTransaction().replace(R.id.mypage, myinfoFragment).commit();
                                return true;

                        }
                        return false;
                    }


                });

    }

    Testing testing = new Testing();

}


