package com.oneapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;

import com.oneapp.R.color;
import com.oneapp.R.id;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginMainActivity extends Activity implements TextWatcher {
	TextView usertext;
	EditText passtext;
	Button login_but;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_main);
		usertext = (TextView) findViewById(id.userText);
		passtext = (EditText) findViewById(id.passText);
		login_but = (Button) findViewById(id.login_butt);
		passtext.addTextChangedListener(this);
		usertext.addTextChangedListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_main, menu);
		return true;
	}

	// 返回的方法
	public void ReturnLogin(View view) {
		finish();

	}

	// 登录
	public void Login(View view) {
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		String user = sp.getString("user", "");
		String password = sp.getString("password", "");
		if ((usertext.getText().toString().equals(user)) && (passtext.getText().toString().equals(password))) {
			Intent intent = new Intent(this, UserActivity.class);
			startActivity(intent);
		} else {
			Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();

		}

	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO 自动生成的方法存根
		if (usertext.length() > 0 && passtext.length() > 0) {
			login_but.setBackgroundColor(Color.parseColor("#2c2c2c"));
			login_but.setEnabled(true);

		} else {
			login_but.setBackgroundColor(Color.parseColor("#707070"));
			login_but.setEnabled(false);

		}

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO 自动生成的方法存根

	}

}
