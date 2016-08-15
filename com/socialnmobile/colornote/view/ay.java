package com.socialnmobile.colornote.view;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.socialnmobile.colornote.data.C0230t;
import java.util.List;

public final class ay extends ArrayAdapter {
    public int f2061a;
    int f2062b;
    public Time f2063c;
    public List f2064d;

    public static ay m2180a(Context context, List list, int i) {
        return new ay(context, list, 1, i);
    }

    public static ay m2181b(Context context, List list, int i) {
        return new ay(context, list, 3, i);
    }

    private ay(Context context, List list, int i, int i2) {
        super(context, 0, list);
        this.f2064d = list;
        this.f2061a = i2;
        this.f2062b = i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            if (this.f2062b == 1) {
                view = from.inflate(2130903089, null);
            } else if (this.f2062b == 3) {
                view = from.inflate(2130903090, null);
            }
            view.setTag(new ba(view, this.f2062b));
        }
        ba baVar = (ba) view.getTag();
        if (this.f2063c != null) {
            int i3 = this.f2063c.year;
            i2 = this.f2063c.month;
            int i4 = this.f2063c.monthDay;
            baVar.f2077g = i3;
            baVar.f2078h = i2;
            baVar.f2079i = i4;
        }
        C0230t c0230t = (C0230t) getItem(i);
        i2 = this.f2061a;
        baVar.f2072b = c0230t;
        baVar.f2073c = i2;
        baVar.m2188a(i2);
        return view;
    }

    public final long getItemId(int i) {
        return ((C0230t) getItem(i)).f1002a;
    }
}
