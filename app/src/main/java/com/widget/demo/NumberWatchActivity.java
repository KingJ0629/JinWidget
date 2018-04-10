package com.widget.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.kingj.utils.NumberWatcher;
import com.widget.R;

/**
 * Created by Jin on 2018/4/10.
 * Description
 */
public class NumberWatchActivity extends AppCompatActivity {
	
	private EditText mEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.number_watcher_layout);
		
		mEditText = findViewById(R.id.edit_text);
		mEditText.addTextChangedListener(new NumberWatcher(mEditText));
	}
}
