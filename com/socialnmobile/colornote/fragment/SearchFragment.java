package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.ab;
import android.support.v4.p000a.C0000d;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.view.az;
import com.socialnmobile.colornote.view.bu;

public class SearchFragment extends ScreenFragment implements ab {
    String f1194a;
    private ListView f1195b;
    private bu f1196c;

    public SearchFragment() {
        this.f1196c = new bu();
    }

    public final /* synthetic */ void m1508a(C0000d c0000d, Object obj) {
        this.f1195b.setAdapter(az.m2182a(this.f48C, (Cursor) obj, 1));
    }

    public static SearchFragment m1501a(String str) {
        SearchFragment searchFragment = new SearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("QUERY", str);
        searchFragment.m71f(bundle);
        return searchFragment;
    }

    public final void m1506a(Bundle bundle) {
        super.m1287a(bundle);
        if (this.f77q != null) {
            this.f1194a = this.f77q.getString("QUERY");
        }
    }

    public final int m1513t() {
        return 5;
    }

    public final void m1505a(Activity activity) {
        super.m1285a(activity);
    }

    public final View m1504a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903066, null);
        this.f1195b = (ListView) inflate.findViewById(2131623939);
        this.f1195b.setEmptyView(inflate.findViewById(2131624050));
        this.f1196c.m2204a(inflate, this);
        this.f1196c.m2202a(1);
        this.f1196c.m2203a(null);
        this.f1196c.m2205a("\"" + this.f1194a + "\"");
        this.f1195b.setOnItemClickListener(new cq(this));
        if (this.f1194a == null || "".equals(this.f1194a)) {
            this.f48C.onSearchRequested();
        } else {
            String str = this.f1194a;
            Bundle bundle2 = new Bundle();
            bundle2.putString("QUERY", str);
            m77l().m102a(0, bundle2, this);
        }
        return inflate;
    }

    public final void m1514u() {
        m1503z();
    }

    public final void m1515v() {
    }

    public final void m1516w() {
        if (m74h()) {
            m1211a(this.f48C);
            m1502a();
        }
    }

    public final void m1512o() {
        super.m78o();
        m1503z();
        if (this.ar.m684a((C0015f) this)) {
            m1502a();
        }
    }

    private void m1502a() {
        this.ar.m683a(this.aq);
    }

    public final void m1509a(C0326m c0326m) {
        c0326m.f1434f = m50a(2131230970);
        c0326m.m1703b(2131624155, 2130837613, 2131230970);
    }

    public final void m1511b(C0326m c0326m) {
    }

    public final boolean m1510a(int i, String str) {
        switch (i) {
            case 2131624155:
                this.f48C.onSearchRequested();
                return true;
            default:
                return false;
        }
    }

    private void m1503z() {
        C0262d a = C0209d.m875a(this.f48C);
        this.f1195b.setBackgroundColor(a.m1145n(3));
        TextView textView = (TextView) this.f63R.findViewById(2131624050);
        textView.setBackgroundColor(a.m1145n(3));
        textView.setTextColor(a.m1145n(8));
        this.f1196c.m2206b();
    }

    public final C0000d a_(Bundle bundle) {
        return new cr(this.f48C, bundle.getString("QUERY"));
    }

    public final void m1507a(C0000d c0000d) {
    }
}
