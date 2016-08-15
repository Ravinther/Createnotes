package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.activity.Main;
import com.socialnmobile.colornote.activity.SyncStatus;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.sync.C0367b;
import java.util.ArrayList;
import java.util.HashMap;

public class SideMenuFragment extends C0015f {
    private static int f1197i;
    ListView f1198a;
    View f1199b;
    View f1200c;
    View f1201d;
    TextView f1202e;
    Main f1203f;
    ArrayList f1204g;
    cw f1205h;

    static {
        f1197i = 50;
    }

    public final void m1522a(Bundle bundle) {
        super.m56a(bundle);
    }

    public final void m1521a(Activity activity) {
        super.m53a(activity);
        this.f1203f = (Main) activity;
        this.f1205h = (cw) activity;
    }

    public final View m1519a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903067, null);
        this.f1200c = inflate.findViewById(2131623959);
        this.f1199b = inflate.findViewById(2131623936);
        this.f1201d = inflate.findViewById(2131624028);
        this.f1202e = (TextView) inflate.findViewById(2131624000);
        this.f1198a = (ListView) inflate.findViewById(2131623939);
        this.f1198a.setAdapter(m1518u());
        this.f1198a.setOnItemClickListener(new cs(this));
        inflate.findViewById(2131624052).setOnClickListener(new ct(this));
        inflate.findViewById(2131624051).setOnClickListener(new cu(this));
        return inflate;
    }

    public final void m1523o() {
        super.m78o();
        this.f1198a.setAdapter(m1518u());
        m1520a();
        if (C0367b.m1868a(this.f1203f)) {
            this.f1202e.setText(SyncStatus.m792a(C0367b.m1871c(this.f1203f)));
            return;
        }
        this.f1202e.setText(this.f1203f.getString(2131230889));
    }

    public final void m1520a() {
        C0262d a = C0209d.m875a(this.f48C);
        this.f1200c.setBackgroundColor(a.m1130a(0));
        this.f1198a.setBackgroundColor(a.m1130a(0));
        this.f1199b.setBackgroundColor(a.m1130a(0));
        this.f1201d.setBackgroundColor(a.m1130a(1));
        this.f1202e.setTextColor(a.m1130a(3));
        cv cvVar = (cv) this.f1198a.getAdapter();
        if (cvVar != null) {
            cvVar.notifyDataSetChanged();
        }
    }

    private ListAdapter m1518u() {
        this.f1204g = new ArrayList();
        m1517a(2130837545, 2131230893, 1, 20);
        m1517a(2130837543, 2131230741, 2, 20);
        m1517a(2130837542, 2131230891, 4, 20);
        m1517a(2130837550, 2131230948, 3, 20);
        m1517a(2130837547, 2131230970, 5, 20);
        m1517a(0, 0, 0, 20);
        m1517a(2130837549, 2131231003, 11, 20);
        m1517a(2130837546, 2131230976, 12, 20);
        m1517a(2130837544, 2131230811, 13, 16);
        return new cv(this, this.f48C, this.f1204g);
    }

    private void m1517a(int i, int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        if (i != 0) {
            hashMap.put("ICON", Integer.valueOf(i));
        }
        if (i2 != 0) {
            hashMap.put("TEXT", this.f48C.getString(i2));
        }
        hashMap.put("MENUID", Integer.valueOf(i3));
        hashMap.put("TEXTSIZE", Integer.valueOf(i4));
        this.f1204g.add(hashMap);
    }

    public final void m1524t() {
        if (this.f1198a != null) {
            this.f1198a.invalidateViews();
        }
    }
}
