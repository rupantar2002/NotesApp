package com.example.notesapp.Fragments.NotesViewer;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.DataModels.Note;
import com.example.notesapp.R;

import java.util.List;

public class NotesViewHolder extends RecyclerView.ViewHolder {
    private TextView mTitle;
    private TextView mContent;

    private Note mNote;
    private OnRecyclerItemClickListener mOnRecyclerItemClickListener;

    public NotesViewHolder(@NonNull View itemView ) {
        super(itemView);

        mContent=itemView.findViewById(R.id.item_content);
        mTitle=itemView.findViewById(R.id.item_title);

        itemView.setOnClickListener(mOnClickListener);
    }

    public TextView getTitle() {
        return mTitle;
    }

    public TextView getContent() {
        return mContent;
    }

    public void setNote(Note mNote) {
        this.mNote = mNote;
    }
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener mOnRecyclerItemClickListener) {
        this.mOnRecyclerItemClickListener = mOnRecyclerItemClickListener;
    }


    private View.OnClickListener mOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos=getAdapterPosition();
            if(mOnRecyclerItemClickListener!=null && pos!=RecyclerView.NO_POSITION ){
                mOnRecyclerItemClickListener.onClick(mNote);
            }
        }
    };

}
