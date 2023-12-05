package com.example.a2080601184_phanhoanganh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {
    int dt = 0, dcc=0, lgbt=0;
    Candidate item;
    private CandidateAdapter adapter;
    private RecyclerView recyclerView;
    List<Candidate> candidateList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        candidateList = Candidate.LayDSItem();

        adapter = new CandidateAdapter(candidateList, new CandidateAdapter.OnVoteClickListener() {
            @Override
            public void onVoteClick(int position, String type) {
                Candidate candidate = candidateList.get(position);
                switch (type) {
                    case "Độc Thân":
                        dt++;
                        break;
                    case "Đã Có Chủ":
                        dcc++;
                        break;
                    case "LGBT":
                        lgbt++;
                        break;
                }
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(adapter);
    }

}