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
import java.util.List;

import com.adapter.MyAdapter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oneapp.R.id;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import xxx.yc.Index;
import xxx.yc.Middle;
import xxx.yc.Model;
import xxx.zk.AllBottom;
import xxx.zk.AllMiddle;
import xxx.zk.AllTest;

public class Fragment1 extends Fragment {
	static ArrayList<Model> arrayModel = new ArrayList<Model>();
	static ArrayList<AllTest> allList = new ArrayList<AllTest>();
	ListView listView;
	TextView date, year, city;

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				// �������������ݵİڷ� ��Ҫ����xml�ļ�
				MyAdapter adapter = new MyAdapter(arrayModel, getActivity());
				listView.setAdapter(adapter);
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������

		View view = inflater.inflate(R.layout.one_fragment, container, false);
		listView = (ListView) view.findViewById(id.one_list);
		date = (TextView) view.findViewById(id.date);
		year = (TextView) view.findViewById(id.year);
		city = (TextView) view.findViewById(id.city);
		return view;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onActivityCreated(savedInstanceState);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent();

				// ����ģ����Ϣ���±� �ж����õ�ģ��
				if (position > 0) {
					// ��ȡ�в���Ӧ������
					Model model = arrayModel.get(position);
					String url = model.getMiddle().getShare_url();
					intent.putExtra("url", url);
					// ����һ�����������ļ� forѭ������ ��Ӧ����в�Ԫ�� ����ͨ��getCount()������ȡ�в�Ԫ�صĸ���
					MyAdapter myAdapter = new MyAdapter(arrayModel, getActivity());
					for (int i = 0; i < myAdapter.getCount(); i++) {
						intent.setAction("android.intent.action.VIEW");
						// ����ȡ�Ķ������� ��Ӧ����Ӧitemģ����
						intent.setData(Uri.parse(url));
						startActivity(intent);
					}
				} else {
					Model modelTop = arrayModel.get(position);
					String urlTop = modelTop.getIndex().getShare_url();
					intent.putExtra("urlTop", urlTop);
					// MyAdapter myAdapterTop=new MyAdapter(arrayModel, getApplicationContext());
					intent.setAction("android.intent.action.VIEW");
					intent.setData(Uri.parse(urlTop));
					startActivity(intent);
				}

			}
		});
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);

		new Thread() {
			public void run() {

				try {
					getDataByRequest();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// getDataByRequest1();
			}
		}.start();

	}

	public void getDataByRequest() throws MalformedURLException, IOException {

		URL url = new URL(
				"http://v3.wufazhuce.com:8000/api/channel/one/0/0?channel=oppo&sign=1546a9f3da357af8e0ef39a7dc2586a0&version=4.5.9&uuid=&platform=android");
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
		// System.out.println("---------"+dataString);
		// 1.���ַ���ת��Ϊ ��������
		HashMap hashMap = JSON.parseObject(dataString, HashMap.class);
		// 2.������㻨����
		JSONObject json = (JSONObject) hashMap.get("data");
		// 3.��������Ϣ
		JSONArray arr = (JSONArray) json.get("content_list");
		Middle middle = null;
		Index in = null;

		for (Object tag : arr) {
			JSONObject tagjson = (JSONObject) tag;
			// ȡ������Ϣ
			in = new Index(json.getString("weather"), json.getString("date"), tagjson.getString("title"),
					tagjson.getString("forward"), tagjson.getString("img_url"), tagjson.getString("volume"),
					tagjson.getString("pic_info"), tagjson.getString("words_info"), tagjson.getString("share_url"));
			break;
		}
		for (Object object : arr) {
			JSONObject ora = (JSONObject) object;
			JSONObject arrtag = (JSONObject) ora.get("share_list");
			JSONObject tit = (JSONObject) arrtag.get("wx");
			String titl = tit.getString("title");
			JSONObject author = (JSONObject) ora.get("author");
			String user_name = author.getString("user_name");
			middle = new Middle(titl, ora.getString("title"), user_name, ora.getString("img_url"),
					ora.getString("music_name"), ora.getString("audio_author"), ora.getString("audio_album"),
					ora.getString("forward"), ora.getString("subtitle"), ora.getString("post_date"),
					ora.getString("share_url"));
			/*
			 * //4.����������Ƭ JSONObject share=(JSONObject) ora.get("image"); HashMap<String,
			 * String> imgHashMap=new HashMap<String, String>(); //ѭ������img_url�еļ�ֵ��Ϣ for
			 * (String key:share.keySet()){ String value=share.getString(key);
			 * imgHashMap.put(key, value); }
			 */

			Model mod = new Model();
			mod.setIndex(in);
			mod.setMiddle(middle);
			// System.out.println(mod);

			arrayModel.add(mod);

			Message message = new Message();
			if (arrayModel.size() != 0) {
				message.what = 1;
				message.obj = arrayModel;
				handler.sendMessage(message);

			}

		}
		// arrayModel.remove(0);

	}

	public static void getDataByRequest1() throws MalformedURLException, IOException {
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
		// System.out.println(dataString);

	}

	public static ArrayList<AllBottom> getDataByRequest2() throws MalformedURLException, IOException {
		URL url = new URL(
				"http://v3.wufazhuce.com:8000/api/author/hot?channel=oppo&sign=1546a9f3da357af8e0ef39a7dc2586a0&version=4.5.9&uuid=&platform=android");
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
		// System.out.println(dataString);
		HashMap bottall = JSON.parseObject(dataString, HashMap.class);

		JSONArray bottData = (JSONArray) bottall.get("data");
		ArrayList<AllBottom> allbo = new ArrayList<AllBottom>();
		for (Object bott : bottData) {
			JSONObject bottContent = (JSONObject) bott;
			AllBottom bottString = new AllBottom(bottContent.getString("web_url"), bottContent.getString("user_name"),
					bottContent.getString("desc"));
			// System.out.println(bottString);
			allbo.add(bottString);

		}
		// System.out.println(allbo);
		return allbo;
	}

}
