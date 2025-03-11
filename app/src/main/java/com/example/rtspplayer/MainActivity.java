package com.example.rtspplayertv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StreamAdapter adapter;
    private List<String> streamUrls = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StreamAdapter(streamUrls, this::playStream);
        recyclerView.setAdapter(adapter);

        // Тестові RTSP посилання (можеш замінити на свої)
        streamUrls.add("rtsp://192.168.1.100:554/stream");
        streamUrls.add("rtsp://192.168.1.101:8554/live");

        adapter.notifyDataSetChanged();
    }

    private void playStream(String url) {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("stream_url", url);
        startActivity(intent);
    }
}
