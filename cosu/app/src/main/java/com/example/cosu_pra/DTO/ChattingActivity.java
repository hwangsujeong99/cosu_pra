package com.example.cosu_pra.DTO;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cosu_pra.R;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {
    Spinner chatoutspinner;
    ArrayList<String> chatoutList;
    ArrayAdapter<String> chatoutAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        chatoutList = new ArrayList<>();
        chatoutList.add("채팅방 나가기");
        chatoutList.add("알림 끄기");

        chatoutAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, chatoutList);

        chatoutspinner = (Spinner)findViewById(R.id.chatroomspinner);
        chatoutspinner.setAdapter(chatoutAdapter);
        chatoutspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    //채팅방나가기
                }
                else {
                    //알림 끄기
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}