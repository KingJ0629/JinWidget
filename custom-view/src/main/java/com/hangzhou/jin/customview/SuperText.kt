package com.hangzhou.jin.customview

import android.content.Context
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.TextView

/**
 * Created by Jin on 2016/9/24.
 * Description
 * ST:size tiny | SS:size small | SM:size middle | SB:size big | SH:size huge
 * C3:color(#333333) | C6:color(#666666) | CA:color(#aaaaaa) | CF:color(#ffffff)
 * C0:custom color ### default #000000
 * L1:line(1) | L2:line(2)
 * L0:custom line number ### default line(2147483647)
 */
class SuperText(context: Context, attrs: AttributeSet) : TextView(context, attrs) {

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.SuperText)
        try {
            var value_ = a.getString(R.styleable.SuperText_textAttr)
            var value = -1
            if (null != value_) {
                value_ = value_.replace("0x", "")
                value = Integer.parseInt(value_)
            }

            val ST = a.getDimension(R.styleable.SuperText_ST, resources.getDimensionPixelSize(R.dimen.super_text_ST).toFloat())
            val SS = a.getDimension(R.styleable.SuperText_SS, resources.getDimensionPixelSize(R.dimen.super_text_SS).toFloat())
            val SM = a.getDimension(R.styleable.SuperText_SM, resources.getDimensionPixelSize(R.dimen.super_text_SM).toFloat())
            val SB = a.getDimension(R.styleable.SuperText_SB, resources.getDimensionPixelSize(R.dimen.super_text_SB).toFloat())
            val SH = a.getDimension(R.styleable.SuperText_SH, resources.getDimensionPixelSize(R.dimen.super_text_SH).toFloat())

            val C0 = a.getColor(R.styleable.SuperText_C0, ContextCompat.getColor(context, R.color.super_text_c0))
            val L0 = a.getInt(R.styleable.SuperText_L0, Integer.MAX_VALUE)

            // lines
            this.ellipsize = TextUtils.TruncateAt.END
            when (value / 100) {
                1 -> this.setLines(1)
                2 -> this.setLines(2)
//                9,
//                else -> this.setLines(L0)
            }

            // colors
            when (value % 100 / 10) {
                1 -> this.setTextColor(ContextCompat.getColor(context, R.color.super_text_c3))
                2 -> this.setTextColor(ContextCompat.getColor(context, R.color.super_text_c6))
                3 -> this.setTextColor(ContextCompat.getColor(context, R.color.super_text_ca))
                4 -> this.setTextColor(ContextCompat.getColor(context, R.color.super_text_cf))
//                9,
//                else -> this.setTextColor(C0)
            }

            // text size
            when (value % 100 % 10) {
                1 -> this.setTextSize(TypedValue.COMPLEX_UNIT_PX, ST)
                2 -> this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SS)
                3 -> this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SM)
                4 -> this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SB)
                5 -> this.setTextSize(TypedValue.COMPLEX_UNIT_PX, SH)
                else -> {
                }
            }
        } finally {
            a.recycle()
        }
    }

}
