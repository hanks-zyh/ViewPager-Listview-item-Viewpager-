package com.zyh.listview_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	private ViewPager viewpager;
	private List<View> list = new ArrayList<View>();
	private MyPageAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager = (ViewPager)findViewById(R.id.viewpager);
		
		initData();
		adapter = new MyPageAdapter();
		viewpager.setAdapter(adapter);
	}
	
	private void initData() {
		list.add(new View1(this).listview);
		list.add(new View1(this).listview);
		list.add(new View1(this).listview);
	}

	class MyPageAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			((ViewGroup)container).addView((View)list.get(position));
			return list.get(position);
			
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}
		
	}
 
}
