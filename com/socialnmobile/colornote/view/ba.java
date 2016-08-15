package com.socialnmobile.colornote.view;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.p012f.C0269a;
import java.util.Locale;

public final class ba implements ax {
    Context f2071a;
    C0230t f2072b;
    int f2073c;
    Time f2074d;
    Time f2075e;
    int f2076f;
    int f2077g;
    int f2078h;
    int f2079i;
    OnClickListener f2080j;
    OnClickListener f2081k;
    OnClickListener f2082l;
    private ViewGroup f2083m;
    private View f2084n;
    private TextView f2085o;
    private TextView f2086p;
    private View f2087q;
    private TextView f2088r;
    private ImageView f2089s;
    private ImageView f2090t;
    private ImageButton f2091u;
    private View f2092v;
    private int f2093w;

    public ba(View view, int i) {
        this.f2074d = new Time();
        this.f2075e = new Time();
        this.f2080j = new bb(this);
        this.f2081k = new bc(this);
        this.f2082l = new bd(this);
        this.f2083m = (ViewGroup) view;
        this.f2071a = this.f2083m.getContext();
        this.f2084n = this.f2083m.findViewById(2131624116);
        this.f2085o = (TextView) this.f2083m.findViewById(2131624096);
        this.f2086p = (TextView) this.f2083m.findViewById(2131624104);
        this.f2088r = (TextView) this.f2083m.findViewById(2131624117);
        this.f2087q = this.f2083m.findViewById(2131624091);
        this.f2089s = (ImageView) this.f2083m.findViewById(2131624112);
        this.f2090t = (ImageView) this.f2083m.findViewById(2131624065);
        this.f2091u = (ImageButton) this.f2083m.findViewById(2131624119);
        this.f2092v = this.f2083m.findViewById(2131624118);
        this.f2093w = i;
        this.f2072b = new C0230t();
        if (C0313j.m1653a(Locale.getDefault())) {
            this.f2088r.setGravity(21);
            this.f2088r.setPadding(0, 0, C0313j.m1664c(view.getContext(), 5), 0);
        } else {
            this.f2088r.setGravity(16);
            this.f2088r.setPadding(0, 0, 0, 0);
        }
        m2186b();
    }

    private void m2186b() {
        int b = C0212b.m941b(this.f2071a);
        if (this.f2076f != b) {
            this.f2076f = b;
            if (this.f2093w != 1) {
                this.f2088r.setTextSize(0, (float) this.f2071a.getResources().getDimensionPixelSize(2131361816));
            } else if (this.f2076f == 1) {
                this.f2088r.setTextSize(0, (float) this.f2071a.getResources().getDimensionPixelSize(2131361815));
            } else {
                this.f2088r.setTextSize(0, (float) this.f2071a.getResources().getDimensionPixelSize(2131361801));
            }
            b = C0212b.m944d(this.f2071a);
            this.f2085o.setMinHeight(b);
            if (this.f2093w == 1) {
                this.f2088r.setMinHeight(b);
            }
        }
    }

    public final C0230t m2187a() {
        return this.f2072b;
    }

