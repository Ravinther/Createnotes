package com.socialnmobile.colornote.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.socialnmobile.colornote.data.C0230t;
import java.util.List;

public final class au extends ArrayAdapter implements at {
    boolean f2042a;
    int f2043b;
    float f2044c;

    public au(Context context, List list) {
        super(context, 0, list);
        this.f2042a = false;
    }

    public final void m2172a(int i) {
        this.f2043b = i;
    }

    public final void m2171a(float f) {
        this.f2044c = f;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(2130903088, null);
            view.setTag(new aw(view));
        }
        if (this.f2042a) {
            view.findViewById(2131624117).setVisibility(8);
        }
        aw awVar = (aw) view.getTag();
        awVar.m2178a(this.f2043b);
        awVar.m2177a(this.f2044c);
        awVar.f2048a = (C0230t) getItem(i);
        awVar.m2179b();
        return view;
    }

    public final long getItemId(int i) {
        return ((C0230t) getItem(i)).f1002a;
    }
}
