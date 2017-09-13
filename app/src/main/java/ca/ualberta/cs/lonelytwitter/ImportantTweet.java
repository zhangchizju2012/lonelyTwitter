package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhangchi on 2017/9/12.
 */

public class ImportantTweet extends Tweet implements Tweetable{
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
