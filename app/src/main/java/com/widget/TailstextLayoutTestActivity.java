package com.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hangzhou.jin.customview.TailsTextView;

public class TailsTextLayoutTestActivity extends AppCompatActivity {

	private TailsTextView mTailsTextView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tails_test);

		mTailsTextView3 = (TailsTextView) findViewById(R.id.mTailsTextView3);
		mTailsTextView3.setText("数据修改");
	}
}
