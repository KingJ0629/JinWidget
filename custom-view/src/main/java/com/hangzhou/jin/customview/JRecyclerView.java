package com.hangzhou.jin.customview;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Jin on 2016/8/17.
 * Description
 */
public class JRecyclerView extends FrameLayout {

	private RecyclerView mRecyclerView;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private LoadView mLoadView;
	private FrameLayout mFrameLayout;

	private Context context;

	public JRecyclerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;

		View view = View.inflate(context, R.layout.j_recycler_view, null);

		mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
		mLoadView = (LoadView) view.findViewById(R.id.loadView);
		mFrameLayout = (FrameLayout) view.findViewById(R.id.j_parent_layout);

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

	public FrameLayout getParentView() {
		return mFrameLayout;
	}

	/**------------------------------- recycler view ----------------------------------**/
	public void addItemDecoration(RecyclerView.ItemDecoration decor) {
		mRecyclerView.addItemDecoration(decor);
	}

	public void addItemDecorationDef() {
		mRecyclerView.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.HORIZONTAL, 1, R.color.grey_back));
	}

	public void addItemDecoration(@DimenRes int res) {
		int spacingInPixels = getResources().getDimensionPixelSize(res);
		addItemDecoration(new SpaceItemDecoration(spacingInPixels));
	}

	public void setAdapter(RecyclerView.Adapter adapter) {
		mRecyclerView.setAdapter(adapter);
	}

	public void setLayoutManager(RecyclerView.LayoutManager layout) {
		mRecyclerView.setLayoutManager(layout);
	}

	public void MarginTop(@DimenRes int res) {
		mRecyclerView.setClipToPadding(false);
		int spacingInPixels = getResources().getDimensionPixelSize(res);
		mRecyclerView.setPadding(0, spacingInPixels, 0, 0);
	}

	/**------------------------------- refresh view ----------------------------------**/
	/**
	 * Set the listener to be notified when a refresh is triggered via the swipe
	 * gesture.
	 */
	public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
		mSwipeRefreshLayout.setOnRefreshListener(listener);
	}

	public void setRefreshing(boolean refreshing) {
		mSwipeRefreshLayout.setRefreshing(refreshing);
	}


	/**------------------------------- load view ----------------------------------**/
	public void loadComplete() {
		mLoadView.loadComplete();
	}

	public void loadCompleteNoDataDef() {
		mLoadView.loadCompleteNoDataDef();
	}

	public void loadCompleteNoDataAttr() {
		mLoadView.loadCompleteNoDataAttr();
	}

	public void loadCompleteNoData(@DrawableRes int res, String text) {
		mLoadView.loadCompleteNoData(res, text);
	}

	public void loadCompleteNoData(@DrawableRes int res, @StringRes int str) {
		mLoadView.loadCompleteNoData(res, str);
	}

	public void loadCompleteNoDataNoImg(String text) {
		mLoadView.loadCompleteNoDataNoImg(text);
	}

	public void loadCompleteNoData(@DrawableRes int res) {
		mLoadView.loadCompleteNoData(res);
	}

	public void loadCompleteNoData(String text) {
		mLoadView.loadCompleteNoData(text);
	}
	public void loading() {
		mLoadView.loading();
	}
}
