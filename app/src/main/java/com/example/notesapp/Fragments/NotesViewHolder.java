package com.example.notesapp.Fragments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.R;

public class NotesViewHolder extends RecyclerView.ViewHolder {
    private TextView mTitle;
    private TextView mContent;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        mContent=itemView.findViewById(R.id.item_content);
        mTitle=itemView.findViewById(R.id.item_title);
    }

    public TextView getTitle() {
        return mTitle;
    }

    public TextView getContent() {
        return mContent;
    }
}
