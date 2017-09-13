package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhangchi on 2017/9/12.
 */

public class NormalTweet extends Tweet implements Tweetable{
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return null;
    }
}
