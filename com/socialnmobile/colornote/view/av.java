package com.socialnmobile.colornote.view;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public final class av extends CursorAdapter implements at {
    Context f2045a;
    int f2046b;
    float f2047c;

    public av(Context context, Cursor cursor) {
        super(context, cursor);
        this.f2045a = context;
    }

    public final void m2174a(int i) {
        this.f2046b = i;
    }

    public final void m2173a(float f) {
        this.f2047c = f;
    }

    public final void bindView(View view, Context context, Cursor cursor) {
        aw awVar = (aw) view.getTag();
        awVar.m2178a(this.f2046b);
        awVar.m2177a(this.f2047c);
        awVar.f2048a.m1058a(cursor);
        awVar.m2179b();
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(2130903088, null);
        inflate.setTag(new aw(inflate));
        return inflate;
    }
}
