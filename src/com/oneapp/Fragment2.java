package com.oneapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import xxx.zk.AllBottom;
import xxx.zk.AllMiddle;
import xxx.zk.AllTest;

import com.adapter.AllMiddleAdapter;
import com.adapter.MyAdapter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment2 extends Fragment {
	// 声明一个集合对象
	static ArrayList<AllTest> allList = new ArrayList<AllTest>();
	ListView lv_allcen;
	// 消息机制
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				// 配置器负责数据的摆放 需要引用xml文件
				AllMiddleAdapter adapter = new AllMiddleAdapter(allList, getActivity());
				lv_allcen.setAdapter(adapter);
			}
		}
	};

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.all_fragment, container, false);
		lv_allcen = (ListView) view.findViewById(R.id.lv_allcen);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		new Thread() {
			public void run() {
				try {
					getDataByRequest1();
				} catch (MalformedURLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}.start();
	}

	// json解析
	public void getDataByRequest1() throws MalformedURLException, IOException {
		URL url = new URL(
				"http://v3.wufazhuce.com:8000/api/banner/list/4?last_id=0&channel=oppo&sign=b97f7c100d47c6494ff20a48e6413c39&version=4.5.9&uuid=&platform=android");
		// 打开连接对象
		URLConnection connection = url.openConnection();
		// io输入流
		// 字节流
		InputStream inputStream = connection.getInputStream();
		// 字符流
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		// 缓冲区
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		// 接收整体数据
		String dataString = "";
		// 分段接收数据
		String linString = null;
		// 循环
		while ((linString = bufferedReader.readLine()) != null) {
			dataString += linString;
		}
		inputStream.close();
		inputStreamReader.close();
		bufferedReader.close();
		HashMap hash = JSON.parseObject(dataString, HashMap.class);
		JSONArray data = (JSONArray) hash.get("data");
		ArrayList<AllMiddle> allmi = new ArrayList<AllMiddle>();
		for (Object all : data) {
			JSONObject jsonall = (JSONObject) all;
			AllMiddle allString = new AllMiddle(jsonall.getString("cover"), jsonall.getString("title"));
			allmi.add(allString);
		}
		AllTest allTest = new AllTest();
		allTest.setAllMiddle(allmi);
		allList.add(allTest);
		System.out.println(allTest);
		Message message = new Message();
		if (allList.size() != 0) {
			message.what = 1;
			message.obj = allList;
			handler.sendMessage(message);
		}
	}

}
