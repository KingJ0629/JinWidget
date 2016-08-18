package com.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.hangzhou.jin.customview.LoadView;

/**
 * Created by Jin on 2016/8/17.
 * Description
 */
public class TestLoadView extends AppCompatActivity {

	private LoadView mLoadView;

	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			mLoadView.loadCompleteNoDataDef();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loadview_test);

		mLoadView = (LoadView) findViewById(R.id.loadView);
		mLoadView.loading();

		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					mHandler.obtainMessage(2).sendToTarget();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
