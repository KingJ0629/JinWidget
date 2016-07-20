package com.hangzhou.jin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jin on 2016/7/4.
 * Description
 */
public class TextMoreLayout extends RelativeLayout {

	TextView leftText;
	TextView rightText;

	public TextMoreLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextMoreLayout);
		try {
			String leftTxt = a.getString(R.styleable.TextMoreLayout_tmLeftText);
			String rightTxt = a.getString(R.styleable.TextMoreLayout_tmRightTextTails);
			boolean rightImgVisible = a.getBoolean(R.styleable.TextMoreLayout_tmRightImgVisible, true);

			View view = View.inflate(context, R.layout.text_more_layout, null);

			leftText = (TextView) view.findViewById(R.id.leftText);
			if (null != leftTxt)
				leftText.setText(leftTxt);
			rightText = (TextView) view.findViewById(R.id.rightText);
			if (null != rightTxt)
				rightText.setText(rightTxt);
			if (!rightImgVisible)
				view.findViewById(R.id.more).setVisibility(View.GONE);

			this.addView(view);
		} finally {
			a.recycle();
		}
	}

	public void setLeftText(String str) {
		leftText.setText(str);
	}

	public void setRightText(String str) {
		rightText.setText(str);
	}

}
