package com.hangzhou.jin.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jin on 2016/7/8.
 * Title View on the top
 */
public class TitleView extends RelativeLayout {


	private final static String TAG = "TitleView";

	private Context mContext;
	private LinearLayout leftLayout, rightLayout;
	private TextView titleTxt;

	// back icon
	private boolean defaultLeftIcon;

	public TitleView(Context context, AttributeSet attrs) {
		super(context, attrs);

		this.mContext = context;

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleView);

		View view = View.inflate(context, R.layout.title_view, null);

		leftLayout = (LinearLayout) view.findViewById(R.id.title_view_left);
		rightLayout = (LinearLayout) view.findViewById(R.id.title_view_right);
		titleTxt = (TextView) view.findViewById(R.id.title_view_title_text);

		try {
			boolean leftLayoutVisible = a.getBoolean(R.styleable.TitleView_leftLayoutVisible, true);
			defaultLeftIcon = a.getBoolean(R.styleable.TitleView_defaultLeftIcon, false);
			String titleStr = a.getString(R.styleable.TitleView_middleText);

			if (isInEditMode()) {
				return;
			}

			leftLayout.setVisibility(leftLayoutVisible ? View.VISIBLE : View.GONE);
			if (defaultLeftIcon) {
				injectLeftImg();
			}
			titleTxt.setText(titleStr);
		} finally {
			a.recycle();
		}
		this.addView(view);
	}

	public void setTitle(@StringRes int res) {
		titleTxt.setText(res);
	}

	public void setTitle(String titleStr) {
		titleTxt.setText(titleStr);
	}

	/**
	 * Left Custom View with default click event
	 * @param customView customView
	 * @return view
	 */
	public View injectLeftView(View customView) {
		// view default click event
		leftLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				((Activity) mContext).finish();
			}
		});

		leftLayout.addView(customView);
		return customView;
	}

	/**
	 * Left Custom View with custom click event
	 * @param customView customView
	 * @param mOnclickListener mOnclickListener
	 * @return view
	 */
	public View injectLeftView(View customView, View.OnClickListener mOnclickListener) {
		leftLayout.setOnClickListener(mOnclickListener);
		leftLayout.addView(customView);
		return customView;
	}

	/**********************  Left  Img  **************************/
	public ImageView injectLeftImg() {
		if (leftLayout.getChildCount() > 0) {
			return null;
		}
		return injectLeftImg(R.mipmap.title_left_back);
	}

	public ImageView injectLeftImg(View.OnClickListener mOnclickListener) {
		return injectLeftImg(R.mipmap.title_left_back, mOnclickListener);
	}

	public ImageView injectLeftImg(@DrawableRes int res) {
		ImageView iv = new ImageView(mContext);
		iv.setImageResource(res);
		return (ImageView) injectLeftView(iv);
	}

	public ImageView injectLeftImg(@DrawableRes int res, View.OnClickListener mOnclickListener) {
		ImageView iv = new ImageView(mContext);
		iv.setImageResource(res);
		return (ImageView) injectLeftView(iv, mOnclickListener);
	}
	/**********************  Left  Img  end  **************************/

	/**********************  Left  Text  **************************/
	public TextView injectLeftTxt(String leftTxt) {
		return injectLeftTxt(leftTxt, R.dimen.title_view_default_text_size, R.color.title_view_text);
	}

	public TextView injectLeftTxt(String leftTxt, View.OnClickListener mOnclickListener) {
		return injectLeftTxt(leftTxt, R.dimen.title_view_default_text_size, R.color.title_view_text, mOnclickListener);
	}

	public TextView injectLeftTxt(String leftTxt, @DimenRes int sizeRes, @ColorRes int colorRes) {
		TextView tv = new TextView(mContext);
		tv.setText(leftTxt);
		int size = getResources().getDimensionPixelSize(sizeRes);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
		tv.setTextColor(mContext.getResources().getColor(colorRes));

		return (TextView) injectLeftView(tv);
	}

	public TextView injectLeftTxt(String leftTxt, @DimenRes int sizeRes, @ColorRes int colorRes, View.OnClickListener mOnclickListener) {
		TextView tv = new TextView(mContext);
		tv.setText(leftTxt);
		int size = getResources().getDimensionPixelSize(sizeRes);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
		tv.setTextColor(mContext.getResources().getColor(colorRes));

		return (TextView) injectLeftView(tv, mOnclickListener);
	}
	/**********************  Left  Text  end  **************************/

	/**********************  Right  View  **************************/
	public View injectRightView(View rightView, View.OnClickListener mOnclickListener) {
		rightLayout.setOnClickListener(mOnclickListener);
		rightLayout.addView(rightView);
		return rightView;
	}

	public ImageView injectRightImg(@DrawableRes int res, View.OnClickListener mOnclickListener) {
		ImageView iv = new ImageView(mContext);
		iv.setImageResource(res);
		return (ImageView) injectRightView(iv, mOnclickListener);
	}


	public TextView injectRightTxt(String rightTxt, View.OnClickListener mOnclickListener) {
		return injectRightTxt(rightTxt, R.dimen.title_view_default_text_size, R.color.title_view_text, mOnclickListener);
	}

	public TextView injectRightTxt(String rightTxt, @DimenRes int sizeRes, @ColorRes int colorRes, View.OnClickListener mOnclickListener) {
		TextView tv = new TextView(mContext);
		tv.setText(rightTxt);
		int size = getResources().getDimensionPixelSize(sizeRes);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
		tv.setTextColor(mContext.getResources().getColor(colorRes));

		return (TextView) injectRightView(tv, mOnclickListener);
	}
	/**********************  Right  View  end  **************************/

	/**
	 * hide Left Layout
	 */
	public void removeLeft() {
		leftLayout.setVisibility(View.GONE);
	}

	/**
	 * get title TextView
	 * @return title TextView
	 */
	public TextView getTitleLayout() {
		return titleTxt;
	}

	/**
	 * get leftLayout (LinearLayout)
	 * @return leftLayout (LinearLayout)
	 */
	public LinearLayout getLeftLayout() {
		return leftLayout;
	}

	/**
	 * get rightLayout (LinearLayout)
	 * @return rightLayout (LinearLayout)
	 */
	public LinearLayout getRightLayout() {
		return rightLayout;
	}
}
