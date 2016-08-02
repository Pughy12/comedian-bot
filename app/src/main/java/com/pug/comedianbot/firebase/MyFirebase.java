package com.pug.comedianbot.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 02/08/2016.
 */
public class MyFirebase {

    private static final FirebaseDatabase DATABASE = FirebaseDatabase.getInstance();

    private static final DatabaseReference JOKES = DATABASE.getReference("jokes");

    static {
        JOKES.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("onDataChange: " + dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("onCancelled: " + databaseError.getMessage());
            }
        });
    }

    public static List<String> getJokeSetups() {
        return new ArrayList<>();
    }

    public static List<String> getJokePunchlines() {
        return new ArrayList<>();
    }
}
