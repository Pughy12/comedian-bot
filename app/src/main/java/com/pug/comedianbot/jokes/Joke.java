package com.pug.comedianbot.jokes;

/**
 * Created by Mike on 02/08/2016.
 */
public class Joke {

    @SuppressWarnings("unused")
    private String setup;
    @SuppressWarnings("unused")
    private String punchline;

    @SuppressWarnings("unused")
    private Joke() {
        // Default constructor required for calls to DataSnapshot.getValue(Joke.class)
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                '}';
    }
}
