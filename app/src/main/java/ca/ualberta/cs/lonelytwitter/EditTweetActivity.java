package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    TextView updateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        updateText = (TextView) findViewById(R.id.textView); // 必须在这里，挪到11行会报错
        String s = getIntent().getStringExtra("data");
        updateText.setText(s);
    }
}
