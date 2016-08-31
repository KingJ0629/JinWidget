package com.hangzhou.jin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Jin on 2016/8/31.
 * Description
 */
public class RecycleViewDivider extends RecyclerView.ItemDecoration {

	private Paint mPaint;
	private Drawable mDivider;
	private int mDividerHeight = 2;
	private int mOrientation;
	private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

	/**
	 * @param context
	 * @param orientation orientation
	 */
	public RecycleViewDivider(Context context, int orientation) {
		if (orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.HORIZONTAL) {
			throw new IllegalArgumentException("Please enter the correct parameters！");
		}
		mOrientation = orientation;

		final TypedArray a = context.obtainStyledAttributes(ATTRS);
		mDivider = a.getDrawable(0);
		a.recycle();
	}

	/**
	 * @param context context
	 * @param orientation orientation
	 * @param drawableId  drawable
	 */
	public RecycleViewDivider(Context context, int orientation, int drawableId) {
		this(context, orientation);
		mDivider = ContextCompat.getDrawable(context, drawableId);
		mDividerHeight = mDivider.getIntrinsicHeight();
	}

	/**
	 * @param context context
	 * @param orientation   orientation
	 * @param dividerHeight dividerHeight
	 * @param dividerColor  dividerColor
	 */
	public RecycleViewDivider(Context context, int orientation, int dividerHeight, int dividerColor) {
		this(context, orientation);
		mDividerHeight = dividerHeight;
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(dividerColor);
		mPaint.setStyle(Paint.Style.FILL);
	}


	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		super.getItemOffsets(outRect, view, parent, state);
		outRect.set(0, 0, 0, mDividerHeight);
	}

	@Override
	public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
		super.onDraw(c, parent, state);
		if (mOrientation == LinearLayoutManager.VERTICAL) {
			drawVertical(c, parent);
		} else {
			drawHorizontal(c, parent);
		}
	}

	private void drawHorizontal(Canvas canvas, RecyclerView parent) {
		final int left = parent.getPaddingLeft();
		final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
		final int childSize = parent.getChildCount();
		for (int i = 0; i < childSize; i++) {
			final View child = parent.getChildAt(i);
			RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
			final int top = child.getBottom() + layoutParams.bottomMargin;
			final int bottom = top + mDividerHeight;
			if (mDivider != null) {
				mDivider.setBounds(left, top, right, bottom);
				mDivider.draw(canvas);
			}
			if (mPaint != null) {
				canvas.drawRect(left, top, right, bottom, mPaint);
			}
		}
	}

	private void drawVertical(Canvas canvas, RecyclerView parent) {
		final int top = parent.getPaddingTop();
		final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
		final int childSize = parent.getChildCount();
		for (int i = 0; i < childSize; i++) {
			final View child = parent.getChildAt(i);
			RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
			final int left = child.getRight() + layoutParams.rightMargin;
			final int right = left + mDividerHeight;
			if (mDivider != null) {
				mDivider.setBounds(left, top, right, bottom);
				mDivider.draw(canvas);
			}
			if (mPaint != null) {
				canvas.drawRect(left, top, right, bottom, mPaint);
			}
		}
	}
}
