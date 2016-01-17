package com.khannan;

import java.util.ArrayList;

public class Jokes {

    private ArrayList<Joke> mJokeList = new ArrayList<Joke>();
    private int pointer = 0;

    public Jokes() {
        mJokeList.add(new Joke(
                "Q: Why did the chicken cross the road? \n " +
                        "A: to get to the other side."));
        mJokeList.add(new Joke(
                "Q: What did the monk say to the hotdog vendor? \n " +
                        "A: Make me one with everything."));
        mJokeList.add(new Joke(
                "Q: What is black and blue and red all over? \n " +
                        "A: A newspaper."));
    }

    public Jokes(ArrayList<Joke> jokeList) {
        mJokeList = jokeList;
    }

    public Joke getNextJoke() {

        if (pointer > mJokeList.size() - 1) {
            pointer = 0;
        }
        Joke joke = mJokeList.get(pointer);
        pointer++;
        return joke;
    }
}