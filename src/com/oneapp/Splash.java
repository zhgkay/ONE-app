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
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// 隐藏状态栏
		getActionBar().hide();// 隐藏标题栏
		setContentView(R.layout.activity_splash);
		imgeview = (ImageView) findViewById(id.imageView1);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
		imgeview.startAnimation(animation);
		Thread myThread = new Thread() {// 创建子线程
			@Override
			public void run() {
				try {
					sleep(3000);// 使程序休眠五秒
					Intent it = new Intent(getApplicationContext(), MainActivity.class);// 启动MainActivity
					startActivity(it);
					finish();// 关闭当前活动
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		myThread.start();// 启动线程

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
