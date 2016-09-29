package com.widget

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.loadview_test.*

/**
 * Created by Jin on 2016/8/17.
 * Description
 */
class TestLoadView : AppCompatActivity() {


    internal var mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            loadView.loadCompleteNoDataDef()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loadview_test)

        loadView.loading()

        object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2000)
                    mHandler.obtainMessage(2).sendToTarget()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }.start()
    }
}
