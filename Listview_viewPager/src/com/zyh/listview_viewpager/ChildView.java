package com.zyh.listview_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;

public class ChildView {

	ViewPager viewPager;
	private List<View> list = new ArrayList<View>();
	private Context mContext;


	public void init(Context context) {
		mContext = context;

		for (int i = 0; i < 5; i++) {
			Button view = new Button(mContext);
			view.setText("ViewPager中的TextView：" + i);
			view.setTextSize(20);
			list.add(view);
		}
		viewPager = (ViewPager) View.inflate(mContext, R.layout.layout_viewpager, null);
		
		/**
		 * 必须设置LayoutParams
		 */
		
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, 200);
		viewPager.setLayoutParams(lp);
		viewPager.setAdapter(new MyPageAdapter());
	}

	class MyPageAdapter extends PagerAdapter {

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
