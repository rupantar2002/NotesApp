package com.example.notesapp.RoomPrecistance;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notesapp.DataModels.Note;

import java.util.List;

@Dao
public interface NotesDao {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM notes_table ")
    void deleteALL();

    @Query("SELECT * FROM notes_table")
    LiveData<List<Note>> getAllNotes();

}
