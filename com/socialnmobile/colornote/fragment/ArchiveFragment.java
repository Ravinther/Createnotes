package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0267e;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.NoteProvider;
import com.socialnmobile.colornote.data.af;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.C0329p;
import com.socialnmobile.colornote.view.ScreenGridList;
import java.util.Iterator;

public class ArchiveFragment extends NoteListFragment {
    boolean f1160a;
    long f1161b;
    int f1162c;
    ScreenGridList f1163d;
    Spinner f1164e;
    Spinner f1165f;
    View f1166g;
    String f1167h;

    public ArchiveFragment() {
        this.f1160a = false;
        this.f1161b = 0;
        this.f1162c = 16;
    }

    public static ArchiveFragment m1325a(long j) {
        ArchiveFragment archiveFragment = new ArchiveFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("archive_time", j);
        archiveFragment.m71f(bundle);
        return archiveFragment;
    }

    public static ArchiveFragment m1324a() {
        ArchiveFragment archiveFragment = new ArchiveFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("archive_mode", 1);
        archiveFragment.m71f(bundle);
        return archiveFragment;
    }

    public final int m1342t() {
        return 4;
    }

    public final void m1331a(Activity activity) {
        super.m1305a(activity);
        if (this.f77q != null) {
            if (this.f77q.containsKey("archive_mode") && this.f77q.getInt("archive_mode") == 1) {
                m1298H();
                this.f1162c = -1;
            }
            if (this.f77q.containsKey("archive_time")) {
                this.f1160a = true;
                this.f1161b = this.f77q.getLong("archive_time");
                this.f1162c = 0;
            }
        }
    }

    public final void m1332a(Bundle bundle) {
        super.m1306a(bundle);
        m76k();
    }

