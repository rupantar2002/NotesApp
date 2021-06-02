package com.example.notesapp.Fragments.AddAndUpdateNote;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.notesapp.DataModels.Note;
import com.example.notesapp.R;
import com.example.notesapp.ViewModels.NotesViewModel;

public class CreateNote extends Fragment {

    // UI
    private EditText mTitleEt, mContentEt;
    private Toolbar mToolbar;

    // Var
    private Context mContext;
    private NotesViewModel mNotesViewModel;
    private boolean isUpdate = false;
    private int mid = 0;


    public CreateNote() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_note, container, false);

        // UI Hocks
        mTitleEt = view.findViewById(R.id.title_editText);
        mContentEt = view.findViewById(R.id.content_editText);
        mToolbar = view.findViewById(R.id.toolbar_createNote);


        mContext = getContext();
        mNotesViewModel = ViewModelProviders.of(getActivity()).get(NotesViewModel.class);

        populateText();

        mToolbar.setNavigationOnClickListener(mOnClickListener);
        mToolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);


        return view;

    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, "back button clicked", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }
    };

    private final Toolbar.OnMenuItemClickListener mOnMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.btn_delete:
                    Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
                    deleteNote();
                    break;
                case R.id.btn_save:
                    saveNote();
                    Toast.makeText(mContext, "Save", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    };

    private void saveNote() {
        String title = mTitleEt.getText().toString().trim();
        String content = mContentEt.getText().toString().trim();
        Note note = new Note(title, content);
        if (isUpdate) {
            note.setId(mid);
            mNotesViewModel.update(note);
        } else {
            mNotesViewModel.insert(note);
        }

        getActivity().onBackPressed();
    }

    private void populateText() {
        Note note = mNotesViewModel.getSharedNote().getValue();
        if (note != null) {
            isUpdate = true;
            mid = note.getId();
            mTitleEt.setText(note.getTitle());
            mContentEt.setText(note.getContent());
        } else {
            mToolbar.getMenu().getItem(1).setVisible(false);
        }
        mNotesViewModel.setSharedNote(null);

    }

    private void deleteNote() {
        Note note = new Note(null, null);
        note.setId(mid);
        mNotesViewModel.delete(note);
        getActivity().onBackPressed();
    }


}