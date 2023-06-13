package com.me;

import android.os.Bundle;

import com.oneapp.R;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class XyActivity extends Activity {
	Button btback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_xy);
		btback = (Button) findViewById(R.id.btback);
	}

	public void backset(View v) {
		finish();

	}
}