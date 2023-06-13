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
	// �ײ��������Ĳ���
	RadioButton rabutn_one;
	RadioGroup radiogroup;
	// ��������Ĳ���
	private Fragment1 fragment1 = null;
	private Fragment2 fragment2 = null;
	private Fragment3 fragment3 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ��״̬������ʾ
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

	// ��ʾ����Fragment �ķ���
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO �Զ����ɵķ������
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

	// ��������Fragment �ķ���
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

	// �򿪵�¼�Ľ���
	public void Login(View view) {
		Intent intent = new Intent(this, LoginMainActivity.class);
		startActivity(intent);
	}

	// ��ע��Ľ���
	public void Register(View view) {
		Intent intent = new Intent(this, RegisteredMainActivity.class);
		startActivity(intent);
	}

	// �����õķ���
	public void Setting(View view) {
		Intent intent = new Intent(this, SetActivity.class);
		startActivity(intent);
	}

}
