package com.socialnmobile.colornote.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.p007e.C0262d;
import java.util.ArrayList;
import java.util.HashMap;

final class cv extends ArrayAdapter {
    final /* synthetic */ SideMenuFragment f1306a;

    public cv(SideMenuFragment sideMenuFragment, Context context, ArrayList arrayList) {
        this.f1306a = sideMenuFragment;
        super(context, 0, arrayList);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final boolean isEnabled(int i) {
        if (((Integer) ((HashMap) getItem(i)).get("MENUID")).intValue() == 0) {
            return false;
        }
        return true;
    }

    public final int getItemViewType(int i) {
        if (((Integer) ((HashMap) getItem(i)).get("MENUID")).intValue() == 0) {
            return 0;
        }
        return 1;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0262d a = C0209d.m875a(getContext());
        if (getItemViewType(i) == 0) {
            return view == null ? LayoutInflater.from(this.f1306a.f48C).inflate(2130903098, viewGroup, false) : view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.f1306a.f48C).inflate(2130903097, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(2131624031);
            ImageView imageView = (ImageView) view.findViewById(2131624092);
            HashMap hashMap = (HashMap) getItem(i);
            String str = (String) hashMap.get("TEXT");
            Integer num = (Integer) hashMap.get("ICON");
            int intValue = ((Integer) hashMap.get("MENUID")).intValue();
            int intValue2 = ((Integer) hashMap.get("TEXTSIZE")).intValue();
            textView.setText(str);
            C0313j.m1646a(getContext().getResources(), imageView, num.intValue());
            if (((cp) this.f1306a.f1203f.m719c()).m1278t() == intValue) {
                textView.setTextColor(a.m1130a(4));
                view.setBackgroundColor(a.m1130a(5));
            } else {
                textView.setTextColor(a.m1130a(3));
                view.setBackgroundColor(0);
            }
            textView.setTextSize((float) intValue2);
            return view;
        }
    }
}
