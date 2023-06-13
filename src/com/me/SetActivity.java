package com.me;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.oneapp.R;
import com.oneapp.R.id;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

public class SetActivity extends Activity implements OnClickListener {

	Button bt_clear;// 清除缓存
	Button bt_we;// 关于我们
	Button bt_tel;// 合作联系
	Button bt_sugg;// 意见和反馈
	Button bt_xy;// 用户协议
	Button bt_return;// 返回上页
	Switch switch1, switch2;

	AlertDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_set);
		init();
	}

	void init() {
		bt_clear = (Button) findViewById(R.id.bt_clear);
		bt_we = (Button) findViewById(R.id.bt_we);
		bt_tel = (Button) findViewById(R.id.bt_tel);
		bt_sugg = (Button) findViewById(R.id.bt_sugg);
		bt_xy = (Button) findViewById(R.id.bt_xy);
		bt_return = (Button) findViewById(id.bt_backMe);
		switch1 = (Switch) findViewById(id.switch1);
		switch2 = (Switch) findViewById(id.switch2);
		bt_clear.setOnClickListener(this);
		bt_xy.setOnClickListener(this);
		bt_we.setOnClickListener(this);
		bt_tel.setOnClickListener(this);
		bt_sugg.setOnClickListener(this);
		bt_return.setOnClickListener(this);
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO 自动生成的方法存根
				if (isChecked) {

				} else {

				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();

		switch (v.getId()) {
		case R.id.bt_clear:
			dialog = new AlertDialog.Builder(this).setTitle("").setMessage("确定要清除缓存？")
					.setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(SetActivity.this, "清除缓存成功", Toast.LENGTH_SHORT).show();

						}

					}).setNegativeButton("取消", null).create();
			dialog.show();

			break;
		case R.id.bt_we:
			intent.setAction("android.intent.action.VIEW");
			intent.setData(Uri.parse("https://m.weibo.cn/u/1766610575"));
			startActivity(intent);
			break;
		case R.id.bt_tel:
			Intent intent2 = new Intent(SetActivity.this, TelActivity.class);
			startActivity(intent2);
			break;
		case R.id.bt_sugg:

			break;
		case R.id.bt_xy:
			Intent intent3 = new Intent(SetActivity.this, XyActivity.class);
			startActivity(intent3);
			break;

		case R.id.bt_backMe:
			finish();

			break;
		}

	}

}