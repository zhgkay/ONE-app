package com.oneapp;

import android.os.Bundle;

import com.me.SetActivity;
import com.oneapp.R.id;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	// 底部导航栏的参数
	RadioButton rabutn_one;
	RadioGroup radiogroup;
	// 三个界面的参数
	private Fragment1 fragment1 = null;
	private Fragment2 fragment2 = null;
	private Fragment3 fragment3 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 让状态栏不显示
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		radiogroup = (RadioGroup) findViewById(id.tabs_rg);
		radiogroup.setOnCheckedChangeListener(this);
		rabutn_one = (RadioButton) findViewById(id.one);
		rabutn_one.setChecked(true);

		ActionBar actionBar = getActionBar();
		if (actionBar != null) {
			actionBar.hide();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// 显示三个Fragment 的方法
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO 自动生成的方法存根
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		hideFragments(transaction);
		switch (checkedId) {
		case R.id.one:
			if (fragment1 == null) {
				fragment1 = new Fragment1();
				transaction.add(R.id.ly_contetn, fragment1);
			} else {
				transaction.show(fragment1);
			}

			break;
		case id.all:
			if (fragment2 == null) {
				fragment2 = new Fragment2();
				transaction.add(R.id.ly_contetn, fragment2);
			} else {
				transaction.show(fragment2);
			}

			break;
		case id.me:
			if (fragment3 == null) {
				fragment3 = new Fragment3();
				transaction.add(R.id.ly_contetn, fragment3);
			} else {
				transaction.show(fragment3);
			}

			break;

		}
		transaction.commit();

	}

	// 隐藏三个Fragment 的方法
	private void hideFragments(FragmentTransaction transaction) {
		if (fragment1 != null) {
			transaction.hide(fragment1);
		}
		if (fragment2 != null) {
			transaction.hide(fragment2);
		}
		if (fragment3 != null) {
			transaction.hide(fragment3);
		}
	}

	// 打开登录的界面
	public void Login(View view) {
		Intent intent = new Intent(this, LoginMainActivity.class);
		startActivity(intent);
	}

	// 打开注册的界面
	public void Register(View view) {
		Intent intent = new Intent(this, RegisteredMainActivity.class);
		startActivity(intent);
	}

	// 打开设置的方法
	public void Setting(View view) {
		Intent intent = new Intent(this, SetActivity.class);
		startActivity(intent);
	}

}
