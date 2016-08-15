package com.socialnmobile.colornote.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.socialnmobile.colornote.view.t */
public final class C0427t implements OnTouchListener {
    final /* synthetic */ C0426s f2204a;

    public C0427t(C0426s c0426s) {
        this.f2204a = c0426s;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f2204a.f2202k) {
            return false;
        }
        this.f2204a.f2199h.onTouchEvent(motionEvent);
        return true;
    }
}
