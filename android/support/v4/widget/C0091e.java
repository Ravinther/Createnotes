package android.support.v4.widget;

import android.os.SystemClock;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: android.support.v4.widget.e */
final class C0091e implements Runnable {
    final /* synthetic */ C0090d f308a;

    C0091e(C0090d c0090d) {
        this.f308a = c0090d;
    }

    public final void run() {
        View view;
        int i;
        int i2 = 0;
        C0090d c0090d = this.f308a;
        int i3 = c0090d.f305b.f324k;
        boolean z = c0090d.f304a == 3;
        int i4;
        if (z) {
            View a = c0090d.f306c.m369a(3);
            if (a != null) {
                i4 = -a.getWidth();
            } else {
                i4 = 0;
            }
            i4 += i3;
            view = a;
            i = i4;
        } else {
            i4 = c0090d.f306c.getWidth() - i3;
            view = c0090d.f306c.m369a(5);
            i = i4;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && c0090d.f306c.m368a(view) == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            c0090d.f305b.m482a(view, i, view.getTop());
            layoutParams.f276c = true;
            c0090d.f306c.invalidate();
            c0090d.m391b();
            DrawerLayout drawerLayout = c0090d.f306c;
            if (!drawerLayout.f282d) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                i = drawerLayout.getChildCount();
                while (i2 < i) {
                    drawerLayout.getChildAt(i2).dispatchTouchEvent(obtain);
                    i2++;
                }
                obtain.recycle();
                drawerLayout.f282d = true;
            }
        }
    }
}
