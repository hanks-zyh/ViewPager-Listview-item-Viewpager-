package com.zyh.listview_viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class View1 {
	public static final int VIEWTYPE_VIEWPAGER = 0;
	public static final int VIEWTYPE_TEXTVIEW = 1;
	 ListView listview;
	private Context mContext;
	private MyListviewAdapter adapter;
public View1(Context context) {
	init(context);
}
	public void init(Context context) {
		mContext = context;
		listview = new ListView(context);
		adapter = new MyListviewAdapter();
		listview.setAdapter(adapter);
	}

	class MyListviewAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 100;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if(position%3==0){
				//viewpager
				
				if(convertView==null){
					ChildView child = new ChildView();
					child.init(mContext);
					convertView = child.viewPager;
				}
				
				
			}else{
//				textview
				if(convertView==null){
					convertView = new TextView(mContext);
					
				}
				((TextView)convertView).setTextSize(25);;
				((TextView)convertView).setText("测试数据："+position);
			}
			System.out.println(convertView.toString());
			return convertView;
		}
		@Override
		public int getViewTypeCount() {
			return 2;
		}
		@Override
		public int getItemViewType(int position) {

			if (position % 3 == 0) {
				// viewpager

				return VIEWTYPE_VIEWPAGER;

			} else {
				// textview
				return VIEWTYPE_TEXTVIEW;
			}
		}

	}
}
