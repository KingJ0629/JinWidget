package com.widget

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Jin on 2016/5/23.
 * Description recycleView 间隙设置
 */
class SpaceItemDecoration(internal var space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        if (parent.getChildAdapterPosition(view) != 0) outRect.top = space
    }
}
