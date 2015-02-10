package com.zyh.listview_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter implements OnPageChangeListener {
	private Context context;
	private List<String> list;
	private LayoutInflater inflater; // 将要添加到Viewpager中的3个View
	private View view1;
	private View view2;
	private View view3;
	private List<View> views;

	public MyListAdapter(Context context, List<String> list) {
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	} // 当列表数据发生变化时,用此方法来更新列�?

	public void updateListView(ArrayList<String> list) {
		this.list = list;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		MyViewPager mvp = new MyViewPager(context);
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, 70);
		mvp.setLayoutParams(lp);
		views = new ArrayList<View>();
		view1 = inflater.inflate(R.layout.fragment1, null);
		view2 = inflater.inflate(R.layout.fragment2, null);
		view3 = inflater.inflate(R.layout.fragment3, null);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		TextView nameTV = (TextView) view2.findViewById(R.id.name);
		nameTV.setText(list.get(position));
		mvp.setAdapter(new MyPageAdapter());
		mvp.setOnPageChangeListener(this);
		mvp.setCurrentItem(1);
		return mvp;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		if (position == 0) {
		} else if (position == 1) {
		} else if (position == 2) {
		}
	}

	class MyPageAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return views.size();
		}

		@Override
		public Object instantiateItem(View container, int position) {
			ViewGroup group = (ViewGroup) views.get(position).getParent();
			if (group != null) {
				group.removeView(views.get(position));
			}
			((ViewPager) container).addView(views.get(position));
			return views.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));
		}
	}
}