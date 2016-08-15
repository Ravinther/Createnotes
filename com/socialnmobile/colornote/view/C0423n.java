package com.socialnmobile.colornote.view;

import android.util.MonthDisplayHelper;

/* renamed from: com.socialnmobile.colornote.view.n */
public final class C0423n extends MonthDisplayHelper {
    int f2189a;
    int f2190b;

    public C0423n(int i, int i2, int i3, int i4) {
        super(i, i2, i4);
        this.f2189a = getRowOf(i3);
        this.f2190b = getColumnOf(i3);
    }

    public final void m2218a(int i, int i2) {
        this.f2189a = i;
        this.f2190b = i2;
    }

    public final int m2217a() {
        return getDayAt(this.f2189a, this.f2190b);
    }

    public final boolean m2220b(int i, int i2) {
        return this.f2189a == i && this.f2190b == i2;
    }

    public final boolean m2219b() {
        if (isWithinCurrentMonth(this.f2189a - 1, this.f2190b)) {
            this.f2189a--;
            return false;
        }
        previousMonth();
        this.f2189a = 5;
        while (!isWithinCurrentMonth(this.f2189a, this.f2190b)) {
            this.f2189a--;
        }
        return true;
    }

    public final boolean m2221c() {
        if (isWithinCurrentMonth(this.f2189a + 1, this.f2190b)) {
            this.f2189a++;
            return false;
        }
        nextMonth();
        this.f2189a = 0;
        while (!isWithinCurrentMonth(this.f2189a, this.f2190b)) {
            this.f2189a++;
        }
        return true;
    }

    public final boolean m2222d() {
        if (this.f2190b == 0) {
            this.f2189a--;
            this.f2190b = 6;
        } else {
            this.f2190b--;
        }
        if (isWithinCurrentMonth(this.f2189a, this.f2190b)) {
            return false;
        }
        previousMonth();
        int numberOfDaysInMonth = getNumberOfDaysInMonth();
        this.f2189a = getRowOf(numberOfDaysInMonth);
        this.f2190b = getColumnOf(numberOfDaysInMonth);
        return true;
    }

    public final boolean m2223e() {
        if (this.f2190b == 6) {
            this.f2189a++;
            this.f2190b = 0;
        } else {
            this.f2190b++;
        }
        if (isWithinCurrentMonth(this.f2189a, this.f2190b)) {
            return false;
        }
        nextMonth();
        this.f2189a = 0;
        this.f2190b = 0;
        while (!isWithinCurrentMonth(this.f2189a, this.f2190b)) {
            this.f2190b++;
        }
        return true;
    }
}
