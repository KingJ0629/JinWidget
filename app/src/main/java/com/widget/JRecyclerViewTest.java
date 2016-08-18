package com.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hangzhou.jin.customview.JRecyclerView;

import java.util.List;

/**
 * Created by Jin on 2016/8/17.
 * Description
 */
public class JRecyclerViewTest extends AppCompatActivity implements JRecyclerView.OnRefreshListener {

	private JRecyclerView mJRecyclerView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.j_recycler_view_test);

		mJRecyclerView = (JRecyclerView) findViewById(R.id.jRecyclerView);

	}

	@Override
	public void onRefresh() {

	}

	class CustomAdapter extends BaseQuickAdapter<String> {

		public CustomAdapter(Context context, List<String> list) {
			super(R.layout.item, list);
		}

		@Override
		protected void convert(BaseViewHolder baseViewHolder, String bean) {

		}
	}
}
