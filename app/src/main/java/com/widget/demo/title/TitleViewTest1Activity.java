package com.widget.demo.title;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hangzhou.jin.customview.Title;
import com.widget.R;

/**
 * Created by Jin on 2016/11/6.
 * Description
 */
public class TitleViewTest1Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title_view_test);

		ImageView iv = new ImageView(this);
		iv.setBackgroundResource(R.mipmap.grey_star);

		Title.init(this, "自定义右边", iv, new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(TitleViewTest1Activity.this, "blink blink~", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
