package com.oneapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.oneapp.R.color;
import com.oneapp.R.id;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisteredMainActivity extends Activity implements TextWatcher {
	TextView usertext;// �˺�
	EditText passtext;// ����
	Button re_but;// ��¼

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// ȡ������״̬��
		setContentView(R.layout.registered_main);
		usertext = (TextView) findViewById(id.userText);
		passtext = (EditText) findViewById(id.passText);
		re_but = (Button) findViewById(id.re_butt);
		// Ϊ�����ͱ༭����Ӽ���¼�
		passtext.addTextChangedListener(this);
		usertext.addTextChangedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registered_main, menu);
		return true;
	}

	// ���صķ���
	public void ReturnRegister(View view) {
		finish();
	}

	// ע��ķ���
	public void Reg(View view) {
		SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
		Editor editor = sharedPreferences.edit();
		editor.putString("user", usertext.getText().toString());
		editor.putString("password", passtext.getText().toString());
		editor.commit();
		Toast.makeText(this, "ע��ɹ�", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, LoginMainActivity.class);
		startActivity(intent);

	}

	// �����ͱ༭��ļ���¼�
	@Override
	public void afterTextChanged(Editable s) {
		// TODO �Զ����ɵķ������
		// ��� ������˺ź����볤�ȴ���0�õ�¼��ť��ɺ�ɫ��ʾ�����ɫ��ʾ�����ɵ��
		if (usertext.length() > 0 && passtext.length() > 0) {
			re_but.setBackgroundColor(Color.parseColor("#2c2c2c"));
			re_but.setEnabled(true);

		} else {
			re_but.setBackgroundColor(Color.parseColor("#707070"));
			re_but.setEnabled(false);

		}

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO �Զ����ɵķ������

	}

}
