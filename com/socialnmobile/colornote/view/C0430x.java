package com.socialnmobile.colornote.view;

import android.text.format.Time;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.socialnmobile.colornote.p006a.C0147f;

/* renamed from: com.socialnmobile.colornote.view.x */
final class C0430x extends SimpleOnGestureListener {
    final /* synthetic */ MonthView f2207a;

    C0430x(MonthView monthView) {
        this.f2207a = monthView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f2207a.f1902E = false;
        this.f2207a.al = 0;
        int abs = Math.abs(((int) motionEvent2.getX()) - ((int) motionEvent.getX()));
        int abs2 = Math.abs(((int) motionEvent2.getY()) - ((int) motionEvent.getY()));
        if (abs2 < MonthView.f1897z || abs2 < abs) {
            return false;
        }
        Time a = this.f2207a.f1912O;
        a.set(this.f2207a.f1908K);
        if (f2 < 0.0f) {
            a.month++;
        } else {
            a.month--;
        }
        C0147f.m660a(a);
        this.f2207a.f1899B.m2131a(a);
        return true;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.f2207a.f1902E = true;
        return true;
    }

    private void m2233a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        this.f2207a.f1915R.m2218a(this.f2207a.m2101a((int) motionEvent.getY()), this.f2207a.m2103b(x));
    }

    public final void onShowPress(MotionEvent motionEvent) {
        m2233a(motionEvent);
        this.f2207a.al = 1;
        this.f2207a.ae = 2;
        this.f2207a.invalidate();
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.f2207a.al != 0) {
            this.f2207a.al = 0;
            this.f2207a.ae = 1;
            this.f2207a.invalidate();
        }
        int x = (int) motionEvent.getX();
        int a = this.f2207a.m2101a((int) motionEvent.getY());
        x = this.f2207a.m2103b(x);
        if (this.f2207a.f1915R.isWithinCurrentMonth(a, x) && this.f2207a.f1898A != null) {
            this.f2207a.f1915R.m2218a(a, x);
            this.f2207a.f1898A.m2158b(this.f2207a.getSelectedTime());
        }
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f2207a.f1902E = false;
        if (this.f2207a.al != 0) {
            this.f2207a.al = 0;
            this.f2207a.ae = 1;
            this.f2207a.invalidate();
        }
        return true;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f2207a.f1902E) {
            m2233a(motionEvent);
            this.f2207a.f1902E = false;
            int x = (int) motionEvent.getX();
            int a = this.f2207a.m2101a((int) motionEvent.getY());
            x = this.f2207a.m2103b(x);
            this.f2207a.f1915R.m2218a(a, x);
            if (this.f2207a.f1915R.isWithinCurrentMonth(a, x)) {
                this.f2207a.al = 1;
                this.f2207a.ae = 1;
                this.f2207a.invalidate();
                if (this.f2207a.f1898A != null) {
                    this.f2207a.f1898A.m2157a(this.f2207a.getSelectedTime());
                }
            } else if (!(this.f2207a.f1915R.isWithinCurrentMonth(a, x) || this.f2207a.f1898A == null)) {
                this.f2207a.getSelectedTime();
            }
            this.f2207a.postDelayed(new C0431y(this), 100);
        }
        return true;
    }
}
