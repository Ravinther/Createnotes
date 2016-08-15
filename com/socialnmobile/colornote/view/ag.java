package com.socialnmobile.colornote.view;

import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;

public final class ag implements C0410a {
    static final ah f2023a;
    TextView f2024b;

    static {
        if (VERSION.SDK_INT >= 11) {
            f2023a = new ah();
        } else {
            f2023a = null;
        }
    }

    public final boolean m2160a(MenuItem menuItem) {
        if (f2023a != null) {
            return ah.m2161a(this.f2024b, menuItem);
        }
        return false;
    }

    public final boolean m2159a(MenuInflater menuInflater, Menu menu) {
        if (f2023a != null) {
            boolean z;
            TextView textView = this.f2024b;
            menuInflater.inflate(2131558417, menu);
            MenuItem findItem = menu.findItem(2131624178);
            if (VERSION.SDK_INT >= 16 || (VERSION.SDK_INT >= 11 && VERSION.SDK_INT < 14)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                findItem.setIcon(2130837563);
            } else if (C0209d.m875a(textView.getContext()).m1131a()) {
                findItem.setIcon(2130837564);
            } else {
                findItem.setIcon(2130837563);
            }
        }
        return true;
    }
}
