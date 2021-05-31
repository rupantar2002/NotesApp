package com.example.notesapp.Fragments.NotesViewer;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notesapp.DataModels.Note;
import com.example.notesapp.Fragments.AddAndUpdateNote.CreateNote;
import com.example.notesapp.ViewModels.NotesViewModel;
import com.example.notesapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotesViewer extends Fragment implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionButton;
    private NotesAdapter mNotesAdapter;
    private NotesViewModel mNotesViewModel;
    private Context mContext;


    public NotesViewer() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notes_viewer, container, false);

        mFloatingActionButton=view.findViewById(R.id.floatingActionButton_add_notes);
        mRecyclerView=view.findViewById(R.id.recyclerView_notes);

        mNotesViewModel= ViewModelProviders.of(this)
                .get(NotesViewModel.class);

        mContext=getContext();
        mNotesAdapter=new NotesAdapter();
        mNotesAdapter.setOnRecyclerItemClickListener(mOnRecyclerItemClickListener);
        mFloatingActionButton.setOnClickListener(this);


        populateRecyclerView();


        return view;
    }

    private void populateRecyclerView(){
        mNotesViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                mNotesAdapter.setNotes(notes);
                mRecyclerView.setAdapter(mNotesAdapter);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.floatingActionButton_add_notes){
            Toast.makeText(mContext, " Button clicked", Toast.LENGTH_SHORT).show();
            launchAddNoteFragment();
        }
    }

    private OnRecyclerItemClickListener mOnRecyclerItemClickListener=new OnRecyclerItemClickListener() {
        @Override
        public void onClick(Note note) {
            Toast.makeText(mContext, " Clicked " + note.getTitle() +"\n"+note.getContent(), Toast.LENGTH_SHORT).show();
        }
    };

    private void launchAddNoteFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new CreateNote())
                .addToBackStack(null)
                .commit();
    }


}