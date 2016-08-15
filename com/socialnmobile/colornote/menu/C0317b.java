package com.socialnmobile.colornote.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0313j;
import java.util.ArrayList;

/* renamed from: com.socialnmobile.colornote.menu.b */
final class C0317b extends ArrayAdapter {
    final /* synthetic */ C0316a f1393a;
    private int f1394b;
    private boolean f1395c;

    public C0317b(C0316a c0316a, Context context, ArrayList arrayList, boolean z) {
        this.f1393a = c0316a;
        super(context, 0, arrayList);
        this.f1394b = -1;
        this.f1395c = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1393a.f1382b.inflate(2130903094, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(2131624092);
        TextView textView = (TextView) view.findViewById(2131624031);
        if (this.f1395c) {
            textView.setTextColor(-16777216);
        } else {
            textView.setTextColor(-1);
        }
        C0329p c0329p = (C0329p) getItem(i);
        textView.setText(c0329p.f1442c);
        if (c0329p.f1444e) {
            imageView.setVisibility(0);
            if (c0329p.f1446g) {
                imageView.setImageDrawable(c0329p.f1445f);
            } else {
                C0313j.m1646a(imageView.getResources(), imageView, c0329p.f1441b);
            }
        } else {
            imageView.setVisibility(8);
        }
        return view;
    }
}
