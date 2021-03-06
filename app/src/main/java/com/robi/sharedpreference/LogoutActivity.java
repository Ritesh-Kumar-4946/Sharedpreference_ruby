package com.robi.sharedpreference;

import com.rkt.login.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogoutActivity extends Activity implements OnClickListener {

	String str_getName, str_getPassword, str_getEmail, str_getMobile;

	TextView profile;

	Button logout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.logout);

		/*
		 * fetching the all data corresponding to each key from shared
		 * preference in order to show the user profile
		 */

		str_getName = SplashActivity.sh.getString("name", null);
		str_getPassword = SplashActivity.sh.getString("password", null);
		str_getEmail = SplashActivity.sh.getString("email", null);
		str_getMobile = SplashActivity.sh.getString("mobile", null);

		profile = (TextView) findViewById(R.id.txt_profile);
		logout = (Button) findViewById(R.id.logout);
		logout.setOnClickListener(this);

		/* set fetch data to textview, textview show the user complete profile */

		profile.setText("Name : " + str_getName + "\n" + "\n" + "Password : "
				+ str_getPassword + "\n" + "\n" + "Email : " + str_getEmail
				+ "\n" + "\n" + "Mobile : " + str_getMobile);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		/*
		 * logout button click does not delete the shared preference all data
		 * but it only delete the user login test key, you can do the login
		 * again with same credentials. In order to delete the complete data
		 * call editor.clear(); followed by editor.commit(); you can edit your
		 * complete profile by doing registration once again, it will overwrite
		 * your previous data.
		 */
		Toast.makeText(getApplicationContext(), "You have successfully logout",
				Toast.LENGTH_LONG).show();
		SplashActivity.editor.remove("loginTest");

		SplashActivity.editor.commit();

		Intent sendToLoginandRegistration = new Intent(getApplicationContext(),
				Login.class);

		startActivity(sendToLoginandRegistration);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(LogoutActivity.this,
					SplashActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("EXIT", true);
			startActivity(intent);
		}
		return super.onKeyDown(keyCode, event);
	}
}
