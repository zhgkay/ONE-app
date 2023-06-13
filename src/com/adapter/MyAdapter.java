package com.adapter;

import java.util.List;

import com.adapter.OneTopAdapter.ViewHolder;
import com.loopj.android.image.SmartImageView;
import com.oneapp.Fragment1;
import com.oneapp.R;
import com.oneapp.R.id;
import com.oneapp.R.layout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import xxx.yc.Model;

public class MyAdapter extends BaseAdapter {
	// 属性设置
	private List<Model> list = null;// 储存要展示的数据源
	private Context context = null;// 上下文对象

	public MyAdapter(List<Model> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO 自动生成的方法存根
		if (position == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		int type = getItemViewType(position);
		if (type == 0) {
			ViewHode it = null;
			if (convertView == null) {
				// 没有就自定义xml文件 创建视图
				convertView = LayoutInflater.from(context).inflate(R.layout.toplist, parent, false);
				it = new ViewHode();
				// 给视图上的控件属性赋值
				it.image = (SmartImageView) convertView.findViewById(R.id.img_url);
				it.title = (TextView) convertView.findViewById(R.id.title);
				it.pic_info = (TextView) convertView.findViewById(R.id.pic_info);
				it.forward = (TextView) convertView.findViewById(R.id.forward);
				it.words_info = (TextView) convertView.findViewById(R.id.words_info);
				it.volume = (TextView) convertView.findViewById(R.id.volume);
				convertView.setTag(it);
			} else {
				it = (ViewHode) convertView.getTag();
			}
			// 设置TextView显示的内容，从动态数组中获取上面部分

			it.image.setImageUrl(list.get(position).getIndex().getImg_url());
			it.title.setText(list.get(position).getIndex().getTitle());
			it.pic_info.setText(list.get(position).getIndex().getPic_info());
			it.forward.setText(list.get(position).getIndex().getForward());
			it.words_info.setText(list.get(position).getIndex().getWords_info());
			it.volume.setText(list.get(position).getIndex().getVolume());

		} else {

			ViewHolder it = null;
			// 复用机制 判断是否有可用的视图
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(R.layout.listview, parent, false);
				it = new ViewHolder();
				// 给视图上的控件属性赋值
				it.story = (TextView) convertView.findViewById(R.id.tag_list);
				it.title1 = (TextView) convertView.findViewById(R.id.title1);
				it.desc = (TextView) convertView.findViewById(R.id.desc);
				it.image1 = (SmartImageView) convertView.findViewById(R.id.img_url1);
				it.music_name = (TextView) convertView.findViewById(R.id.music_name);
				it.audio_author = (TextView) convertView.findViewById(R.id.audio_author);
				it.audio_album = (TextView) convertView.findViewById(R.id.audio_album);
				it.content = (TextView) convertView.findViewById(R.id.content);
				it.post_tade = (TextView) convertView.findViewById(R.id.post_date);
				it.textDate = (TextView) convertView.findViewById(R.id.textDate);

				convertView.setTag(it);
			} else {
				it = (ViewHolder) convertView.getTag();
			}

			// 设置TextView显示的内容，从动态数组中获取中间部分
			it.story.setText(list.get(position).getMiddle().getTag_list());
			it.title1.setText(list.get(position).getMiddle().getTitle());
			it.desc.setText(list.get(position).getMiddle().getDesc());
			it.image1.setImageUrl(list.get(position).getMiddle().getImg_url());
			it.music_name.setText(list.get(position).getMiddle().getMusic_name());
			it.audio_author.setText(list.get(position).getMiddle().getAudio_author());
			it.audio_album.setText(list.get(position).getMiddle().getAudio_album());
			it.content.setText(list.get(position).getMiddle().getForward());
			it.post_tade.setText(list.get(position).getMiddle().getPost_date());
			it.textDate.setText(list.get(position).getMiddle().getSubtitle());
		}
		return convertView;
	}

	public class ViewHolder {
		public TextView story;
		public TextView title1;
		public TextView desc;
		public SmartImageView image1;
		public TextView music_name;
		public TextView audio_author;
		public TextView audio_album;
		public TextView content;
		public TextView post_tade;
		public TextView textDate;
	}

	public class ViewHode {
		public SmartImageView image;
		public TextView title;
		public TextView pic_info;
		public TextView forward;
		public TextView words_info;
		public TextView volume;
	}

}
