package com.hangzhou.jin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
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
			String rightTxt = a.getString(R.styleable.TextMoreLayout_tmRightText);
			boolean rightImgVisible = a.getBoolean(R.styleable.TextMoreLayout_tmRightImgVisible, true);
			boolean bottomLineVisible = a.getBoolean(R.styleable.TextMoreLayout_tmBottomLineVisible, true);
			int leftTextColor = a.getColor(R.styleable.TextMoreLayout_tmLeftTextColor, context.getResources().getColor(R.color.tm_default_left_text_color));
			int rightTextColor = a.getColor(R.styleable.TextMoreLayout_tmRightTextColor, context.getResources().getColor(R.color.tm_default_right_text_color));

			int defaultLeftSize = getResources().getDimensionPixelSize(R.dimen.text_more_layout_default_left_text_size);
			float leftTextSize = a.getDimension(R.styleable.TextMoreLayout_tmLeftTextSize, defaultLeftSize);
			int defaultRightSize = getResources().getDimensionPixelSize(R.dimen.text_more_layout_default_right_text_size);
			float rightTextSize = a.getDimension(R.styleable.TextMoreLayout_tmRightTextSize, defaultRightSize);

			View view = View.inflate(context, R.layout.text_more_layout, null);

			leftText = (TextView) view.findViewById(R.id.leftText);
			leftText.setTextColor(leftTextColor);
			leftText.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
			if (null != leftTxt)
				leftText.setText(leftTxt);

			rightText = (TextView) view.findViewById(R.id.rightText);
			rightText.setTextColor(rightTextColor);
			rightText.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize);
			if (null != rightTxt)
				rightText.setText(rightTxt);
			if (!rightImgVisible)
				view.findViewById(R.id.more).setVisibility(View.GONE);

			view.findViewById(R.id.bottom_line).setVisibility(bottomLineVisible ? View.VISIBLE : View.GONE);

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
