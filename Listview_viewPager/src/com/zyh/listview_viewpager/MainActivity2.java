package com.zyh.listview_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity2 extends Activity{
	private ListView listview;

	private Context context;
	private PagerAdapter adapter;
	
	private List<View> list = new ArrayList<View>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;
		initData();
		adapter = new MyPageAdapter();
		
		listview = new ListView(context);
		setContentView(listview);
		listview.setAdapter(new MyAdapter());
		
	}

	private void initData() {
		for (int i = 0; i < 5; i++) {
			Button view = new Button(context);
			view.setText("ViewPager中的TextView：" + i);
			view.setTextSize(30);
			list.add(view);
		}		
	}

	class MyAdapter extends BaseAdapter{



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
			if(convertView==null){
				convertView = new ViewPager(context);
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, 200);
				((ViewPager)convertView).setLayoutParams(lp);
				((ViewPager)convertView).setAdapter(adapter);
			}
			return convertView;
		}
	}
	
	
	class MyPageAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(list.get(position));
			return list.get(position);

		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}
		
	}
}
