package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0312i;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.p007e.C0262d;

/* renamed from: com.socialnmobile.colornote.view.s */
public final class C0426s {
    public Context f2192a;
    public ViewGroup f2193b;
    public EditText f2194c;
    public MyImageButton f2195d;
    public MyImageButton f2196e;
    public MyImageButton f2197f;
    public MyImageButton f2198g;
    public GestureDetector f2199h;
    View f2200i;
    int f2201j;
    public boolean f2202k;
    public int f2203l;

    public C0426s(View view) {
        this.f2192a = view.getContext();
        this.f2193b = (ViewGroup) view;
        this.f2194c = (EditText) view.findViewById(2131624070);
        this.f2195d = (MyImageButton) view.findViewById(2131624072);
        this.f2196e = (MyImageButton) view.findViewById(2131624071);
        this.f2197f = (MyImageButton) view.findViewById(2131624073);
        this.f2198g = (MyImageButton) view.findViewById(2131624068);
        this.f2200i = view.findViewById(2131624069);
    }

    public final void m2224a() {
        int i;
        if (C0312i.m1628b(this.f2192a) >= 400) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            this.f2200i.setVisibility(8);
            this.f2198g.setVisibility(0);
            if (this.f2203l == 1) {
                this.f2198g.setImageResource(2130837571);
            } else {
                this.f2198g.setImageResource(2130837565);
            }
        } else {
            this.f2200i.setVisibility(0);
            this.f2198g.setVisibility(8);
        }
        i = C0312i.m1630d(this.f2192a);
        C0313j.m1661b(this.f2198g, i);
        C0313j.m1661b(this.f2195d, i);
        C0313j.m1661b(this.f2196e, i);
        C0313j.m1661b(this.f2197f, i);
    }

    public final void m2228a(CharSequence charSequence) {
        this.f2194c.setTextKeepState(charSequence);
    }

    public final String m2229b() {
        return this.f2194c.getText().toString().trim();
    }

    public final void m2226a(int i, C0262d c0262d, int i2) {
        CharSequence b = m2229b();
        switch (i) {
            case 1:
                m2228a(b);
                this.f2194c.setTextColor(-16777216);
            case 2:
                m2228a(C0313j.m1639a((String) b));
                this.f2194c.setTextColor(C0313j.m1632a(102, c0262d.m1137f(i2)));
            case 3:
                m2228a(b);
                this.f2194c.setTextColor(c0262d.m1137f(i2));
            default:
        }
    }

    public final void m2227a(OnClickListener onClickListener) {
        this.f2196e.setOnClickListener(onClickListener);
    }

    public final void m2231b(OnClickListener onClickListener) {
        this.f2195d.setOnClickListener(onClickListener);
    }

    public final void m2225a(int i) {
        this.f2201j = i;
        switch (i) {
            case 1:
                this.f2195d.setImageResource(2130837570);
            case 2:
                this.f2195d.setImageResource(2130837570);
            case 3:
                this.f2195d.setEnabled(false);
                this.f2195d.setImageDrawable(null);
                this.f2195d.setImageResource(2130837566);
            case 4:
                this.f2195d.setImageResource(2130837568);
            default:
        }
    }

    public final void m2232c() {
        this.f2195d.setEnabled(false);
        this.f2196e.setVisibility(8);
    }

    public final void m2230b(int i) {
        C0262d a = C0209d.m875a(this.f2192a);
        this.f2193b.setBackgroundColor(a.m1134c(i));
        GradientDrawable gradientDrawable = (GradientDrawable) this.f2196e.getDrawable();
        if (gradientDrawable != null) {
            gradientDrawable.setColor(a.m1136e(i));
        }
    }
}
