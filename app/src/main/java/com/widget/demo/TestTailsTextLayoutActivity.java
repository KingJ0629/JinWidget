package com.widget.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hangzhou.jin.customview.TailsTextView;
import com.widget.R;

public class TestTailsTextLayoutActivity extends AppCompatActivity {

	private TailsTextView mTailsTextView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tails_test);

		mTailsTextView3 = (TailsTextView) findViewById(R.id.mTailsTextView3);
		mTailsTextView3.setText("数据修改");

		mTailsTextView3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTailsTextView3.setWholeTextColor(Color.RED);
			}
		});
	}
}