    final void m2188a(int i) {
        m2186b();
        boolean a = this.f2072b.m1059a();
        int i2 = this.f2072b.f1011j;
        C0262d a2 = C0209d.m875a(this.f2071a);
        this.f2087q.setBackgroundColor(a2.m1142k(i2));
        this.f2084n.setBackgroundColor(a2.m1133b(i2));
        if (this.f2092v != null) {
            this.f2092v.setBackgroundColor(a2.m1145n(2));
        }
        i2 = a2.m1138g(i2);
        if (a) {
            this.f2085o.setTextColor(C0313j.m1632a(102, i2));
            if (this.f2086p != null) {
                this.f2086p.setTextColor(C0313j.m1632a(102, i2));
            }
        } else {
            this.f2085o.setTextColor(i2);
            if (this.f2086p != null) {
                this.f2086p.setTextColor(C0313j.m1632a(221, i2));
            }
        }
        if (i == 1) {
            m2184a(this.f2072b.f1010i, true, false);
        } else if (i == 2) {
            m2184a(this.f2072b.f1009h, true, false);
        } else if (i == 6) {
            m2184a(this.f2072b.m1066h(), true, false);
        }
        int i3 = this.f2072b.f1007f;
        if (i3 == 0) {
            this.f2089s.setImageDrawable(null);
        } else if (i3 == 16) {
            this.f2089s.setImageResource(2130837683);
        }
        CharSequence charSequence = this.f2072b.f1008g;
        this.f2085o.setTextColor(C0209d.m875a(this.f2071a).m1138g(this.f2072b.f1011j));
        this.f2085o.setGravity(8388629);
        this.f2085o.setGravity(8388627);
        this.f2085o.setText(charSequence);
        if (this.f2086p != null) {
            charSequence = this.f2072b.m1062d();
            if (this.f2086p != null) {
                if (this.f2072b.f1007f == 16) {
                    charSequence = C0269a.m1202a((String) charSequence);
                }
                this.f2086p.setText(SingleLineTransformationMethod.getInstance().getTransformation(charSequence, this.f2086p));
            }
        }
        if (this.f2072b.f1012k != 0) {
            this.f2089s.setImageResource(2130837684);
        }
        if (i == 4 || i == 5) {
            if (this.f2072b.f1014m == 16 || this.f2072b.f1014m != 32) {
                this.f2088r.setVisibility(8);
            } else {
                this.f2088r.setVisibility(0);
                m2184a(this.f2072b.m1064f(), true, true);
                this.f2088r.setTextColor(C0209d.m875a(this.f2071a).m1145n(1));
                if (i == 5) {
                    LayoutParams layoutParams = (LayoutParams) this.f2088r.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -1;
                    layoutParams.weight = 0.0f;
                    this.f2088r.setLayoutParams(layoutParams);
                }
            }
            this.f2091u.setVisibility(0);
            this.f2092v.setVisibility(0);
            if (i == 4) {
                this.f2091u.setImageResource(2130837582);
                this.f2091u.setBackgroundResource(2130837531);
                this.f2091u.setOnClickListener(this.f2080j);
            } else if (i == 5) {
                if (this.f2072b.m1065g() == 0) {
                    this.f2091u.setImageResource(2130837661);
                    this.f2091u.setBackgroundResource(2130837531);
                    this.f2091u.setOnClickListener(this.f2082l);
                } else if (m2189a(this.f2072b.m1065g())) {
                    this.f2091u.setImageResource(2130837662);
                    this.f2091u.setBackgroundResource(2130837531);
                    this.f2091u.setOnClickListener(this.f2081k);
                } else {
                    this.f2091u.setImageResource(2130837660);
                    this.f2091u.setBackgroundResource(2130837531);
                    this.f2091u.setOnClickListener(this.f2082l);
                }
            }
        } else if (i != 3) {
            this.f2088r.setVisibility(0);
            long g = this.f2072b.m1065g();
            int i4 = this.f2072b.f1014m;
            int i5 = this.f2072b.f1015n;
            if (i4 == 32 && g > System.currentTimeMillis()) {
                this.f2089s.setImageResource(2130837686);
                m2184a(g, true, false);
                this.f2088r.setTextColor(C0209d.m875a(this.f2071a).m1145n(1));
            } else if (i4 == 16 && i5 == 144 && g > System.currentTimeMillis()) {
                this.f2089s.setImageResource(2130837687);
                this.f2088r.setText(2131230887);
                this.f2088r.setTextColor(C0209d.m875a(this.f2071a).m1145n(1));
            } else if (i4 == 16 && g > System.currentTimeMillis()) {
                this.f2089s.setImageResource(2130837687);
                m2184a(g, false, false);
                this.f2088r.setTextColor(C0209d.m875a(this.f2071a).m1145n(1));
            } else if (i4 == 128) {
                this.f2089s.setImageResource(2130837688);
            }
        } else if (this.f2093w == 1) {
            this.f2088r.setVisibility(8);
            this.f2091u.setVisibility(8);
        }
        a = this.f2072b.m1059a();
        i2 = this.f2072b.f1011j;
        if (a) {
            this.f2085o.setTextColor(C0313j.m1632a(102, C0209d.m875a(this.f2071a).m1138g(i2)));
            this.f2085o.setText(C0313j.m1639a(this.f2085o.getText().toString()));
            this.f2088r.setTextColor(C0313j.m1632a(102, C0209d.m875a(this.f2071a).m1138g(i2)));
            if (this.f2089s.getDrawable() != null) {
                this.f2089s.getDrawable().mutate().setAlpha(102);
            }
            this.f2090t.getDrawable().mutate().setAlpha(102);
        } else {
            if (this.f2089s.getDrawable() != null) {
                this.f2089s.getDrawable().mutate().setAlpha(255);
            }
            this.f2090t.getDrawable().mutate().setAlpha(255);
        }
        if (this.f2072b.m1060b()) {
            this.f2089s.setVisibility(0);
            this.f2089s.setImageResource(2130837682);
        }
        if (this.f2072b.f1004c != 0) {
            this.f2089s.setImageResource(2130837685);
        }
        if (this.f2072b.f1015n == 0 || this.f2072b.m1065g() == 0) {
            this.f2090t.setVisibility(8);
        } else {
            this.f2090t.setVisibility(0);
        }
    }

    private void m2184a(long j, boolean z, boolean z2) {
        CharSequence formatDateTime;
        if (z2 || (z && DateUtils.isToday(j))) {
            formatDateTime = DateUtils.formatDateTime(this.f2071a, j, 1);
        } else if (this.f2093w == 1) {
            this.f2074d.set(j);
            this.f2075e.set(System.currentTimeMillis());
            formatDateTime = DateUtils.formatDateTime(this.f2071a, j, 65560);
            if (this.f2074d.year != this.f2075e.year) {
                formatDateTime = formatDateTime + "\n" + DateFormat.format("yyyy", j);
            }
        } else {
            formatDateTime = DateUtils.formatDateTime(this.f2071a, j, 65552);
        }
        this.f2088r.setText(formatDateTime);
        this.f2088r.setTypeface(Typeface.DEFAULT, 0);
        this.f2088r.setTextColor(C0209d.m875a(this.f2071a).m1145n(0));
    }

    public final boolean m2189a(long j) {
        Time time = new Time();
        time.set(j);
        return this.f2077g == time.year && this.f2078h == time.month && this.f2079i == time.monthDay;
    }

    static /* synthetic */ void m2185a(ba baVar) {
        Uri withAppendedId = ContentUris.withAppendedId(C0228r.f997a, baVar.f2072b.f1002a);
        if (baVar.f2072b.f1015n != 0) {
            C0229s.m1045a(baVar.f2071a, withAppendedId, System.currentTimeMillis(), baVar.f2072b.f1014m, baVar.f2072b.f1015n, baVar.f2072b.m1065g(), baVar.f2072b.m1067i(), true, true);
            Toast.makeText(baVar.f2071a, 2131230968, 1).show();
            return;
        }
        C0229s.m1042a(baVar.f2071a, withAppendedId, baVar.f2072b.f1014m);
        Toast.makeText(baVar.f2071a, 2131230952, 1).show();
    }
}
