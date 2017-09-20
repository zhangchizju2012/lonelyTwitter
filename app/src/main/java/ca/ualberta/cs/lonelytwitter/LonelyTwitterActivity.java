package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	// By default, the array adapter creates a view by calling toString() on each data object in the collection you provide, and places the result in a TextView.

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				tweets.add(new NormalTweet(text));
				adapter.notifyDataSetChanged();
				// Notifies the attached observers that the underlying data has been changed and any View reflecting the data set should refresh itself.
				// updating the listview by calling notifydatasetchanged()!

				saveInFile();

//				Tweet newTweet = new NormalTweet("Hello");
//				ImportantTweet newTweet2 = new ImportantTweet("Hello2",new Date());
//
//				newTweet2.getDate();
//
//				try{
//					newTweet.setMessage("Goodbye");
//				} catch (TweetTooLongException e){
//
//				}
//				Log.d("TWEET",newTweet.getMessage());
//
//				ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
//				tweetList.add(newTweet);
//				tweetList.add(newTweet2);
//				for (Tweet t: tweetList){
//
//					Log.d("Some Tag", "The isImportant method on this object returns " + t.isImportant());
//				}

				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
//		String[] tweets = loadFromFile();
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			// Taken from https://github.com/google/gson/blob/master/UserGuide.md#TOC-Collections-Examples 2017-09-19
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					MODE_APPEND);
			// https://developer.android.com/reference/android/content/Context.html
			// MODE_APPEND File creation mode: for use with openFileOutput(String, int), if the file already exists then write data to the end of the existing file instead of erasing it.
			// MODE_PRIVATE File creation mode: the default mode, where the created file can only be accessed by the calling application (or all applications sharing the same user ID).
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets, writer);
			writer.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
//	private String[] loadFromFile() {
//		ArrayList<String> tweets = new ArrayList<String>();
//		try {
//			FileInputStream fis = openFileInput(FILENAME);
//			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//			String line = in.readLine();
//			while (line != null) {
//				tweets.add(line);
//				line = in.readLine();
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return tweets.toArray(new String[tweets.size()]);
//	}
//
//	private void saveInFile(String text, Date date) {
//		try {
//			FileOutputStream fos = openFileOutput(FILENAME,
//					Context.MODE_APPEND);
//			fos.write(new String(date.toString() + " | " + text)
//					.getBytes());
//			fos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}