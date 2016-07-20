package com.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Jin on 2016/7/8.
 */
public class TailsTextView extends TextView {

	private String leftTxt = "";
	private String rightTxt = "";
	private String innerTxt = "";
	private boolean lineThrough = false;

	public TailsTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TailsTextView);
		try {
			leftTxt = a.getString(R.styleable.TailsTextView_leftTextTails);
			rightTxt = a.getString(R.styleable.TailsTextView_rightTextTails);
			lineThrough = a.getBoolean(R.styleable.TailsTextView_line_through, false);
		} finally {
			a.recycle();
		}

		if (null == leftTxt)
			leftTxt = "";
		if (null == rightTxt)
			rightTxt = "";

		innerTxt = getText().toString();
		this.setText(innerTxt + "");

		if (lineThrough) {
			this.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		}
	}

	public void setText(String str) {
		innerTxt = str;
		super.setText(leftTxt + str + rightTxt);
	}

	public void setLeftTxt(String str) {
		this.leftTxt = str;
		setText(innerTxt);
	}

	public void setRightTxt(String str) {
		this.rightTxt = str;
		setText(innerTxt);
	}
}
