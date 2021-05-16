package com.example.notesapp.NotesActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.notesapp.Fragments.NotesScheduler;
import com.example.notesapp.Fragments.NotesViewer;
import com.example.notesapp.Fragments.Profile;
import com.example.notesapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotesActivity extends AppCompatActivity {

    private static final String TAG = "NotesActivity";

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        launchDefaultFragment();
        mBottomNavigationView.setOnNavigationItemSelectedListener(mListener);



    }

    private BottomNavigationView.OnNavigationItemSelectedListener mListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFrag=null;
            switch (item.getItemId()){
                case R.id.menuItem_notes:
                    selectedFrag=new NotesViewer();
                    break;
                case R.id.menuItem_schedule:
                    selectedFrag=new NotesScheduler();
                    break;
                case R.id.menuItem_profile:
                    selectedFrag=new Profile();
                    break;

            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,selectedFrag)
                    .commit();
            return false;
        }
    };

        private void launchDefaultFragment () {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new NotesViewer())
                    .commit();
        }
    }