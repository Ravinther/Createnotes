package com.socialnmobile.colornote.menu;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.socialnmobile.colornote.menu.i */
final class C0324i implements OnTouchListener {
    final /* synthetic */ C0318c f1427a;

    private C0324i(C0318c c0318c) {
        this.f1427a = c0318c;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f1427a.f1396a != null && this.f1427a.f1396a.isShowing() && x >= 0 && x < this.f1427a.f1396a.getWidth() && y >= 0 && y < this.f1427a.f1396a.getHeight()) {
            this.f1427a.f1405j.postDelayed(this.f1427a.f1404i, 250);
        } else if (action == 1) {
            this.f1427a.f1405j.removeCallbacks(this.f1427a.f1404i);
        }
        return false;
    }
}
