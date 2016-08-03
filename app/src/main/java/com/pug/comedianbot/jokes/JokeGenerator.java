package com.pug.comedianbot.jokes;

import com.pug.comedianbot.firebase.MyFirebase;

import java.util.List;
import java.util.Random;

/**
 * Generates jokes using setups and punchlines and even makes some that don't make any sense
 */
public class JokeGenerator {

    private static final List<Joke> JOKES = MyFirebase.getJokesList();

    private static final Random RANDOM = new Random();

    /**
     * Creates a joke using a setup and a punchline from the arrays above
     *
     * @return A Joke object with the necessary parts to tell a hilarious joke
     */
    public static Joke getRandomJoke() throws IllegalStateException {

        if (JOKES.size() < 1) {
            throw new IllegalStateException("I don't know why but there are no jokes, try again cos it'll probably work");
        }
        return JOKES.get(RANDOM.nextInt(JOKES.size()));
    }

}
