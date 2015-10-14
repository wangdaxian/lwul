package com.example.older.loginde;



import com.example.older_serv.R;
import com.example.older_serv.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class LoginLoad extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.login_load);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent intent = new Intent(LoginLoad.this, Index.class);

				Bundle extras = getIntent().getExtras();

				if (extras != null) {

					intent.putExtra("username", extras.getString("username"));

				}

				startActivity(intent);

				LoginLoad.this.finish();

				// Toast.makeText(getApplicationContext(), "µÇÂ¼³É¹¦",

				// Toast.LENGTH_SHORT).show();

			}

		}, 200);

	}

}