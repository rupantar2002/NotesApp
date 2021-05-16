package com.example.notesapp.DataModels;

public class Note {

    private String mTitle;
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

}
