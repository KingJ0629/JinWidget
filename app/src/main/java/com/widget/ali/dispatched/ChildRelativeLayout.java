package com.widget.ali.dispatched;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Jin on 2017/3/23.
 * Description 底层layout
 */
class ChildRelativeLayout extends RelativeLayout {
	
	public ChildRelativeLayout(Context context) {
		super(context);
	}
	
	public ChildRelativeLayout(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ChildRelativeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		
		Log.i("msg", "ChildRelativeLayout     dispatchTouchEvent-----" + TouchEventUtil.getTouchAction(event.getAction()));
		
		return super.dispatchTouchEvent(event);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		
		Log.i("msg", "ChildRelativeLayout     onInterceptTouchEvent-----" + TouchEventUtil.getTouchAction(ev.getAction()));
		
		return super.onInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		Log.i("msg", "ChildRelativeLayout     onTouchEvent-----" + TouchEventUtil.getTouchAction(event.getAction()));
		
		return super.onTouchEvent(event);
	}
}
