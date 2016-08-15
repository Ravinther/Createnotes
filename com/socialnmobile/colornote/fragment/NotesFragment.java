package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.view.LayoutInflater;
import android.view.View;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.BackupTab;
import com.socialnmobile.colornote.activity.Main;
import com.socialnmobile.colornote.activity.Settings;
import com.socialnmobile.colornote.activity.SyncLogIn;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.C0235y;
import com.socialnmobile.colornote.data.NoteProvider;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.C0329p;
import com.socialnmobile.colornote.menu.C0330r;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.view.ScreenGridList;
import com.socialnmobile.colornote.view.bv;
import java.util.Iterator;

public class NotesFragment extends NoteListFragment implements C0235y {
    String f1182a;
    ScreenGridList f1183b;
    int f1184c;

    public final int m1473t() {
        return 1;
    }

    public final void m1458a(Bundle bundle) {
        super.m1306a(bundle);
        m76k();
    }

    public final void m1457a(Activity activity) {
        super.m1305a(activity);
    }

    public final View m1454a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903064, null);
        this.f1183b = (ScreenGridList) inflate.findViewById(2131624041);
        m1307a(inflate);
        ScreenGridList screenGridList = this.f1183b;
        screenGridList.m2148a((NoteListFragment) this, false, this.ab);
        screenGridList.setListener(this.aj);
        Context context = this.f48C;
        int intValue = Integer.valueOf(C0212b.m936a(context, "pref_default_sort_option", context.getString(2131231063))).intValue();
        if (intValue == 0) {
            intValue = C0212b.m934a(this.f48C, "LAST_SAVED_SORT_ORDER", 1);
        }
        screenGridList.setGridListViewOptions(intValue, 0, -1, 0, 0, C0212b.m934a(this.f48C, "LIST_VIEW_TYPE", 1), false, true);
        screenGridList.setMainTitle();
        screenGridList = this.f1183b;
        screenGridList.f2003f.setOnClickListener(new cg(this));
        screenGridList.f2013p = true;
        this.f1182a = null;
        if (NoteProvider.m880a(this.f48C) != null) {
            NoteProvider.m880a(this.f48C).m891a((C0235y) this);
        }
        return inflate;
    }

    public final void m1471p() {
        super.m1290p();
    }

    public final void m1467e() {
        super.m68e();
    }

    public final void m1466d(Bundle bundle) {
        super.m67d(bundle);
    }

    public final void m1469e(Bundle bundle) {
        super.m69e(bundle);
    }

    public final void m1470o() {
        int i;
        int i2 = 0;
        super.m78o();
        if (this.ar.m684a((C0015f) this)) {
            m1449D();
        }
        m1450b(this.f48C);
        this.f1183b.m2152b(false);
        if (C0210a.m894a(this.f48C, "ADD_NEW_CLICKED") != 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            View view;
            bv b = this.ar.m685b();
            while (i2 < 3) {
                if (b.f2131g[i2] == 2131624182) {
                    view = b.f2130f[i2];
                    break;
                }
                i2++;
            }
            view = null;
            if (view != null && C0229s.m1034a(this.f48C) == 0) {
                this.f1184c = 5;
                this.Y.post(new cf(this, view));
            }
        }
    }

    public final void m1472q() {
        super.m80q();
        if (NoteProvider.m880a(this.f48C) != null) {
            NoteProvider.m880a(this.f48C).m893b((C0235y) this);
        }
    }

    private void m1449D() {
        if (this.aq.f1435g == 2 || this.aq.f1435g == 3) {
            C0329p a = this.aq.m1697a(2131624155);
            if (a == null) {
                a = this.aq.m1697a(2131624157);
            }
            a.f1440a = 2131624155;
            a.f1441b = 2130837613;
            a.f1442c = 2131230970;
        }
        this.ar.m683a(this.aq);
    }

    public final void m1475v() {
        if (m74h()) {
            this.f1183b.m2152b(false);
        }
    }

    public final void m1476w() {
        if (m74h()) {
            m1211a(this.f48C);
            m1449D();
        }
    }

    public final boolean m1477x() {
        return this.ab.f1283c != 0;
    }

    public final boolean m1478y() {
        m1462b(0);
        return true;
    }

    public final void m1465c(int i) {
        m1468e(1021);
    }

    private void m1450b(Context context) {
        String i = C0212b.m949i(context);
        if (this.f1182a == null || !this.f1182a.equals(i)) {
            this.f1182a = i;
            C0209d.m875a(context);
            this.aa.m2206b();
            this.f1183b.m2150b();
        }
    }

    public final void m1452B() {
    }

    public final ScreenGridList m1451A() {
        return this.f1183b;
    }

    public final Uri m1479z() {
        return C0228r.f997a;
    }

    public final String m1453C() {
        return "LIST";
    }

    public final void m1459a(C0326m c0326m) {
        int i = c0326m.f1435g;
        c0326m.f1434f = m50a(2131231058);
        if (i == 2) {
            c0326m.m1703b(2131624182, 2130837587, 2131230818);
            c0326m.m1703b(2131624155, 2130837613, 2131230970);
            c0326m.m1698a(2131624091, 2130837592, 2131230823);
            c0326m.m1698a(2131624180, 2130837616, 2131231074);
            c0326m.m1698a(2131624181, 2130837625, 2131230849);
            c0326m.m1698a(2131624182, 2130837587, 2131230818);
            c0326m.m1698a(2131624183, 2130837612, 2131231071);
            c0326m.m1698a(2131624184, 2130837609, 2131231075);
            c0326m.m1698a(2131624185, 2130837608, 2131230976);
        } else if (i == 1) {
            c0326m.m1703b(2131624182, 2130837587, 2131230818);
            c0326m.m1705c(2131624091, 2130837592, 2131230823);
            c0326m.m1705c(2131624180, 2130837616, 2131231074);
            c0326m.m1705c(2131624181, 2130837625, 2131230849);
            c0326m.m1705c(2131624155, 2130837613, 2131230970);
            c0326m.m1705c(2131624183, 2130837612, 2131231071);
            c0326m.m1705c(2131624184, 2130837609, 2131231075);
            c0326m.m1705c(2131624185, 2130837608, 2131230976);
        } else if (i == 3) {
            c0326m.m1703b(2131624182, 2130837587, 2131230818);
            c0326m.m1703b(2131624155, 2130837613, 2131230970);
            c0326m.m1705c(2131624091, 2130837592, 2131230823);
            c0326m.m1705c(2131624180, 2130837616, 2131231074);
            c0326m.m1705c(2131624181, 2130837625, 2131230849);
            c0326m.m1705c(2131624155, 2130837613, 2131230970);
            c0326m.m1705c(2131624183, 2130837612, 2131231071);
            c0326m.m1705c(2131624184, 2130837609, 2131231075);
            c0326m.m1705c(2131624185, 2130837608, 2131230976);
        }
    }

    public final void m1463b(C0326m c0326m) {
        Iterator it = c0326m.m1702b(2131624181).iterator();
        while (it.hasNext()) {
            C0329p c0329p = (C0329p) it.next();
            switch (this.ab.f1284d) {
                case 1:
                    c0329p.m1706a(2130837625);
                    break;
                case 2:
                    c0329p.m1706a(2130837623);
                    break;
                case 3:
                    c0329p.m1706a(2130837622);
                    break;
                case 4:
                    c0329p.m1706a(2130837624);
                    break;
                default:
                    break;
            }
            c0329p.f1448i = true;
        }
        it = c0326m.m1702b(2131624180).iterator();
        while (it.hasNext()) {
            c0329p = (C0329p) it.next();
            c0329p.m1706a(C0313j.m1631a(this.ab.f1282b));
            c0329p.f1448i = true;
        }
        it = c0326m.m1702b(2131624091).iterator();
        while (it.hasNext()) {
            ((C0329p) it.next()).m1707a(C0313j.m1636a(this.f48C, this.ab.f1283c));
        }
        boolean a = C0367b.m1868a(this.f48C);
        it = c0326m.m1702b(2131624184).iterator();
        while (it.hasNext()) {
            ((C0329p) it.next()).f1447h = a;
        }
        Iterator it2 = c0326m.m1702b(2131624183).iterator();
        while (it2.hasNext()) {
            boolean z;
            c0329p = (C0329p) it2.next();
            if (a) {
                z = false;
            } else {
                z = true;
            }
            c0329p.f1447h = z;
        }
    }

    public final boolean m1461a(int i, String str) {
        switch (i) {
            case 2131624091:
                m1468e(1020);
                return true;
            case 2131624155:
                this.f48C.onSearchRequested();
                return true;
            case 2131624157:
                ScreenGridList screenGridList = this.f1183b;
                switch (screenGridList.f2008k.f1282b) {
                    case 0:
                        screenGridList.m2145a(1, true);
                        break;
                    case 1:
                        screenGridList.m2145a(5, true);
                        break;
                    case 2:
                        screenGridList.m2145a(3, true);
                        break;
                    case 3:
                        screenGridList.m2145a(4, true);
                        break;
                    case 4:
                        screenGridList.m2145a(1, true);
                        break;
                    case 5:
                        screenGridList.m2145a(2, true);
                        break;
                }
                m1449D();
                return true;
            case 2131624180:
                m1456a(2001, false);
                return true;
            case 2131624181:
                m1456a(2, false);
                return true;
            case 2131624182:
                m1456a(2005, false);
                return true;
            case 2131624183:
                m54a(new Intent(this.f48C, BackupTab.class));
                return true;
            case 2131624184:
                if (C0367b.m1868a(this.f48C)) {
                    ((Main) this.f48C).m714a(true, true, "MENU");
                } else {
                    m54a(new Intent(this.f48C, SyncLogIn.class));
                }
                return true;
            case 2131624185:
                m54a(new Intent(this.f48C, Settings.class));
                return true;
            default:
                return false;
        }
    }

    final void m1456a(int i, boolean z) {
        switch (i) {
            case 2:
                C0330r.m1709a(this.f48C, m1316d("MENU")).m1682a(this, this.f47B, this.ar.m685b().f2130f[0], z);
            default:
                super.m1304a(i, z);
        }
    }

    final void m1468e(int i) {
        this.Y.post(new ch(this, m1315d(i)));
    }

    public final void m1474u() {
        m1450b(this.f48C);
    }

    public final void m1455a() {
        this.f1183b.m2149a(false);
    }

    public final void m1460a(String str) {
        ColorNote.m648a(this.f48C, "LIST", "SORT_CHANGED", "Option", this.ab.f1282b, "FROM", str);
    }

    public final void m1464b(String str) {
        ColorNote.m648a(this.f48C, "LIST", "VIEW_CHANGED", "ViewType", this.ab.f1284d, "FROM", str);
    }

    public final void m1462b(int i) {
        this.f1183b.m2154c(i);
        ColorNote.m648a(this.f48C, "LIST", "COLOR_FILTER", "COLOR", String.valueOf(i), "FROM", "LIST");
    }
}
