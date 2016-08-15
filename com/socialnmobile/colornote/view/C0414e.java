package com.socialnmobile.colornote.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;

/* renamed from: com.socialnmobile.colornote.view.e */
public final class C0414e {
    C0413d f2147a;
    TextView f2148b;
    TextView f2149c;
    View f2150d;
    View f2151e;
    View f2152f;
    View f2153g;
    View f2154h;
    private View f2155i;
    private View f2156j;

    public C0414e(C0413d c0413d, View view, boolean z) {
        this.f2147a = c0413d;
        this.f2155i = view;
        this.f2148b = (TextView) view.findViewById(2131624031);
        this.f2149c = (TextView) view.findViewById(2131624102);
        this.f2150d = view.findViewById(2131624103);
        this.f2151e = view.findViewById(2131624104);
        this.f2152f = view.findViewById(2131624106);
        this.f2153g = view.findViewById(2131624105);
        this.f2154h = view.findViewById(2131624108);
        this.f2156j = view.findViewById(2131624107);
        if (z) {
            if (this.f2152f != null) {
                this.f2152f.setVisibility(8);
                this.f2153g.setVisibility(8);
            }
        } else if (this.f2156j != null) {
            this.f2156j.setVisibility(8);
        }
        if (this.f2148b != null) {
            this.f2148b.setMinHeight(C0212b.m944d(view.getContext()));
        }
        if (this.f2149c != null) {
            this.f2149c.setMinHeight(C0212b.m944d(view.getContext()));
        }
    }

    public final void m2211a(boolean z, Drawable drawable) {
        C0313j.m1648a(this.f2155i, -2);
        if (z) {
            this.f2149c.setVisibility(0);
            this.f2150d.setVisibility(0);
            this.f2151e.setVisibility(0);
            this.f2150d.setBackgroundDrawable(drawable);
            return;
        }
        this.f2149c.setVisibility(8);
        this.f2150d.setVisibility(8);
        this.f2151e.setVisibility(0);
    }
}
