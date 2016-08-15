package com.socialnmobile.colornote.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0220j;
import java.util.List;

/* renamed from: com.socialnmobile.colornote.view.d */
public final class C0413d extends ArrayAdapter {
    public int f2141a;
    boolean f2142b;
    public int f2143c;
    OnClickListener f2144d;
    OnClickListener f2145e;
    OnClickListener f2146f;

    public C0413d(Context context, List list, int i, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        super(context, 0, list);
        this.f2142b = C0212b.m940a(context, "pref_list_item_drag", context.getResources().getBoolean(2131296262));
        this.f2143c = i;
        this.f2145e = onClickListener;
        this.f2146f = onClickListener2;
        this.f2144d = onClickListener3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0414e c0414e;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(2130903083, null);
            view.findViewById(2131624106).setFocusable(false);
            view.findViewById(2131624105).setFocusable(false);
            view.findViewById(2131624108).setFocusable(false);
            C0414e c0414e2 = new C0414e(this, view, this.f2142b);
            view.setTag(c0414e2);
            c0414e = c0414e2;
        } else {
            c0414e = (C0414e) view.getTag();
        }
        C0220j c0220j = (C0220j) getItem(i);
        c0414e.m2211a(false, null);
        c0414e.f2148b.setText(c0220j.f964a);
        boolean a = c0220j.m1005a();
        int g = C0209d.m875a(c0414e.f2147a.getContext()).m1138g(c0414e.f2147a.f2143c);
        if (a) {
            c0414e.f2148b.setTextColor(C0313j.m1632a(102, g));
            c0414e.f2148b.setText(C0313j.m1639a(c0414e.f2148b.getText().toString()));
        } else {
            CharSequence charSequence = c0414e.f2148b.getText().toString();
            c0414e.f2148b.setTextColor(g);
            c0414e.f2148b.setText(charSequence);
        }
        OnClickListener onClickListener = this.f2145e;
        OnClickListener onClickListener2 = this.f2146f;
        OnClickListener onClickListener3 = this.f2144d;
        c0414e.f2152f.setTag(Integer.valueOf(i));
        c0414e.f2152f.setOnClickListener(onClickListener);
        c0414e.f2153g.setTag(Integer.valueOf(i));
        c0414e.f2153g.setOnClickListener(onClickListener2);
        c0414e.f2154h.setTag(Integer.valueOf(i));
        c0414e.f2154h.setOnClickListener(onClickListener3);
        c0414e.f2148b.setTextSize((float) this.f2141a);
        return view;
    }
}
