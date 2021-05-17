package com.example.notesapp.MVVM;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notesapp.DataModels.Note;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    private NotesRepository mNotesRepository;

    private LiveData<List<Note>> mAllNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        mNotesRepository = new NotesRepository(application);
        mAllNotes = mNotesRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return mAllNotes;
    }

    public void insert(Note note){ mNotesRepository.insert(note);}
    public void update(Note note){mNotesRepository.update(note);}
    public void delete(Note note){mNotesRepository.delete(note);}
    public void deleteAll(){mNotesRepository.deleteAll();}
}
