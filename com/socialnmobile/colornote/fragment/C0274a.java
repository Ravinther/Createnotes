package com.socialnmobile.colornote.fragment;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* renamed from: com.socialnmobile.colornote.fragment.a */
final class C0274a extends SimpleOnGestureListener {
    final /* synthetic */ AbstractEditorViewer f1206a;

    C0274a(AbstractEditorViewer abstractEditorViewer) {
        this.f1206a = abstractEditorViewer;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f1206a.m1233L()) {
            this.f1206a.m1255a(false, "BARTAP");
            this.f1206a.ac.f2194c.requestFocus();
        }
        return true;
    }
}
