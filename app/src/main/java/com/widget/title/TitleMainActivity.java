package com.widget.title;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.widget.R;

public class TitleMainActivity extends AppCompatActivity {

	private Activity mActivity;

	private TextView mTitleView1, mTitleView2, mTitleViewTestNormalActivity, mTitleViewTestAttachActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title_activity_main);
		mActivity = this;

		mTitleView1 = (TextView) findViewById(R.id.mTitleView1);
		mTitleView1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, TitleViewTest1Activity.class));
			}
		});

		mTitleView2 = (TextView) findViewById(R.id.mTitleView2);
		mTitleView2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, TitleViewTest2Activity.class));
			}
		});

		mTitleViewTestNormalActivity = (TextView) findViewById(R.id.mTitleViewTestNormalActivity);
		mTitleViewTestNormalActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, TitleViewTestNormalActivity.class));
			}
		});

		mTitleViewTestAttachActivity = (TextView) findViewById(R.id.mTitleViewTestAttachActivity);
		mTitleViewTestAttachActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, TitleViewTestAttachActivity.class));
			}
		});
	}
}
