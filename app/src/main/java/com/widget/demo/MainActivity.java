package com.widget.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.widget.R;
import com.widget.demo.title.TitleMainActivity;

public class MainActivity extends AppCompatActivity {

	private Activity mActivity;

	private TextView mTextMoreLayout, mTailsTextView, mLoadView, mJRecyclerViewTest, mSuperText, mTitleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mActivity = this;

		mTextMoreLayout = (TextView) findViewById(R.id.mTextMoreLayout);
		mTextMoreLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, MinePersonalSettingsActivity.class));
			}
		});

		mTailsTextView = (TextView) findViewById(R.id.mTailsTextView);
		mTailsTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, TestTailsTextLayoutActivity.class));
			}
		});

		mLoadView = (TextView) findViewById(R.id.mLoadView);
		mLoadView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, TestLoadView.class));
			}
		});

		mJRecyclerViewTest = (TextView) findViewById(R.id.mJRecyclerViewTest);
		mJRecyclerViewTest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, JRecyclerViewTest.class));
			}
		});

		mSuperText = (TextView) findViewById(R.id.mSuperText);
		mSuperText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, SuperTextTestActivity.class));
			}
		});

		mTitleView = (TextView) findViewById(R.id.mTitleView);
		mTitleView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(mActivity, TitleMainActivity.class));
			}
		});
	}
}
