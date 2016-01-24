package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
//
   public class ApplicationTest extends AndroidTestCase implements JokeLoadListener {


    AsyncJokeGetter asyncJokeGetter;
    CountDownLatch signal;

    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);
        asyncJokeGetter = new AsyncJokeGetter(this);
    }

    public void testJoke() throws InterruptedException {
        asyncJokeGetter.getJoke();
        signal.await(30, TimeUnit.SECONDS);
    }

    @Override
    public void downloadCompleted(String result) {

        assertTrue("joke was null", result !=null);
    }

}