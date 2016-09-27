package com.widget

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mActivity: Activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextMoreLayout.setOnClickListener { startActivity(Intent(mActivity, MinePersonalSettingsActivity::class.java)) }
        mTailsTextView.setOnClickListener { startActivity(Intent(mActivity, TailsTextLayoutTestActivity::class.java)) }
        mLoadView.setOnClickListener { startActivity(Intent(mActivity, TestLoadView::class.java)) }
        mJRecyclerViewTest.setOnClickListener { startActivity(Intent(mActivity, JRecyclerViewTest::class.java)) }
        mSuperText.setOnClickListener { startActivity(Intent(mActivity, SuperTextTestActivity::class.java)) }
    }
}
