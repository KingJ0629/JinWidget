package com.widget.ali.dispatched;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.widget.R;

/**
 * Created by Jin on 2017/3/23.
 * Description
 */
public class DispatchActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dispatch_activity);
		
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		
		Log.i("msg", "Activity     dispatchTouchEvent-----" + TouchEventUtil.getTouchAction(ev.getAction()));
		
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		Log.i("msg", "Activity     onTouchEvent-----" + TouchEventUtil.getTouchAction(event.getAction()));
		
		return super.onTouchEvent(event);
	}
}
