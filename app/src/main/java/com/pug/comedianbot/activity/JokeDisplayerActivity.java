package com.pug.comedianbot.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.pug.comedianbot.R;
import com.pug.comedianbot.firebase.MyFirebase;
import com.pug.comedianbot.jokes.Joke;
import com.pug.comedianbot.jokes.JokeGenerator;

public class JokeDisplayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button generateJokeButton = (Button) findViewById(R.id.generateJokeButton);
        final TextView jokeSetup = (TextView) findViewById(R.id.jokeSetup);
        final TextView jokePunchline = (TextView) findViewById(R.id.jokePunchline);

        generateJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Joke joke = JokeGenerator.getRandomOneLiner();
                jokeSetup.setText(joke.getSetup());
                jokePunchline.setText(joke.getPunchline());
            }
        });

        jokePunchline.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.joke_sound);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                        mediaPlayer.release();
                    }
                });

                // Play the sound
                mp.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_joke_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
