package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.p007e.C0262d;

/* renamed from: com.socialnmobile.colornote.view.m */
public final class C0422m {
    public Context f2182a;
    public TextView f2183b;
    public TextView f2184c;
    public ImageView f2185d;
    public ImageView f2186e;
    public ImageView f2187f;
    private View f2188g;

    public C0422m(View view) {
        this.f2182a = view.getContext();
        this.f2188g = view;
        this.f2183b = (TextView) view.findViewById(2131624063);
        this.f2184c = (TextView) view.findViewById(2131624067);
        this.f2185d = (ImageView) view.findViewById(2131624065);
        this.f2186e = (ImageView) view.findViewById(2131624066);
        this.f2187f = (ImageView) view.findViewById(2131624064);
    }

    public final void m2215a() {
        this.f2188g.setVisibility(8);
    }

    public final void m2216a(int i) {
        C0262d a = C0209d.m875a(this.f2182a);
        int h = a.m1139h(i);
        this.f2188g.setBackgroundColor(a.m1133b(i));
        this.f2183b.setTextColor(h);
        this.f2184c.setTextColor(h);
        Drawable[] compoundDrawables = this.f2184c.getCompoundDrawables();
        if (compoundDrawables[0] != null) {
            compoundDrawables[0].setColorFilter(h, Mode.MULTIPLY);
        }
        this.f2185d.getDrawable().mutate().setColorFilter(h, Mode.MULTIPLY);
        this.f2186e.getDrawable().mutate().setColorFilter(h, Mode.MULTIPLY);
    }
}
