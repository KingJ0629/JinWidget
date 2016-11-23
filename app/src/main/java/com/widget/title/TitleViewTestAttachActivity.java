package com.widget.title;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hangzhou.jin.customview.Title;
import com.widget.R;

/**
 * Created by Jin on 2016/11/6.
 * Description
 */
public class TitleViewTestAttachActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Title.attachToActivity(this);
		setContentView(R.layout.title_view_test2);
	}
}
