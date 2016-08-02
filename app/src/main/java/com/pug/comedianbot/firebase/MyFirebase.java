package com.pug.comedianbot.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pug.comedianbot.jokes.Joke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 02/08/2016.
 */
public class MyFirebase {

    private static final FirebaseDatabase DATABASE = FirebaseDatabase.getInstance();

    private static final DatabaseReference JOKES = DATABASE.getReference("jokes");

    private static final List<Joke> JOKES_LIST = new ArrayList<>();

    /**
     * Initialise jokes from firebase db
     */
    static {
        JOKES.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("onDataChange for jokes called, updating list of jokes");

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    final Joke joke = snapshot.getValue(Joke.class);
                    JOKES_LIST.add(joke);
                }

                System.out.println(String.format("There are (now) %s items in the jokes list",
                        JOKES_LIST.size()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("onCancelled: " + databaseError.getMessage());
            }
        });
    }

    public static List<Joke> getJokesList() {
        return JOKES_LIST;
    }
}
