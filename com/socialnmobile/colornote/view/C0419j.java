package com.socialnmobile.colornote.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0221k;
import com.socialnmobile.colornote.p007e.C0262d;
import java.util.List;

/* renamed from: com.socialnmobile.colornote.view.j */
public final class C0419j extends ArrayAdapter {
    Context f2174a;
    public boolean f2175b;

    public C0419j(Context context, List list) {
        super(context, 0, list);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0420k c0420k;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(2130903086, null);
            C0420k c0420k2 = new C0420k(this, view);
            view.setTag(c0420k2);
            c0420k = c0420k2;
        } else {
            c0420k = (C0420k) view.getTag();
        }
        C0221k c0221k = (C0221k) getItem(i);
        C0262d a = C0209d.m875a(c0420k.f2179d.f2174a);
        c0420k.f2176a.setTextColor(a.m1145n(13));
        c0420k.f2176a.setHintTextColor(C0313j.m1632a(64, a.m1145n(13)));
        c0420k.f2178c.setTextColor(a.m1143l(c0221k.f970b));
        if (c0420k.f2179d.f2175b) {
            c0420k.f2178c.setText(String.valueOf(c0221k.f971c));
            if (c0221k.f969a != null) {
                c0420k.f2176a.setText(c0221k.f969a);
            }
            c0420k.f2176a.setText("");
        } else {
            c0420k.f2178c.setText("");
            if (c0221k.f970b == 0) {
                c0420k.f2176a.setText(c0221k.f969a);
            }
            c0420k.f2176a.setText("");
        }
        c0420k.f2177b.setImageDrawable(C0313j.m1656b(c0420k.f2179d.getContext(), c0221k.f970b));
        return view;
    }

    public final long getItemId(int i) {
        return (long) ((C0221k) getItem(i)).f970b;
    }
}
