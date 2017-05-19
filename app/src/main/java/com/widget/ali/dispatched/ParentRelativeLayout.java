package com.widget.ali.dispatched;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Jin on 2017/3/23.
 * Description
 */
public class ParentRelativeLayout extends RelativeLayout {
	
	public ParentRelativeLayout(Context context) {
		super(context);
	}
	
	public ParentRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ParentRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		
		Log.i("msg", "ParentRelativeLayout     dispatchTouchEvent-----" + TouchEventUtil.getTouchAction(ev.getAction()));
		
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		
		Log.i("msg", "ParentRelativeLayout     onInterceptTouchEvent-----" + TouchEventUtil.getTouchAction(ev.getAction()));
		
		return super.onInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		Log.i("msg", "ParentRelativeLayout     onTouchEvent-----" + TouchEventUtil.getTouchAction(event.getAction()));
		
		return super.onTouchEvent(event);
	}
}
