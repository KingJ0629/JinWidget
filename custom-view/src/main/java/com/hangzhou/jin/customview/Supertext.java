package com.hangzhou.jin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Jin on 2016/9/24.
 * Description
 */
public class SuperText extends TextView {

	public SuperText(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SuperText);
		try {
			String s = a.getString(R.styleable.SuperText_textAttr);
			int i = a.getInt(R.styleable.SuperText_textAttr, 0);


			Log.i("msg", s + "---------" + a.getIndexCount() + "   "+ i);
		} finally {
			a.recycle();
		}
	}

}
