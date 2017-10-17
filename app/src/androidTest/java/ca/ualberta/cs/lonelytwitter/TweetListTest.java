/*
 * Copyright (c) 2017 Chi Zhang CMPUT301 University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by zhangchi on 2017/10/10.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        //assertTrue(Boolean.TRUE);
        TweetList tweets = new TweetList();
        Tweet myTweet = new NormalTweet("my tweet");
        tweets.addTweet(myTweet);
        assertTrue(tweets.hasTweet(myTweet));
    }

    public void testDeleteTweet(){
        //assertTrue(Boolean.TRUE);
        TweetList tweets = new TweetList();
        Tweet myTweet = new NormalTweet("my tweet");
        tweets.addTweet(myTweet);
        tweets.deleteTweet(myTweet);
        assertFalse(tweets.hasTweet(myTweet));
    }

    public void testHasTweet(){
        //assertTrue("testHasTweet has failed",Boolean.TRUE);
        TweetList tweets = new TweetList();
        Tweet myTweet = new NormalTweet("my tweet");
        assertFalse(tweets.hasTweet(myTweet));

        tweets.addTweet(myTweet);
        assertTrue(tweets.hasTweet(myTweet));
    }

    public void testGetTweet(){
        // getTweet method will take an index and will return the tweet at that index

        TweetList tweets = new TweetList();
        NormalTweet myTweet = new NormalTweet("my tweet");
        tweets.addTweet(myTweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),myTweet.getMessage());
        assertEquals(returnedTweet.getDate(),myTweet.getDate());
    }

}
