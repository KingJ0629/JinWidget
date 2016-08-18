package com.hangzhou.jin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jin on 2016/7/14.
 * Description load View
 */
public class LoadView extends RelativeLayout {

	private LinearLayout noDataLayout;
	private RelativeLayout progressLayout;
	private ImageView imageView;
	private TextView textView;

	public LoadView(Context context, AttributeSet attrs) {
		super(context, attrs);
		View view = View.inflate(context, R.layout.load_view, null);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoadView);

		try {
			String noDataText = a.getString(R.styleable.LoadView_LoadViewNoDataText);
			int noDataImg = a.getResourceId(R.styleable.LoadView_LoadViewNoDataImg, R.mipmap.none_data_icon);

			noDataLayout = (LinearLayout) view.findViewById(R.id.no_data_layout);
			progressLayout = (RelativeLayout) view.findViewById(R.id.progress_layout);

			textView = (TextView) view.findViewById(R.id.no_data_text);
			if (null != noDataText)
				textView.setText(noDataText);

			imageView = (ImageView) view.findViewById(R.id.no_data_img);
			imageView.setBackgroundResource(noDataImg);
		} finally {
			a.recycle();
		}

		this.addView(view);
	}

	public void loadComplete() {
		progressLayout.setVisibility(GONE);
		noDataLayout.setVisibility(GONE);
	}

	public void loadCompleteNoDataDef() {
		loadCompleteNoData(R.mipmap.none_data_icon, "暂无相关内容");
	}

	public void loadCompleteNoDataAttr() {
		imageView.setVisibility(VISIBLE);
		textView.setVisibility(VISIBLE);
		noDataLayout.setVisibility(VISIBLE);
		progressLayout.setVisibility(GONE);
	}

	public void loadCompleteNoData(@DrawableRes int res, String text) {
		textView.setText(text);
		loadCompleteNoData(res);
	}

	public void loadCompleteNoData(@DrawableRes int res, @StringRes int str) {
		textView.setText(str);
		loadCompleteNoData(res);
	}

	public void loadCompleteNoData(@DrawableRes int res) {
		imageView.setBackgroundResource(res);
		imageView.setVisibility(VISIBLE);
		textView.setVisibility(VISIBLE);
		noDataLayout.setVisibility(VISIBLE);
		progressLayout.setVisibility(GONE);
	}

	public void loadCompleteNoData(String text) {
		imageView.setVisibility(VISIBLE);
		textView.setText(text);
		textView.setVisibility(VISIBLE);
		noDataLayout.setVisibility(VISIBLE);
		progressLayout.setVisibility(GONE);
	}

	public void loading() {
		noDataLayout.setVisibility(GONE);
		progressLayout.setVisibility(VISIBLE);
	}
}
