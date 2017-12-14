package com.robi.sharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;

import com.rkt.login.R;

public class SplashActivity extends Activity {

	/*androidtutorialsrkt.blogspot.in/2014/12/sharedpreferences-example-in-android-in.html*/
	/*androidtutorialsrkt.blogspot.in/2014/12/sharedpreferences-example-in-android-in.html*/
	/*androidtutorialsrkt.blogspot.in/2014/12/sharedpreferences-example-in-android-in.html*/
	/*androidtutorialsrkt.blogspot.in/2014/12/sharedpreferences-example-in-android-in.html*/

	public static String str_login_test;

	public static SharedPreferences sh;
	public static Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splash);

		// here initializing the shared preference
		sh = getSharedPreferences("myprefe", 0);
		editor = sh.edit();

		// check here if user is login or not
		str_login_test = sh.getString("loginTest", null);

		if (getIntent().getBooleanExtra("EXIT", false)) {
			finish();
			return;
		}

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				/*
				 * if user login test is true on oncreate then redirect the user
				 * to result page
				 */

				if (str_login_test != null
						&& !str_login_test.toString().trim().equals("")) {
					Intent send = new Intent(getApplicationContext(),
							LogoutActivity.class);
					startActivity(send);
				}
				/*
				 * if user login test is false on oncreate then redirect the
				 * user to login & registration page
				 */
				else {

					Intent send = new Intent(getApplicationContext(),
							Login_and_Registration.class);
					startActivity(send);

				}
			}

		}, 3000);

	}

}