package com.widget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.tails_test.*

class TailsTextLayoutTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tails_test)

        mTailsTextView3.text = "数据修改"
    }
}
