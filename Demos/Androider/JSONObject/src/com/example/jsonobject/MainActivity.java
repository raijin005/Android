package com.example.jsonobject;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView JsonSrc = (TextView) findViewById(R.id.json_src);
		TextView JsonObject = (TextView) findViewById(R.id.json_object);
		TextView JsonResult = (TextView) findViewById(R.id.json_result);
		TextView JsonMyBlog = (TextView) findViewById(R.id.json_myblog);
		TextView JsonMyUrl = (TextView) findViewById(R.id.json_myurl);

		String json_source = getString(R.string.dummy_json);
		JsonSrc.setText(json_source);

		try {
			JSONObject jsonObject = new JSONObject(json_source);
			JSONObject results = jsonObject.getJSONObject("results");
			String myBlog = results.getString("myblog");
			String myUrl = results.getString("myurl");

			JsonObject.setText("\njsonObject:\n" + jsonObject.toString());
			JsonResult.setText("\nresults:\n" + results.toString());
			JsonMyBlog.setText("\nmyBlog:\n" + myBlog);
			JsonMyUrl.setText("\nmyUrl:\n" + myUrl);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(MainActivity.this, e.toString(),
					Toast.LENGTH_LONG).show();
		}
	}
}