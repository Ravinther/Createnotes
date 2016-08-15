package com.socialnmobile.colornote.view;

import android.support.v4.app.C0015f;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.p007e.C0262d;

public final class bu {
    C0015f f2115a;
    View f2116b;
    View f2117c;
    View f2118d;
    TextView f2119e;
    TextView f2120f;
    TextView f2121g;
    TextView f2122h;
    View f2123i;
    int f2124j;

    public bu() {
        this.f2124j = 0;
    }

    public final void m2204a(View view, C0015f c0015f) {
        this.f2116b = view;
        this.f2115a = c0015f;
        this.f2117c = view.findViewById(2131624074);
        this.f2118d = view.findViewById(2131624075);
        this.f2120f = (TextView) view.findViewById(2131624077);
        this.f2119e = (TextView) view.findViewById(2131624076);
        this.f2121g = (TextView) view.findViewById(2131624078);
        this.f2122h = (TextView) view.findViewById(2131624080);
        this.f2123i = view.findViewById(2131624079);
    }

    public final void m2202a(int i) {
        if (i == 1) {
            this.f2120f.setVisibility(0);
            this.f2119e.setVisibility(8);
            this.f2121g.setVisibility(8);
        } else if (i == 3) {
            this.f2120f.setVisibility(0);
            this.f2119e.setVisibility(0);
            this.f2121g.setVisibility(0);
        }
    }

    public final void m2203a(OnClickListener onClickListener) {
        this.f2120f.setOnClickListener(onClickListener);
        this.f2119e.setOnClickListener(onClickListener);
        this.f2121g.setOnClickListener(onClickListener);
    }

    public final void m2201a() {
        if (this.f2122h != null) {
            this.f2122h.setVisibility(8);
        }
    }

    public final void m2205a(String str) {
        this.f2120f.setText(str);
    }

    public final void m2207b(int i) {
        this.f2123i.setBackgroundColor(i);
    }

    public final void m2208c(int i) {
        this.f2124j = i;
        C0262d a = C0209d.m875a(this.f2116b.getContext());
        if (i == 0) {
            i = 0;
        }
        this.f2118d.setBackgroundColor(a.m1134c(i));
        this.f2120f.setTextColor(a.m1137f(i));
        this.f2119e.setTextColor(a.m1137f(i));
        this.f2121g.setTextColor(a.m1137f(i));
    }

    public final void m2206b() {
        m2208c(this.f2124j);
    }
}
