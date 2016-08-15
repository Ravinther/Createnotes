package com.socialnmobile.colornote.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ab;
import android.support.v4.p000a.C0000d;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import com.socialnmobile.colornote.fragment.ce;
import com.socialnmobile.colornote.p006a.C0147f;
import java.util.ArrayList;

public class ScreenCalendar extends FrameLayout implements ab {
    static boolean f1978h;
    private static LayoutAnimationController f1979j;
    public NoteListFragment f1980a;
    public bu f1981b;
    public bl f1982c;
    public MonthView f1983d;
    public ArrayList[] f1984e;
    public ce f1985f;
    Handler f1986g;
    public aa f1987i;
    private int f1988k;

    public ScreenCalendar(Context context) {
        this(context, null);
    }

    public ScreenCalendar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static {
        f1978h = true;
    }

    public ScreenCalendar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1986g = new Handler();
        this.f1988k = 0;
        this.f1987i = new bi(this);
        if (f1979j == null) {
            f1979j = AnimationUtils.loadLayoutAnimation(context, 2130968578);
        }
        setAlwaysDrawnWithCacheEnabled(false);
    }

    public final void m2131a(Time time) {
        this.f1982c.m1350a(time);
    }

    private void m2126b() {
        for (ArrayList clear : this.f1984e) {
            clear.clear();
        }
    }

    public final void m2128a() {
        m2126b();
        if (this.f1980a.m74h()) {
            this.f1980a.m77l().m102a(2, null, this);
        }
    }

    private void m2127c() {
        for (ArrayList b : this.f1984e) {
            C0313j.m1662b(b);
        }
    }

    public void setTime(Time time) {
        this.f1983d.setTime(time);
    }

    public Time getTime() {
        return this.f1983d.getTime();
    }

    public void setMonth(Time time) {
        this.f1983d.setTime(time);
        setMainTitle();
    }

    public void setMainTitle() {
        this.f1981b.m2201a();
        this.f1981b.m2208c(this.f1985f.f1283c);
        this.f1981b.m2205a(DateUtils.formatDateTime(getContext(), C0147f.m661a(this.f1983d.getTime(), true), 52));
        this.f1981b.f2119e.setText("\u25b2");
        this.f1981b.f2121g.setText("\u25bc");
    }

    public final C0000d a_(Bundle bundle) {
        return new bm(getContext(), this);
    }

    public final void m2129a(C0000d c0000d) {
        this.f1985f.f1281a = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void m2130a(android.support.v4.p000a.C0000d r23, java.lang.Object r24) {
        /*
        r22 = this;
        r0 = r22;
        r2 = r0.f1985f;
        r2 = r2.f1281a;
        if (r2 == 0) goto L_0x0176;
    L_0x0008:
        r2 = 0;
        r0 = r22;
        r0.f1988k = r2;
        r0 = r22;
        r2 = r0.f1985f;
        r2 = r2.f1281a;
        r3 = new com.socialnmobile.colornote.view.bj;
        r0 = r22;
        r4 = r0.f1986g;
        r0 = r22;
        r3.<init>(r0, r4);
        r2.registerContentObserver(r3);
        r0 = r22;
        r2 = r0.f1985f;
        r14 = r2.f1281a;
        r22.m2126b();
        r15 = r22.getTime();
    L_0x002e:
        r2 = r14.moveToNext();
        if (r2 == 0) goto L_0x015d;
    L_0x0034:
        r16 = new com.socialnmobile.colornote.data.t;
        r0 = r16;
        r0.<init>(r14);
        r0 = r16;
        r3 = r0.f1015n;
        if (r3 != 0) goto L_0x0061;
    L_0x0041:
        r2 = r16.m1064f();
        r4 = new android.text.format.Time;
        r4.<init>();
        r4.set(r2);
        r2 = r4.month;
        r3 = r15.month;
        if (r2 != r3) goto L_0x002e;
    L_0x0053:
        r0 = r22;
        r2 = r0.f1984e;
        r3 = r4.monthDay;
        r2 = r2[r3];
        r0 = r16;
        r2.add(r0);
        goto L_0x002e;
    L_0x0061:
        r17 = new android.text.format.Time;
        r17.<init>();
        r18 = new android.text.format.Time;
        r18.<init>();
        r8 = r16.m1064f();
        r4 = r16.m1065g();
        r6 = r16.m1066h();
        r20 = r16.m1067i();
        r2 = 144; // 0x90 float:2.02E-43 double:7.1E-322;
        if (r3 != r2) goto L_0x019e;
    L_0x007f:
        r10 = 0;
        r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x019e;
    L_0x0085:
        r6 = 0;
        r10 = r4;
        r12 = r6;
    L_0x0089:
        r0 = r18;
        r0.set(r10);
        r4 = 0;
        r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x015a;
    L_0x0094:
        r0 = r18;
        r2 = r0.year;
        r4 = r15.year;
        if (r2 < r4) goto L_0x00ac;
    L_0x009c:
        r0 = r18;
        r2 = r0.year;
        r4 = r15.year;
        if (r2 != r4) goto L_0x015a;
    L_0x00a4:
        r0 = r18;
        r2 = r0.month;
        r4 = r15.month;
        if (r2 >= r4) goto L_0x015a;
    L_0x00ac:
        r4 = r10;
    L_0x00ad:
        r0 = r17;
        r0.set(r4);
    L_0x00b2:
        r0 = r17;
        r2 = r0.year;
        r6 = r15.year;
        if (r2 < r6) goto L_0x00ca;
    L_0x00ba:
        r0 = r17;
        r2 = r0.year;
        r6 = r15.year;
        if (r2 != r6) goto L_0x002e;
    L_0x00c2:
        r0 = r17;
        r2 = r0.month;
        r6 = r15.month;
        if (r2 > r6) goto L_0x002e;
    L_0x00ca:
        r0 = r17;
        r2 = r0.month;
        r6 = r15.month;
        if (r2 != r6) goto L_0x00e9;
    L_0x00d2:
        r0 = r17;
        r2 = r0.year;
        r6 = r15.year;
        if (r2 != r6) goto L_0x00e9;
    L_0x00da:
        r0 = r22;
        r2 = r0.f1984e;
        r0 = r17;
        r6 = r0.monthDay;
        r2 = r2[r6];
        r0 = r16;
        r2.add(r0);
    L_0x00e9:
        r2 = r22.getContext();
        r6 = 1;
        r6 = r6 + r4;
        r8 = 2;
        r4 = com.socialnmobile.colornote.C0310g.m1607a(r2, r3, r4, r6, r8);
        r0 = r17;
        r0.set(r4);
        r6 = 0;
        r2 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0142;
    L_0x0100:
        r6 = 0;
        r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0142;
    L_0x0106:
        r0 = r17;
        r2 = r0.year;
        r0 = r18;
        r6 = r0.year;
        if (r2 > r6) goto L_0x002e;
    L_0x0110:
        r0 = r17;
        r2 = r0.year;
        r0 = r18;
        r6 = r0.year;
        if (r2 != r6) goto L_0x0124;
    L_0x011a:
        r0 = r17;
        r2 = r0.month;
        r0 = r18;
        r6 = r0.month;
        if (r2 > r6) goto L_0x002e;
    L_0x0124:
        r0 = r17;
        r2 = r0.year;
        r0 = r18;
        r6 = r0.year;
        if (r2 != r6) goto L_0x0142;
    L_0x012e:
        r0 = r17;
        r2 = r0.month;
        r0 = r18;
        r6 = r0.month;
        if (r2 != r6) goto L_0x0142;
    L_0x0138:
        r0 = r17;
        r2 = r0.monthDay;
        r0 = r18;
        r6 = r0.monthDay;
        if (r2 > r6) goto L_0x002e;
    L_0x0142:
        r6 = 0;
        r2 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x014e;
    L_0x0148:
        r6 = 0;
        r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x002e;
    L_0x014e:
        r6 = 0;
        r2 = (r20 > r6 ? 1 : (r20 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00b2;
    L_0x0154:
        r2 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1));
        if (r2 < 0) goto L_0x002e;
    L_0x0158:
        goto L_0x00b2;
    L_0x015a:
        r4 = r8;
        goto L_0x00ad;
    L_0x015d:
        r22.m2127c();
        r0 = r22;
        r2 = r0.f1983d;
        r2.m2102a();
        r0 = r22;
        r2 = r0.f1983d;
        r2.m2106d();
        r0 = r22;
        r2 = r0.f1982c;
        r2.m1349D();
    L_0x0175:
        return;
    L_0x0176:
        r2 = "Couldn't load cursor in Calendar";
        com.socialnmobile.colornote.ColorNote.m651a(r2);
        r0 = r22;
        r2 = r0.f1988k;
        r3 = 15;
        if (r2 > r3) goto L_0x0175;
    L_0x0183:
        r0 = r22;
        r2 = r0.f1988k;
        r2 = r2 + 1;
        r0 = r22;
        r0.f1988k = r2;
        r0 = r22;
        r2 = r0.f1986g;
        r3 = new com.socialnmobile.colornote.view.bk;
        r0 = r22;
        r3.<init>(r0);
        r4 = 100;
        r2.postDelayed(r3, r4);
        goto L_0x0175;
    L_0x019e:
        r10 = r6;
        r12 = r4;
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.view.ScreenCalendar.a(android.support.v4.a.d, java.lang.Object):void");
    }
}
