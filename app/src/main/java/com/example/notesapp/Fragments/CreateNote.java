package com.example.notesapp.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notesapp.DataModels.Note;
import com.example.notesapp.MVVM.NotesViewModel;
import com.example.notesapp.R;

public class CreateNote extends Fragment {

    private Context mContext;
    private EditText mTitleEt,mContentEt;
    private Button mSaveBtn;
    private NotesViewModel mNotesViewModel;


    public CreateNote() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create_note, container, false);

        mTitleEt=view.findViewById(R.id.title_editText);
        mContentEt=view.findViewById(R.id.content_editText);
        mSaveBtn=view.findViewById(R.id.save_btn);


        mContext=getContext();
        mNotesViewModel=ViewModelProviders.of(this).get(NotesViewModel.class);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=mTitleEt.getText().toString();
                String content=mContentEt.getText().toString();
                if(content.isEmpty() && title.isEmpty()){
                    Toast.makeText(mContext, " Can't Save empty data", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    mNotesViewModel.insert(new Note(title,content));
                }
                getActivity().onBackPressed();
            }
        });



        return view;

    }


}