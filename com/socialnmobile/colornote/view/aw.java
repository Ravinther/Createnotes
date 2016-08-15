package com.socialnmobile.colornote.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.p012f.C0269a;

public final class aw implements ax {
    C0230t f2048a;
    private View f2049b;
    private TextView f2050c;
    private TextView f2051d;
    private ImageView f2052e;
    private ImageView f2053f;
    private View f2054g;
    private Context f2055h;
    private View f2056i;
    private View f2057j;
    private View f2058k;
    private int f2059l;
    private float f2060m;

    public aw(View view) {
        this.f2055h = view.getContext();
        this.f2049b = view;
        this.f2050c = (TextView) this.f2049b.findViewById(2131624096);
        this.f2052e = (ImageView) this.f2049b.findViewById(2131624112);
        this.f2051d = (TextView) this.f2049b.findViewById(2131624115);
        this.f2053f = (ImageView) this.f2049b.findViewById(2131624066);
        this.f2056i = this.f2049b.findViewById(2131624075);
        this.f2057j = this.f2049b.findViewById(2131624114);
        this.f2054g = this.f2049b.findViewById(2131624113);
        this.f2058k = this.f2049b.findViewById(2131624091);
        this.f2048a = new C0230t();
    }

    final void m2178a(int i) {
        if (this.f2059l != i) {
            this.f2059l = i;
            int dimensionPixelSize = this.f2055h.getResources().getDimensionPixelSize(2131361795);
            C0313j.m1648a(this.f2057j, (i - dimensionPixelSize) - this.f2055h.getResources().getDimensionPixelSize(2131361794));
            C0313j.m1648a(this.f2056i, dimensionPixelSize);
        }
    }

    final void m2177a(float f) {
        if (this.f2060m != f) {
            this.f2051d.setTextSize(0, f);
        }
    }

    public final C0230t m2176a() {
        return this.f2048a;
    }

    final void m2179b() {
        CharSequence a;
        String d = this.f2048a.m1062d();
        if (this.f2048a.f1007f == 16) {
            a = C0269a.m1202a(d);
        } else {
            a = new SpannableStringBuilder(d);
        }
        boolean a2 = this.f2048a.m1059a();
        int i = this.f2048a.f1011j;
        C0262d a3 = C0209d.m875a(this.f2055h);
        this.f2057j.setBackgroundColor(a3.m1133b(i));
        this.f2056i.setBackgroundColor(a3.m1133b(i));
        this.f2058k.setBackgroundColor(a3.m1142k(i));
        i = a3.m1138g(i);
        if (a2) {
            this.f2050c.setTextColor(C0313j.m1632a(102, i));
            this.f2051d.setTextColor(C0313j.m1632a(102, i));
        } else {
            this.f2050c.setTextColor(i);
            this.f2051d.setTextColor(C0313j.m1632a(221, i));
        }
        int i2 = this.f2048a.f1007f;
        if (i2 == 0) {
            this.f2052e.setImageDrawable(null);
            this.f2052e.setVisibility(8);
            this.f2054g.setVisibility(0);
        } else if (i2 == 16) {
            C0313j.m1646a(this.f2055h.getResources(), this.f2052e, 2130837683);
            this.f2052e.setVisibility(0);
            this.f2054g.setVisibility(8);
        }
        a2 = this.f2048a.m1059a();
        String str = this.f2048a.f1008g;
        int i3 = this.f2048a.f1012k;
        if (a2) {
            this.f2050c.setText(C0313j.m1639a(str));
        } else {
            this.f2050c.setText(str);
        }
        if (i3 != 0) {
            this.f2053f.setVisibility(0);
            this.f2051d.setText("");
        } else {
            this.f2051d.setText(a);
            this.f2053f.setVisibility(4);
        }
        long g = this.f2048a.m1065g();
        i = this.f2048a.f1014m;
        i3 = this.f2048a.f1015n;
        if (i == 32 && g > System.currentTimeMillis()) {
            C0313j.m1646a(this.f2055h.getResources(), this.f2052e, 2130837686);
            this.f2052e.setVisibility(0);
            this.f2054g.setVisibility(8);
        } else if (i == 16 && i3 == 144 && g > System.currentTimeMillis()) {
            C0313j.m1646a(this.f2055h.getResources(), this.f2052e, 2130837687);
            this.f2052e.setVisibility(0);
            this.f2054g.setVisibility(8);
        } else if (i == 16 && g > System.currentTimeMillis()) {
            C0313j.m1646a(this.f2055h.getResources(), this.f2052e, 2130837687);
            this.f2052e.setVisibility(0);
            this.f2054g.setVisibility(8);
        } else if (i == 128) {
            C0313j.m1646a(this.f2055h.getResources(), this.f2052e, 2130837688);
            this.f2052e.setVisibility(0);
            this.f2054g.setVisibility(8);
        }
        if (this.f2048a.m1059a()) {
            if (this.f2052e.getDrawable() != null) {
                this.f2052e.getDrawable().mutate().setAlpha(102);
            }
        } else if (this.f2052e.getDrawable() != null) {
            this.f2052e.getDrawable().mutate().setAlpha(255);
        }
        if (this.f2048a.m1060b()) {
            this.f2052e.setVisibility(0);
            this.f2054g.setVisibility(8);
            C0313j.m1646a(this.f2055h.getResources(), this.f2052e, 2130837682);
        }
        if (this.f2048a.f1004c != 0) {
            C0313j.m1646a(this.f2055h.getResources(), this.f2052e, 2130837685);
        }
    }
}
