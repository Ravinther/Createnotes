package com.socialnmobile.colornote.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0312i;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0220j;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.p013g.C0307e;

/* renamed from: com.socialnmobile.colornote.view.g */
public final class C0416g {
    TextView f2160a;
    public C0220j f2161b;
    Context f2162c;
    boolean f2163d;
    OnClickListener f2164e;
    OnClickListener f2165f;
    private C0415f f2166g;
    private ImageButton f2167h;
    private View f2168i;
    private View f2169j;
    private View f2170k;
    private View f2171l;

    public C0416g(C0415f c0415f, View view) {
        this.f2164e = new C0417h(this);
        this.f2165f = new C0418i(this);
        this.f2166g = c0415f;
        this.f2162c = view.getContext();
        this.f2169j = view;
        this.f2160a = (TextView) view.findViewById(2131624031);
        this.f2167h = (ImageButton) view.findViewById(2131624110);
        this.f2170k = view.findViewById(2131624109);
        this.f2171l = view.findViewById(2131624111);
        this.f2167h.setOnClickListener(this.f2165f);
        this.f2170k.setOnClickListener(this.f2164e);
        this.f2171l.setOnClickListener(this.f2164e);
        this.f2168i = view.findViewById(2131624028);
        int d = C0212b.m944d(this.f2162c);
        this.f2160a.setMinHeight(d);
        C0313j.m1648a(this.f2170k, d);
        C0313j.m1648a(this.f2171l, d);
        C0313j.m1661b(this.f2167h, C0312i.m1630d(this.f2162c));
    }

    public final void m2213a(C0220j c0220j) {
        this.f2161b = c0220j;
        C0262d a = C0209d.m875a(this.f2162c);
        int i = this.f2166g.f2158b;
        int g = a.m1138g(i);
        if (c0220j.m1005a()) {
            this.f2160a.setTextColor(C0313j.m1632a(102, g));
            this.f2160a.setText(C0313j.m1639a(c0220j.f964a));
            this.f2167h.setImageResource(2130837540);
            this.f2167h.setClickable(false);
            this.f2168i.setVisibility(8);
            this.f2163d = false;
            this.f2170k.setVisibility(8);
            this.f2171l.setVisibility(8);
            this.f2160a.setPadding(C0313j.m1664c(this.f2162c, 8), 0, 0, 0);
            return;
        }
        boolean z;
        this.f2160a.setTextColor(g);
        c0220j.m1002a(this.f2162c, this.f2166g.f2159c);
        if (c0220j.f967d == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2163d = z;
        if (this.f2163d) {
            c0220j.m1002a(this.f2162c, this.f2166g.f2159c);
            this.f2160a.setText(c0220j.f965b);
            this.f2168i.setBackgroundColor(a.m1135d(i));
            switch (((C0307e) this.f2161b.f968e.get(0)).f1359a) {
                case 1:
                    g = 2130837641;
                    break;
                case 2:
                    g = 2130837642;
                    break;
                case 3:
                    g = 2130837638;
                    break;
                case 4:
                    g = 2130837639;
                    break;
                case 5:
                    g = 2130837640;
                    break;
                default:
                    g = 0;
                    break;
            }
            this.f2167h.setImageResource(g);
            this.f2167h.setClickable(true);
            this.f2168i.setVisibility(0);
            this.f2170k.setVisibility(0);
            this.f2171l.setVisibility(8);
            this.f2160a.setPadding(C0313j.m1664c(this.f2162c, 8), 0, C0313j.m1664c(this.f2162c, 16), 0);
            return;
        }
        this.f2160a.setText(c0220j.f964a);
        this.f2167h.setImageResource(2130837539);
        this.f2167h.setClickable(false);
        this.f2168i.setVisibility(8);
        this.f2170k.setVisibility(8);
        this.f2171l.setVisibility(0);
        this.f2160a.setPadding(C0313j.m1664c(this.f2162c, 8), 0, 0, 0);
    }

    final void m2212a() {
        ViewParent parent = this.f2169j.getParent();
        if (parent != null) {
            while (!(parent instanceof ListView)) {
                parent = parent.getParent();
                if (parent == null) {
                    return;
                }
            }
            parent.showContextMenuForChild(this.f2169j);
        }
    }
}
