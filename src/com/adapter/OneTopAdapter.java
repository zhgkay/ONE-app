package com.adapter;

import java.util.List;

import com.adapter.MyAdapter.ViewHolder;
import com.loopj.android.image.SmartImageView;
import com.oneapp.R;
import com.oneapp.R.id;
import com.oneapp.R.layout;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import xxx.yc.Model;

public class OneTopAdapter extends BaseAdapter{
	//��������
		private List<Model> list=null;//����Ҫչʾ������Դ
		private Context context=null;//�����Ķ���

	public OneTopAdapter() {
			super();
		}

	public OneTopAdapter(List<Model> list, Context context) {
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder it=null;
		try {
			if (convertView==null) {
				//û�о��Զ���xml�ļ�  ������ͼ
				convertView=LayoutInflater.from(context).inflate(R.layout.toplist,parent,false);
				it=new ViewHolder();
				//����ͼ�ϵĿؼ����Ը�ֵ
				it.image=(SmartImageView) convertView.findViewById(R.id.img_url);
				it.title=(TextView) convertView.findViewById(R.id.title);
				it.pic_info=(TextView) convertView.findViewById(R.id.pic_info);
				it.forward=(TextView) convertView.findViewById(R.id.forward);
				it.words_info=(TextView) convertView.findViewById(R.id.words_info);
				it.volume=(TextView) convertView.findViewById(R.id.volume);
				convertView.setTag(it);
			}else {
				it=(ViewHolder) convertView.getTag();
			}
			//����TextView��ʾ�����ݣ��Ӷ�̬�����л�ȡ���沿��
			
			it.image.setImageUrl(list.get(position).getIndex().getImg_url());
			it.title.setText(list.get(position).getIndex().getTitle());
			it.pic_info.setText(list.get(position).getIndex().getPic_info());
			it.forward.setText(list.get(position).getIndex().getForward());
			it.words_info.setText(list.get(position).getIndex().getWords_info());
			it.volume.setText(list.get(position).getIndex().getVolume());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertView;
	}
	public class ViewHolder{
		public SmartImageView image;
		public TextView title;
		public TextView pic_info;
		public TextView forward;
		public TextView words_info;
		public TextView volume;
	}
}
