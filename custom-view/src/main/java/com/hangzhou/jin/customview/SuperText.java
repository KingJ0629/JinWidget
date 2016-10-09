package com.hangzhou.jin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by Jin on 2016/9/24.
 * Description
 * ST:size tiny | SS:size small | SM:size middle | SB:size big | SH:size huge
 * C3:color(#333333) | C6:color(#666666) | CA:color(#aaaaaa) | CF:color(#ffffff)
 * C0:custom color @@@ default #000000
 * L1:line(1) | L2:line(2)
 * L0:custom line number @@@ default line(2147483647)
 */
public class SuperText extends TextView {

	public SuperText(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SuperText);
		try {
			String value_ = a.getString(R.styleable.SuperText_textAttr);
			int value = -1;
			if (null != value_) {
				value_ = value_.replace("0x", "");
				value = Integer.parseInt(value_);
			}

			float ST = a.getDimension(R.styleable.SuperText_ST, getResources().getDimensionPixelSize(R.dimen.super_text_ST));
			float SS = a.getDimension(R.styleable.SuperText_SS, getResources().getDimensionPixelSize(R.dimen.super_text_SS));
			float SM = a.getDimension(R.styleable.SuperText_SM, getResources().getDimensionPixelSize(R.dimen.super_text_SM));
			float SB = a.getDimension(R.styleable.SuperText_SB, getResources().getDimensionPixelSize(R.dimen.super_text_SB));
			float SH = a.getDimension(R.styleable.SuperText_SH, getResources().getDimensionPixelSize(R.dimen.super_text_SH));

			int C0 = a.getColor(R.styleable.SuperText_C0, ContextCompat.getColor(context, R.color.super_text_c0));
			int L0 = a.getInt(R.styleable.SuperText_L0, Integer.MAX_VALUE);

			// lines
			this.setEllipsize(TextUtils.TruncateAt.END);
			switch (value / 100) {
				case 1:
					this.setLines(1);
					break;
				case 2:
					this.setLines(2);
					break;
				case 9:
				default:
					this.setLines(L0);
					break;
			}

			// colors
			switch (value % 100 / 10) {
				case 1:
					this.setTextColor(ContextCompat.getColor(context, R.color.super_text_c3));
					break;
				case 2:
					this.setTextColor(ContextCompat.getColor(context, R.color.super_text_c6));
					break;
				case 3:
					this.setTextColor(ContextCompat.getColor(context, R.color.super_text_ca));
					break;
				case 4:
					this.setTextColor(ContextCompat.getColor(context, R.color.super_text_cf));
					break;
				case 9:
				default:
					this.setTextColor(C0);
					break;
			}

			// text size
			switch (value % 100 % 10) {
				case 1:
					this.setTextSize(TypedValue.COMPLEX_UNIT_PX, ST);
					break;
				case 2:
					this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SS);
					break;
				case 3:
					this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SM);
					break;
				case 4:
					this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SB);
					break;
				case 5:
					this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SH);
				default:
					break;
			}
		} finally {
			a.recycle();
		}
	}

}
