package com.socialnmobile.colornote.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.socialnmobile.colornote.data.C0220j;
import java.util.List;

/* renamed from: com.socialnmobile.colornote.view.f */
public final class C0415f extends ArrayAdapter {
    public int f2157a;
    public int f2158b;
    boolean f2159c;

    public C0415f(Context context, List list, int i, boolean z) {
        super(context, 0, list);
        this.f2158b = i;
        this.f2159c = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0416g c0416g;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(2130903085, null);
            view.findViewById(2131624110).setFocusable(false);
            C0416g c0416g2 = new C0416g(this, view);
            view.setTag(c0416g2);
            c0416g = c0416g2;
        } else {
            c0416g = (C0416g) view.getTag();
        }
        c0416g.m2213a((C0220j) getItem(i));
        c0416g.f2160a.setTextSize((float) this.f2157a);
        return view;
    }
}
