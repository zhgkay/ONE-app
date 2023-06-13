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
	// ����һ�����϶���
	static ArrayList<AllTest> allList = new ArrayList<AllTest>();
	ListView lv_allcen;
	// ��Ϣ����
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				// �������������ݵİڷ� ��Ҫ����xml�ļ�
				AllMiddleAdapter adapter = new AllMiddleAdapter(allList, getActivity());
				lv_allcen.setAdapter(adapter);
			}
		}
	};

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		View view = inflater.inflate(R.layout.all_fragment, container, false);
		lv_allcen = (ListView) view.findViewById(R.id.lv_allcen);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		new Thread() {
			public void run() {
				try {
					getDataByRequest1();
				} catch (MalformedURLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}.start();
	}

	// json����
	public void getDataByRequest1() throws MalformedURLException, IOException {
		URL url = new URL(
				"http://v3.wufazhuce.com:8000/api/banner/list/4?last_id=0&channel=oppo&sign=b97f7c100d47c6494ff20a48e6413c39&version=4.5.9&uuid=&platform=android");
		// �����Ӷ���
		URLConnection connection = url.openConnection();
		// io������
		// �ֽ���
		InputStream inputStream = connection.getInputStream();
		// �ַ���
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		// ������
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		// ������������
		String dataString = "";
		// �ֶν�������
		String linString = null;
		// ѭ��
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
