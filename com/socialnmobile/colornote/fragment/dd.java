package com.socialnmobile.colornote.fragment;

import android.text.Layout;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.socialnmobile.colornote.view.LinedEditText;

final class dd extends SimpleOnGestureListener {
    final /* synthetic */ TextEditor f1314a;

    dd(TextEditor textEditor) {
        this.f1314a = textEditor;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f1314a.aG) {
            return false;
        }
        LinedEditText a = this.f1314a.at;
        int x = ((int) motionEvent.getX()) - a.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - a.getTotalPaddingTop();
        if (x < 0) {
            x = 0;
        } else if (x >= a.getWidth() - a.getTotalPaddingRight()) {
            x = (a.getWidth() - a.getTotalPaddingRight()) - 1;
        }
        if (y < 0) {
            y = 0;
        } else if (y >= a.getHeight() - a.getTotalPaddingBottom()) {
            y = (a.getHeight() - a.getTotalPaddingBottom()) - 1;
        }
        x += a.getScrollX();
        y += a.getScrollY();
        Layout layout = a.getLayout();
        y = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        LinedEditText a2 = this.f1314a.at;
        a2.m2080a(a2.getText(), y, false);
        a2.setSelection(a2.f1856a, a2.f1857b);
        return true;
    }
}
