package com.widget.title;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hangzhou.jin.customview.Title;
import com.widget.R;

/**
 * Created by Jin on 2016/11/6.
 * Description
 */
public class TitleViewTest2Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title_view_test);

		ImageView iv = new ImageView(this);
		iv.setBackgroundResource(R.mipmap.grey_star);

		Title.init(this, "自定义右边2", "积分说明", new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				TextView tv = Title.getView(TitleViewTest2Activity.this).getTitleLayout();
				tv.setText("Change");
				tv.setTextColor(Color.RED);
			}
		});
	}
}
