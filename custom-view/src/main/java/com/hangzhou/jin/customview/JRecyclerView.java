package com.hangzhou.jin.customview;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Jin on 2016/8/17.
 * Description
 */
public class JRecyclerView extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener {

	private RecyclerView mRecyclerView;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private LoadView mLoadView;

	public JRecyclerView(Context context, AttributeSet attrs) {
		super(context, attrs);

		View view = View.inflate(context, R.layout.j_recycler_view, null);

		mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
		mLoadView = (LoadView) view.findViewById(R.id.loadView);

		this.addView(view);
	}

	public RecyclerView getRecyclerView() {
		return mRecyclerView;
	}

	public SwipeRefreshLayout getSwipeRefreshLayout() {
		return mSwipeRefreshLayout;
	}

	public LoadView getLoadView() {
		return mLoadView;
	}

	/**------------------------------- refresh view ----------------------------------**/
	public interface OnRefreshListener extends SwipeRefreshLayout.OnRefreshListener {}

	/**
	 * Set the listener to be notified when a refresh is triggered via the swipe
	 * gesture.
	 */
	public void setOnRefreshListener(OnRefreshListener listener) {
		mSwipeRefreshLayout.setOnRefreshListener(listener);
	}


	/**------------------------------- load view ----------------------------------**/
	public void loadComplete() {
		mLoadView.loadComplete();
	}

	public void loadCompleteNoDataDef() {
		mLoadView.loadCompleteNoDataDef();
	}

	/**
	 * 已经在xml中配置属性
	 */
	public void loadCompleteNoDataAttr() {
		mLoadView.loadCompleteNoDataAttr();
	}

	/**
	 * 没数据时候展现的View
	 * @param res 图片资源文件
	 * @param text 文本
	 */
	public void loadCompleteNoData(@DrawableRes int res, String text) {
		mLoadView.loadCompleteNoData(res, text);
	}

	public void loadCompleteNoData(@DrawableRes int res, @StringRes int str) {
		mLoadView.loadCompleteNoData(res, str);
	}

	public void loadCompleteNoData(@DrawableRes int res) {
		mLoadView.loadCompleteNoData(res);
	}

	public void loadCompleteNoData(String text) {
		mLoadView.loadCompleteNoData(text);
	}

	/**
	 * 正在加载中...
	 */
	public void loading() {
		mLoadView.loading();
	}

	@Override
	public void onRefresh() {

	}
}
