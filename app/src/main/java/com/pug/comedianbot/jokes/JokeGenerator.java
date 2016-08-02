package com.pug.comedianbot.jokes;

import com.pug.comedianbot.firebase.MyFirebase;

import java.util.List;
import java.util.Random;

/**
 * Generates jokes using setups and punchlines and even makes some that don't make any sense
 */
public class JokeGenerator {

    /** A set of joke setups */
    private static List<String> SETUPS = MyFirebase.getJokeSetups();

    /** A set of joke punchlines */
    private static List<String> PUNCHLINES = MyFirebase.getJokePunchlines();

    /** A random randomiser */
    private static final Random RANDOM = new Random();

    /**
     * Creates a joke using a setup and a punchline from the arrays above
     *
     * @return A Joke object with the necessary parts to tell a hilarious joke
     */
    public static Joke getRandomOneLiner() {
        final int randomInt = RANDOM.nextInt(PUNCHLINES.size());
        return new Joke(SETUPS.get(randomInt), PUNCHLINES.get(randomInt));
    }

    /**
     * Get a random number between the ranges provided
     *
     * @param min The lowest number of the range
     * @param max The highest number in the range
     *
     * @return A random integer from the range
     */
    private static int randInt(int min, int max) {
        return RANDOM.nextInt((max - min)) + min;
    }

}
