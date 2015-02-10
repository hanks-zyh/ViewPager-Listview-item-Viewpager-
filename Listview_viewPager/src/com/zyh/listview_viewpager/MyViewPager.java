package com.zyh.listview_viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
	private float xDown;// 记录手指按下时的横坐标�?
	private float xMove;// 记录手指移动时的横坐标�?
	private float yDown;// 记录手指按下时的纵坐标�?
	private float yMove;// 记录手指移动时的纵坐标�?
	private boolean viewpagersroll = false;// 当前是否是viewpager滑动

	public MyViewPager(Context context) {
		super(context);
	}

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) { // 记录按下时的位置
			xDown = ev.getRawX();
			yDown = ev.getRawY();
		} else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
			xMove = ev.getRawX();
			yMove = ev.getRawY();
			if (viewpagersroll) { // viewpager自己处理滑动效果
				getParent().requestDisallowInterceptTouchEvent(true);
				return super.dispatchTouchEvent(ev);
			} // 这里的动作判断是Viewpager滑动,ListView不滑�?
			if (Math.abs(yMove - yDown) < 5 && Math.abs(xMove - xDown) > 20) {
				viewpagersroll = true;
			} else { // 由父容器listview来处理滑动效�?
				return false;
			}
		} else if (ev.getAction() == MotionEvent.ACTION_UP) {
			viewpagersroll = false;
		}
		return super.dispatchTouchEvent(ev);
	}
}