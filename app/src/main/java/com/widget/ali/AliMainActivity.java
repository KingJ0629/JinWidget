package com.widget.ali;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.widget.ali.dispatched.DispatchActivity;

/**
 * Created by Jin on 2017/3/23.
 * Description
 */
public class AliMainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		startActivity(new Intent(this, DispatchActivity.class));
	}
}
