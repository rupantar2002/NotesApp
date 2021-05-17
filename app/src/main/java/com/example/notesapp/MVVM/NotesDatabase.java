package com.example.notesapp.MVVM;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.notesapp.DataModels.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    private static NotesDatabase INSTANCE;

    public abstract NotesDao NoteDao();

    public static synchronized NotesDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            // Create Database
            INSTANCE=Room.databaseBuilder(context.getApplicationContext(),
                    NotesDatabase.class,
                    "note_database")
                    // Wipes and rebuilds instead of migrating
                    // if no Migration object.
                    // Migration is not part of this practical.
                    .fallbackToDestructiveMigration()
//                    .addCallback(callback)
                    .build();
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback callback=new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDBAsyncTask(INSTANCE).execute();
        }
    };


    private static class PopulateDBAsyncTask extends AsyncTask<Void,Void,Void>{
        private NotesDao mNotesDao;

         final Note note=new Note("My Title","My Content");

        public PopulateDBAsyncTask(NotesDatabase db) {
            this.mNotesDao = db.NoteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mNotesDao.deleteALL(); // delete all notes in app destroy
            return null;
        }
    }

}
