package com.pug.comedianbot.jokes;

import com.pug.comedianbot.firebase.MyFirebase;

import java.util.List;
import java.util.Random;

/**
 * Generates jokes using setups and punchlines and even makes some that don't make any sense
 */
public class JokeGenerator {

    private static final List<Joke> JOKES = MyFirebase.getJokesList();

    /**
     * Creates a joke using a setup and a punchline from the arrays above
     *
     * @return A Joke object with the necessary parts to tell a hilarious joke
     */
    public static Joke getRandomJoke() {
        final Random random = new Random();
        return JOKES.get(random.nextInt(JOKES.size()));
    }

}
