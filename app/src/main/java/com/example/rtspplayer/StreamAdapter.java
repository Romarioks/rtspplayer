package com.example.rtspplayertv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StreamAdapter extends RecyclerView.Adapter<StreamAdapter.ViewHolder> {
    private final List<String> streams;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String url);
    }

    public StreamAdapter(List<String> streams, OnItemClickListener listener) {
        this.streams = streams;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String stream = streams.get(position);
        holder.textView.setText(stream);
        holder.itemView.setOnClickListener(v -> listener.onItemClick(stream));
    }

    @Override
    public int getItemCount() {
        return streams.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
