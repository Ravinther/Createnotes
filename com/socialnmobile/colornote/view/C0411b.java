package com.socialnmobile.colornote.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.socialnmobile.colornote.C0267e;
import com.socialnmobile.colornote.data.C0214d;
import com.socialnmobile.colornote.data.C0218h;
import java.util.List;

/* renamed from: com.socialnmobile.colornote.view.b */
public final class C0411b extends ArrayAdapter {
    String f2068a;
    String f2069b;
    List f2070c;

    public C0411b(Context context, C0214d c0214d, List list) {
        super(context, 0, list);
        this.f2068a = C0214d.m968a();
        this.f2069b = C0214d.m985c();
        this.f2070c = c0214d.m996b();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0412c c0412c;
        int i2;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(2130903082, null);
            C0412c c0412c2 = new C0412c(this, view);
            view.setTag(c0412c2);
            c0412c = c0412c2;
        } else {
            c0412c = (C0412c) view.getTag();
        }
        C0218h c0218h = (C0218h) getItem(i);
        c0412c.f2138e = c0218h;
        c0412c.f2135b.setText(C0267e.m1197b(c0412c.f2134a.getContext(), c0218h.f957c));
        c0412c.f2137d.setText(String.valueOf(c0218h.f958d));
        switch (c0218h.f956b) {
            case 1:
                c0412c.f2136c.setText(2131230815);
                c0412c.f2136c.setTextColor(-256);
                break;
            case 2:
                c0412c.f2136c.setText(2131231028);
                c0412c.f2136c.setTextColor(-1);
                break;
            default:
                c0412c.f2136c.setText(2131230794);
                c0412c.f2136c.setTextColor(-65536);
                break;
        }
        if (c0218h.f961g.contains(c0412c.f2134a.f2068a)) {
            c0412c.f2139f.setVisibility(0);
        } else {
            c0412c.f2139f.setVisibility(8);
        }
        C0411b c0411b = c0412c.f2134a;
        List list = c0218h.f961g;
        if (list.contains(c0411b.f2069b)) {
            i2 = 1;
        } else {
            for (String contains : c0411b.f2070c) {
                if (list.contains(contains)) {
                    i2 = 1;
                }
            }
            i2 = 0;
        }
        if (i2 != 0) {
            c0412c.f2140g.setVisibility(0);
        } else {
            c0412c.f2140g.setVisibility(8);
        }
        return view;
    }
}
