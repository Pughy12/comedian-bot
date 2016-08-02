package com.pug.comedianbot.jokes;

/**
 * Created by Mike on 02/08/2016.
 */
public class Joke {

    private int id;
    private String jokeSetup;
    private String jokePunchline;

    public Joke(int id, String jokeSetup, String jokePunchline) {
        this.id = id;
        this.jokeSetup = jokeSetup;
        this.jokePunchline = jokePunchline;
    }

    public int getId() {
        return id;
    }

    public String getSetup() {
        return jokeSetup;
    }

    public String getPunchline() {
        return jokePunchline;
    }
}
