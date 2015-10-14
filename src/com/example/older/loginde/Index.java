package com.example.older.loginde;



import com.example.older_serv.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Index extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.index);

		tv = (TextView) findViewById(R.id.username);

		/*
		 * 
		 * String str ="123"; Toast toast = null; toast =
		 * 
		 * Toast.makeText(getApplicationContext(), MD5.getMD5(str),
		 * 
		 * Toast.LENGTH_LONG); toast.setGravity(Gravity.CENTER, 0, 0);
		 * 
		 * LinearLayout view = (LinearLayout) toast.getView(); ImageView
		 * 
		 * imageView = new ImageView(getApplicationContext());
		 * 
		 * imageView.setImageResource(R.drawable.login_error_icon);
		 * 
		 * view.addView(imageView, 0); toast.show();
		 */

		Bundle extras = getIntent().getExtras();

		if (extras != null) {

			tv.setText("»¶Ó­Äú£º" + extras.getString("username"));

		}

	}

}