package com.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hangzhou.jin.customview.JRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jin on 2016/8/17.
 * Description
 */
public class JRecyclerViewTest extends AppCompatActivity {

	private JRecyclerView mJRecyclerView;
	private CustomAdapter mAdapter;

	private String[] array;
	private List<String> list;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			switch (msg.what) {
				case 1:
					mAdapter.setNewData(list);
					mJRecyclerView.setRefreshing(false);
					mJRecyclerView.loadComplete();
					break;
				case 2:
					mAdapter.notifyDataChangedAfterLoadMore(list, true);
					break;
				default:
					break;
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.j_recycler_view_test);

		mJRecyclerView = (JRecyclerView) findViewById(R.id.jRecyclerView);
		// 设置空隙
		mJRecyclerView.addItemDecoration(R.dimen.recycler_view_item_space);

		list = new ArrayList<>();
		array = getResources().getStringArray(R.array.ferry);
		for (String s : array) {
			list.add(s);
		}
		mAdapter = new CustomAdapter(null);
		mJRecyclerView.setAdapter(mAdapter);

		mAdapter.openLoadMore(array.length, true);

		// 自定义上拉View
		mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
			@Override
			public void onLoadMoreRequested() {
				new MyThread(2).start();
			}
		});

		mJRecyclerView.loading();
		loadData();
		mJRecyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				loadData();
			}
		});
	}

	private void loadData() {
		new MyThread(1).start();
	}

	class CustomAdapter extends BaseQuickAdapter<String> {

		public CustomAdapter(List<String> list) {
			super(R.layout.item, list);
		}

		@Override
		protected void convert(BaseViewHolder baseViewHolder, String bean) {
			baseViewHolder.setText(R.id.tv, bean);
		}
	}

	class MyThread extends Thread {

		int what;
		public MyThread(int what) {
			this.what = what;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				mHandler.obtainMessage(what).sendToTarget();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
