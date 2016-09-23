package com.hangzhou.jin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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
	private boolean lineUnder = false;

	private int leftTextColor;
	private int rightTextColor;

	public TailsTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TailsTextView);
		try {
			leftTxt = a.getString(R.styleable.TailsTextView_leftTextTails);
			rightTxt = a.getString(R.styleable.TailsTextView_rightTextTails);
			lineThrough = a.getBoolean(R.styleable.TailsTextView_line_through, false);
			lineUnder = a.getBoolean(R.styleable.TailsTextView_line_under, false);

			leftTextColor = a.getColor(R.styleable.TailsTextView_leftTextColor, getCurrentTextColor());
			rightTextColor = a.getColor(R.styleable.TailsTextView_rightTextColor, getCurrentTextColor());
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
			this.getPaint().setAntiAlias(true);
		}

		if (lineUnder) {
			this.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
			this.getPaint().setAntiAlias(true);
		}
	}

	public void setText(String str) {
		innerTxt = str;
		super.setText(leftTxt + str + rightTxt);

		SpannableString ss = new SpannableString(getText());
		ss.setSpan(new ForegroundColorSpan(leftTextColor), 0, leftTxt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new ForegroundColorSpan(rightTextColor), this.length() - rightTxt.length(), this.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		this.setSpannableString(ss);
	}

	private void setSpannableString(SpannableString ss) {
		super.setText(ss);
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
