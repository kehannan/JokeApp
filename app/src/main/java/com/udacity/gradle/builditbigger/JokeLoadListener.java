package com.udacity.gradle.builditbigger;

/**
 * Created by khannan on 1/23/16.
 * Interface that requires implementers to handle
 * the completion of the Async task that pulls the joke
 * from GCE
 */
public interface JokeLoadListener {

    void downloadCompleted(String result);
}
