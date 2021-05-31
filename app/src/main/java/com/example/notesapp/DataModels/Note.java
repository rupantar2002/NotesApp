package com.example.notesapp.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "title")
    private String mTitle;
    @ColumnInfo(name = "content")
    private String mContent;

    public Note(String mTitle, String mContent) {
        this.mTitle = mTitle;
        this.mContent = mContent;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
