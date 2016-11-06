package com.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hangzhou.jin.customview.Title;

/**
 * Created by Jin on 2016/11/6.
 * Description
 */
public class TitleViewTestActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title_view_test);

		Title.init(this, "lalal", "xixi", new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.i("msg", "?????");
			}
		});
	}
}
