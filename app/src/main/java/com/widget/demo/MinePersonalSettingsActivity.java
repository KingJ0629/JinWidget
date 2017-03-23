package com.widget.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hangzhou.jin.customview.TextMoreLayout;
import com.widget.R;

/**
 * Created by Jin on 2016/7/26.
 * Description
 */
public class MinePersonalSettingsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mine_personal_settings);

		TextMoreLayout nickname = (TextMoreLayout) findViewById(R.id.nickname);
		nickname.setRightText("LBJ");
		nickname.setLeftText("昵称");

		TextMoreLayout sex = (TextMoreLayout) findViewById(R.id.sex);
		sex.setRightText("男");

		TextMoreLayout birthDay = (TextMoreLayout) findViewById(R.id.birthDay);
		birthDay.setRightText("2016-07-26");

		TextMoreLayout ids = (TextMoreLayout) findViewById(R.id.ids);
		ids.setRightText("居民");

		TextMoreLayout phoneNum = (TextMoreLayout) findViewById(R.id.phoneNum);
		phoneNum.setRightText("188 8888 1111");
	}
}
