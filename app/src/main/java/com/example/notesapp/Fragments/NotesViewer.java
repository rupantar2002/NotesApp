package com.example.notesapp.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notesapp.DataModels.Note;
import com.example.notesapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NotesViewer extends Fragment {

    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionButton;
    private NotesAdapter notesAdapter;
    private List<Note> list;


    public NotesViewer() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notes_viewer, container, false);

        mFloatingActionButton=view.findViewById(R.id.floatingActionButton_add_notes);
        mRecyclerView=view.findViewById(R.id.recyclerView_notes);

        Context context=getActivity().getApplication();

        notesAdapter=new NotesAdapter();
        list=new ArrayList<>();
        setList();
        notesAdapter.setNotes(list);
        mRecyclerView.setAdapter(notesAdapter);


        return view;
    }

    private void setList(){

        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfn"
        +"ibfniifnbifnbifnbfinbfbnfibbfnbjbfnibnfibfibnfibibfbifnbifnbifbn fibifb"+
                "fuivbifviffibfibfibnfibnfibnfibnfibnifbnifbnifnbifnbifnb"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfninvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvknvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvknvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnv"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkffnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfninvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvknvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvknvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnv"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkffnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfninvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvknvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvknvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnv"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkffnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfisvbnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnnvn"));
        list.add(new Note("MY title","bvdbdvbdivbvfvfknvkfnvfkvnkfnvkfnvkfnvkfnvkfnvkfvkfnvfnknvinvkisvbnvn"));

    }
}