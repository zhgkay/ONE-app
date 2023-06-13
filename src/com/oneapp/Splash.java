package com.oneapp;

import android.os.Bundle;

import com.oneapp.R.id;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends Activity {
	ImageView imgeview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// ����״̬��
		getActionBar().hide();// ���ر�����
		setContentView(R.layout.activity_splash);
		imgeview = (ImageView) findViewById(id.imageView1);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
		imgeview.startAnimation(animation);
		Thread myThread = new Thread() {// �������߳�
			@Override
			public void run() {
				try {
					sleep(3000);// ʹ������������
					Intent it = new Intent(getApplicationContext(), MainActivity.class);// ����MainActivity
					startActivity(it);
					finish();// �رյ�ǰ�
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		myThread.start();// �����߳�

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
