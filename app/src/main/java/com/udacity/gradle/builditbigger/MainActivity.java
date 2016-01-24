package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import kevin.com.android_joke_lib.JokeActivity;
import kevin.com.android_joke_lib.JokeActivityFragment;


public class MainActivity extends AppCompatActivity implements JokeLoadListener {

    public static final String SENT_TOKEN_TO_SERVER = "sentToken";
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Button clicks calls tellJoke method, which creates
    // the joke getter class and calls the method to get
    // the joke.
    public void tellJoke(View view){

        new AsyncJokeGetter(this).getJoke();
    }

    // The AsyncJokeGetter class requires the calling class
    // to implement the method that handles the returning joke.
    // This method takes the joke and passes it to JokeActivity
    // as an intent.
    @Override
    public void downloadCompleted(String result) {

        Intent intent = new Intent(this, JokeActivity.class);
        Log.v(LOG_TAG, "result " + result);
        intent.putExtra(JokeActivity.JOKE_KEY, result);
        startActivity(intent);

    }
}
