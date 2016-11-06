package com.hangzhou.jin.customview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.View;

/**
 * Created by Jin on 2016/11/6.
 * Description Class Title
 */
public class Title {

	/**
	 * get TitleView
	 * @param context context
	 * @return
	 */
	public static TitleView getView(Context context) {
		return (TitleView) ((Activity) context).findViewById(R.id.title);
	}

	/**
	 * back icon + title
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg();
		title.invalidate();
	}

	/**
	 * just --> title
	 * @param context context
	 * @param leftNullCode if leftNullCode == 0 --> none left
	 * @param titleStr title
	 */
	public static void init(int leftNullCode, Context context, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		if (leftNullCode != 0) {
			title.injectLeftImg();
		}
		title.invalidate();
	}

	/**
	 * back icon (+ custom click event) + title
	 * @param context context
	 * @param mOnClickListener back icon custom click event
	 * @param titleStr title
	 */
	public static void init(Context context, View.OnClickListener mOnClickListener, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg(mOnClickListener);
		title.invalidate();
	}

	/**
	 * left text + title
	 * @param leftTxt left text
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(String leftTxt, Context context, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftTxt(leftTxt);
		title.invalidate();
	}

	/**
	 * left text (+ custom click event) + title
	 * @param leftTxt left text
	 * @param mOnClickListener left text custom click event
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(String leftTxt, View.OnClickListener mOnClickListener, Context context, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftTxt(leftTxt, mOnClickListener);
		title.invalidate();
	}

	/**
	 * custom view + title
	 * @param view custom view
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, View view, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftView(view);
		title.invalidate();
	}

	/**
	 * custom view (+ custom click event) + title
	 * @param view custom view
	 * @param mOnClickListener left text custom click event
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, View view, View.OnClickListener mOnClickListener, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftView(view, mOnClickListener);
		title.invalidate();
	}

	/**
	 * custom view + title
	 * @param res image res
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, @DrawableRes int res, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg(res);
		title.invalidate();
	}

	/**
	 * custom view (+ custom click event) + title
	 * @param res image res
	 * @param mOnClickListener left text custom click event
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, @DrawableRes int res, View.OnClickListener mOnClickListener, String titleStr) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg(res, mOnClickListener);
		title.invalidate();
	}


	/*******************************    Right   ***********************/

	/**
	 * back icon + title + tight icon
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, String titleStr, @DrawableRes int res, View.OnClickListener mOnClickListener) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg();
		title.injectRightImg(res, mOnClickListener);
		title.invalidate();
	}

	/**
	 * back icon (+ custom click event) + title + tight icon
	 * @param context context
	 * @param mOnClickListener back icon custom click event
	 * @param titleStr title
	 */
	public static void init(Context context, View.OnClickListener mOnClickListener, String titleStr, @DrawableRes int res, View.OnClickListener mOnClickListener2) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg(mOnClickListener);
		title.injectRightImg(res, mOnClickListener2);
		title.invalidate();
	}

	/**
	 * back icon + title + tight icon
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, String titleStr, String rightStr, View.OnClickListener mOnClickListener) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg();
		title.injectRightTxt(rightStr, mOnClickListener);
		title.invalidate();
	}

	/**
	 * back icon (+ custom click event) + title + tight icon
	 * @param context context
	 * @param mOnClickListener back icon custom click event
	 * @param titleStr title
	 */
	public static void init(Context context, View.OnClickListener mOnClickListener, String titleStr, String rightStr, View.OnClickListener mOnClickListener2) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg(mOnClickListener);
		title.injectRightTxt(rightStr, mOnClickListener2);
		title.invalidate();
	}

	/**
	 * back icon + title + tight icon
	 * @param context context
	 * @param titleStr title
	 */
	public static void init(Context context, String titleStr, View view, View.OnClickListener mOnClickListener) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg();
		title.injectRightView(view, mOnClickListener);
		title.invalidate();
	}

	/**
	 * back icon (+ custom click event) + title + tight icon
	 * @param context context
	 * @param mOnClickListener back icon custom click event
	 * @param titleStr title
	 */
	public static void init(Context context, View.OnClickListener mOnClickListener, String titleStr, View view, View.OnClickListener mOnClickListener2) {
		TitleView title = getView(context);
		title.setTitle(titleStr);
		title.injectLeftImg(mOnClickListener);
		title.injectRightView(view, mOnClickListener2);
		title.invalidate();
	}
}
