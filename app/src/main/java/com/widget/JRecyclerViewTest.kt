package com.widget

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.j_recycler_view_test.*
import java.util.*

/**
 * Created by Jin on 2016/8/17.
 * Description
 */
class JRecyclerViewTest : AppCompatActivity() {

    private var mAdapter: CustomAdapter? = null

    private var array: Array<String>? = null
    private var list: MutableList<String> = ArrayList()

    private val mHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            when (msg.what) {
                1 -> {
                    mAdapter!!.setNewData(list)
                    jRecyclerView!!.setRefreshing(false)
                    jRecyclerView!!.loadComplete()
                }
                2 -> mAdapter!!.notifyDataChangedAfterLoadMore(list, true)
                else -> {
                }
            }
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.j_recycler_view_test)

        // 设置空隙
        jRecyclerView!!.addItemDecoration(R.dimen.recycler_view_item_space)
        jRecyclerView!!.addItemDecorationDef()

        mAdapter = CustomAdapter(list as ArrayList<String>)
        jRecyclerView!!.setAdapter(mAdapter)
        jRecyclerView!!.MarginTop(R.dimen.recycler_view_item_space)

        array = resources.getStringArray(R.array.ferry)
        for (s in array!!) {
            list.add(s)
        }

        mAdapter!!.openLoadMore(array!!.size, true)

        // 自定义上拉View
        mAdapter!!.setOnLoadMoreListener { MyThread(2).start() }

        jRecyclerView!!.loading()
        loadData()
        jRecyclerView!!.setOnRefreshListener { loadData() }
    }

    private fun loadData() {
        MyThread(1).start()
    }

    internal inner class CustomAdapter(list: List<String>) : BaseQuickAdapter<String>(R.layout.item, list) {

        override fun convert(baseViewHolder: BaseViewHolder, bean: String) {
            baseViewHolder.setText(R.id.tv, bean)
        }
    }

    internal inner class MyThread(var what: Int) : Thread() {
        override fun run() {
            try {
                Thread.sleep(2000)
                mHandler.obtainMessage(what).sendToTarget()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
    }
}
