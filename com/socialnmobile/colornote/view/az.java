package com.socialnmobile.colornote.view;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public final class az extends CursorAdapter {
    Context f2065a;
    int f2066b;
    int f2067c;

    public static az m2182a(Context context, Cursor cursor, int i) {
        return new az(context, cursor, 1, i);
    }

    public static az m2183b(Context context, Cursor cursor, int i) {
        return new az(context, cursor, 3, i);
    }

    private az(Context context, Cursor cursor, int i, int i2) {
        super(context, cursor);
        this.f2065a = context;
        this.f2066b = i2;
        this.f2067c = i;
    }

    public final void bindView(View view, Context context, Cursor cursor) {
        ba baVar = (ba) view.getTag();
        int i = this.f2066b;
        baVar.f2072b.m1058a(cursor);
        baVar.f2073c = i;
        baVar.m2188a(i);
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate;
        if (this.f2067c == 1) {
            inflate = from.inflate(2130903089, null);
            inflate.setTag(new ba(inflate, this.f2067c));
            return inflate;
        } else if (this.f2067c != 3) {
            return null;
        } else {
            inflate = from.inflate(2130903090, null);
            inflate.setTag(new ba(inflate, this.f2067c));
            return inflate;
        }
    }
}
