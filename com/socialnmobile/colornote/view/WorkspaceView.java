package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public abstract class WorkspaceView extends FrameLayout {
    public WorkspaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public WorkspaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WorkspaceView(Context context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).cancelLongPress();
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (view != null) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            requestRectangleOnScreen(rect);
        }
    }

    protected void setChildrenDrawingCacheEnabled(boolean z) {
        super.setChildrenDrawingCacheEnabled(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.setDrawingCacheEnabled(z);
            childAt.buildDrawingCache(true);
        }
    }

    protected void setChildrenDrawnWithCacheEnabled(boolean z) {
        super.setChildrenDrawnWithCacheEnabled(z);
    }
}