    public final View m1330a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate;
        if (m1299I() == 0) {
            inflate = layoutInflater.inflate(2130903060, null);
        } else {
            inflate = layoutInflater.inflate(2130903061, null);
        }
        this.f1166g = inflate.findViewById(2131623959);
        this.f1163d = (ScreenGridList) inflate.findViewById(2131624041);
        this.f1164e = (Spinner) inflate.findViewById(2131624039);
        this.f1165f = (Spinner) inflate.findViewById(2131624040);
        m1307a(inflate);
        this.ab = new ce();
        this.f1163d.m2148a((NoteListFragment) this, this.f1160a, this.ab);
        this.f1163d.setListener(this.aj);
        this.f1163d.setGridListViewOptions(1, 0, -1, 0, this.f1162c, 1, false, true);
        SpinnerAdapter arrayAdapter = new ArrayAdapter(this.f48C, 17367048, m70f().getStringArray(2131099667));
        arrayAdapter.setDropDownViewResource(17367049);
        this.f1164e.setAdapter(arrayAdapter);
        this.f1164e.setOnItemSelectedListener(new C0298v(this));
        this.f1164e.setSelection(1);
        arrayAdapter = new ArrayAdapter(this.f48C, 17367048, m70f().getStringArray(2131099672));
        arrayAdapter.setDropDownViewResource(17367049);
        this.f1165f.setAdapter(arrayAdapter);
        this.f1165f.setOnItemSelectedListener(new C0299w(this));
        if (this.f1162c == 0) {
            this.f1165f.setSelection(1);
        } else if (this.f1162c == 16) {
            this.f1165f.setSelection(2);
        } else {
            this.f1165f.setSelection(0);
        }
        this.f1167h = null;
        this.f1163d.setMainTitle();
        return inflate;
    }

    public final void m1341q() {
        if (this.f1160a) {
            af a = af.m930a(this.f48C);
            if (a.f946c != null) {
                NoteProvider.m889c(a.m933b());
                a.f947d = null;
                a.f946c.close();
                a.f946c = null;
                a.m931a();
            }
        }
        super.m80q();
    }

    public final void m1340o() {
        super.m78o();
        m1326b(this.f48C);
        if (this.ar.m684a((C0015f) this)) {
            m1323E();
        }
    }

    private void m1326b(Context context) {
        String i = C0212b.m949i(context);
        if (this.f1167h == null || !this.f1167h.equals(i)) {
            this.f1167h = i;
            this.f1166g.setBackgroundColor(C0209d.m875a(context).m1145n(5));
            this.aa.m2206b();
            this.f1163d.m2150b();
        }
    }

    private void m1322D() {
        int i;
        int i2 = 0;
        switch (this.ab.f1285e) {
            case -1:
                i = 2130837588;
                break;
            case 0:
                i = 2130837593;
                break;
            case 16:
                i = 2130837604;
                break;
            default:
                i = 0;
                break;
        }
        C0329p a = this.aq.m1697a(2131624156);
        if (a != null) {
            a.m1706a(i);
        }
        C0329p a2 = this.aq.m1697a(2131624157);
        if (a2 != null) {
            switch (this.ab.f1282b) {
                case 1:
                    i2 = 2130837597;
                    break;
                case 2:
                    i2 = 2130837616;
                    break;
                case 3:
                    i2 = 2130837592;
                    break;
                case 4:
                    i2 = 2130837610;
                    break;
                case 5:
                    i2 = 2130837594;
                    break;
                case 7:
                    i2 = 2130837605;
                    break;
            }
            a2.m1706a(i2);
        }
    }

    private void m1323E() {
        m1322D();
        this.ar.m683a(this.aq);
    }

    public final void m1344v() {
    }

    public final void m1345w() {
        if (m74h()) {
            m1211a(this.f48C);
            m1323E();
        }
    }

    public final boolean m1346x() {
        return this.ab.f1283c != 0;
    }

    public final boolean m1347y() {
        m1336b(0);
        return true;
    }

    public final void m1339c(int i) {
        m1304a(2001, true);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (this.f1160a) {
            contextMenu.clear();
            contextMenu.add(0, 1015, 0, 2131231072).setOnMenuItemClickListener(this.ai);
        }
    }

    public final void m1333a(C0326m c0326m) {
        String a;
        int i = c0326m.f1435g;
        if (this.f1160a) {
            a = C0267e.m1196a(this.f48C, this.f1161b);
        } else {
            a = m50a(2131230891);
        }
        c0326m.f1434f = a;
        if (i == 2) {
            c0326m.m1703b(2131624156, 2130837588, 2131230834);
            c0326m.m1698a(2131624156, 2130837593, 2131230834);
            c0326m.m1698a(2131624157, 2130837618, 2131231074);
            c0326m.m1698a(2131624091, 2130837592, 2131230823);
        } else if (i == 1) {
            c0326m.m1703b(2131624156, 2130837588, 2131230834);
            c0326m.m1705c(2131624157, 2130837618, 2131231074);
            c0326m.m1705c(2131624091, 2130837592, 2131230823);
        } else if (i == 3) {
            c0326m.m1703b(2131624156, 2130837588, 2131230834);
            c0326m.m1705c(2131624157, 2130837618, 2131231074);
            c0326m.m1705c(2131624091, 2130837592, 2131230823);
        }
        m1322D();
    }

    public final void m1337b(C0326m c0326m) {
        Iterator it = c0326m.m1702b(2131624091).iterator();
        while (it.hasNext()) {
            ((C0329p) it.next()).m1707a(C0313j.m1636a(this.f48C, this.ab.f1283c));
        }
        it = c0326m.m1702b(2131624157).iterator();
        while (it.hasNext()) {
            ((C0329p) it.next()).m1706a(C0313j.m1631a(this.ab.f1282b));
        }
        it = c0326m.m1702b(2131624156).iterator();
        while (it.hasNext()) {
            ((C0329p) it.next()).m1706a(C0313j.m1654b(this.ab.f1285e));
        }
    }

    public final boolean m1335a(int i, String str) {
        switch (i) {
            case 2131624091:
                m1318e(1020);
                return true;
            case 2131624156:
                m1304a(2004, false);
                return true;
            case 2131624157:
                m1304a(2001, false);
                return true;
            default:
                return false;
        }
    }

    public final Uri m1348z() {
        if (this.f1160a) {
            return C0228r.f1000d;
        }
        return C0228r.f997a;
    }

    public final ScreenGridList m1327A() {
        return this.f1163d;
    }

    public final void m1328B() {
        m1323E();
    }

    public final void m1334a(String str) {
        m1323E();
    }

    public final void m1338b(String str) {
    }

    public final String m1329C() {
        return "ARCHIVE";
    }

    public final void m1343u() {
        m1326b(this.f48C);
    }

    public final void m1336b(int i) {
        this.f1163d.m2154c(i);
        ColorNote.m648a(this.f48C, "LIST", "COLOR_FILTER", "COLOR", String.valueOf(i), "FROM", "ARCHIVE");
    }
}
