package com.example.notesapp.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.notesapp.DataModels.Note;
import com.example.notesapp.RoomPrecistance.NotesDao;
import com.example.notesapp.RoomPrecistance.NotesDatabase;

import java.util.List;

public class NotesRepository {

    private NotesDao mNotesDao;
    private LiveData<List<Note>> mAllNotes;

    public NotesRepository(Application application) {
        NotesDatabase db=NotesDatabase.getDatabase(application);

        this.mNotesDao = db.NoteDao();
        this.mAllNotes = mNotesDao.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return mAllNotes;
    }

    public void insert(Note note){ new InsertNoteAsyncTask(mNotesDao).execute(note);}
    public void update(Note note){new UpdateNoteAsyncTask(mNotesDao).execute(note);}
    public void delete(Note note){new DeleteNoteAsyncTask(mNotesDao).execute(note);}
    public void deleteAll(){new DeleteAllNoteAsyncTask(mNotesDao).execute();}

    //Implementation
    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void> {

        private NotesDao mNoteDao;

        public InsertNoteAsyncTask(NotesDao mNoteDao) {
            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insert(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void> {

        private NotesDao mNoteDao;

        public DeleteNoteAsyncTask(NotesDao mNoteDao) {
            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.delete(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void> {

        private NotesDao mNoteDao;

        public UpdateNoteAsyncTask(NotesDao mNoteDao) {
            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.update(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void,Void,Void> {

        private NotesDao mNoteDao;

        public DeleteAllNoteAsyncTask(NotesDao mNoteDao) {
            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mNoteDao.deleteALL();
            return null;
        }
    }
}
