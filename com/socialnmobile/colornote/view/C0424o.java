package com.socialnmobile.colornote.view;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* renamed from: com.socialnmobile.colornote.view.o */
final class C0424o extends SimpleOnGestureListener {
    final /* synthetic */ DragDropListView f2191a;

    C0424o(DragDropListView dragDropListView) {
        this.f2191a = dragDropListView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f2191a.f1831a == null) {
            return false;
        }
        if (f > 1000.0f) {
            Rect b = this.f2191a.f1846p;
            this.f2191a.f1831a.getDrawingRect(b);
            if (motionEvent2.getX() > ((float) ((b.right * 2) / 3))) {
                this.f2191a.m2069a();
                this.f2191a.f1840j.m1572a(this.f2191a.f1835e);
                this.f2191a.m2070a(true);
            }
        }
        return true;
    }
}
