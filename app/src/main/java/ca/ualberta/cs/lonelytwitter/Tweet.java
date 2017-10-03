/*
 *
 * Copyright (c) 2017 Chi Zhang CMPUT301 University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a tweet
 * @author zhangchi
 * @see ImportantTweet
 * @see NormalTweet
 * @version 1.5
 * Created by zhangchi on 2017/9/12.
 */

public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;

    /**
     * construct a Tweet object
     *
     * @param message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }else{
            this.message = message;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
