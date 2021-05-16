package com.example.notesapp.Fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.DataModels.Note;
import com.example.notesapp.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder>  {
    private List<Note> mNotes;

    public void setNotes(List<Note> mNotes) {
        this.mNotes = mNotes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle_notes,parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.getTitle().setText(mNotes.get(position).getTitle());
        holder.getContent().setText(mNotes.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }
}
