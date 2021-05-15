package com.example.cosu_pra.DTO.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cosu_pra.R;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.chatlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        recyclerView.setAdapter(new ChatFragmentRecyclerViewAdapter());
        return rootView;
    }

    class ChatFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        //DB 연결
        //List <UserModel> userModels;
        //public ChatFragmentRecyclerViewAdapter(){
        // userModels = new ArrayList<>;
        //}
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatlist, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        private class CustomViewHolder extends RecyclerView.ViewHolder {
            public ImageView chatImage;
            public TextView chatName;
            public TextView chatContent;

            public CustomViewHolder(View view) {
                super(view);
                chatImage = view.findViewById(R.id.chatImg);
                chatName = view.findViewById(R.id.chatname);
                chatContent = view.findViewById(R.id.chatContent);
            }
        }
    }

}