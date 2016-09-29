package com.widget

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextMoreLayout.setOnClickListener { startActivity(Intent(this, MinePersonalSettingsActivity::class.java)) }
        mTailsTextView.setOnClickListener { startActivity(Intent(this, TailsTextLayoutTestActivity::class.java)) }
        mLoadView.setOnClickListener { startActivity(Intent(this, TestLoadView::class.java)) }
        mJRecyclerViewTest.setOnClickListener { startActivity(Intent(this, JRecyclerViewTest::class.java)) }
        mSuperText.setOnClickListener { startActivity(Intent(this, SuperTextTestActivity::class.java)) }
    }
}
