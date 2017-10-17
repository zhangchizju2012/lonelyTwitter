/*
 * Copyright (c) 2017 Chi Zhang CMPUT301 University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by zhangchi on 2017/10/10.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    // add tweet to a list of tweets
    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }

    // delete tweet from a list of tweets
    public void deleteTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    // check if a list of tweets has the specified tweet
    // if it dose, return true, otherwise false
    public boolean hasTweet(Tweet tweet){
        //return Boolean.FALSE;
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }
}
