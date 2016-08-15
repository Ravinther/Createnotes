package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.DialogFragment;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.Main;
import com.socialnmobile.colornote.activity.Settings;
import com.socialnmobile.colornote.activity.SyncLogIn;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0235y;
import com.socialnmobile.colornote.data.NoteProvider;
import com.socialnmobile.colornote.dialog.DialogFactory.DatePickerDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory.MonthDayDialogFragment;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.C0329p;
import com.socialnmobile.colornote.menu.C0330r;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.view.MonthView;
import com.socialnmobile.colornote.view.ScreenCalendar;
import com.socialnmobile.colornote.view.ScreenGridList;
import com.socialnmobile.colornote.view.bl;
import java.util.ArrayList;
import java.util.Iterator;

public class CalendarFragment extends NoteListFragment implements C0235y, bl {
    private static final Object f1168g;
    String f1169a;
    ScreenCalendar f1170b;
    Time f1171c;
    boolean f1172d;
    MonthDayDialogFragment f1173e;
    OnDateSetListener f1174f;

    public CalendarFragment() {
        this.f1174f = new C0300x(this);
    }

    static {
        f1168g = new Object();
    }

    public final int m1384t() {
        return 2;
    }

    public final void m1367a(Bundle bundle) {
        super.m1306a(bundle);
        m76k();
    }

    public final void m1366a(Activity activity) {
        super.m1305a(activity);
    }

    public final View m1363a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903062, null);
        this.f1170b = (ScreenCalendar) inflate.findViewById(2131624042);
        m1307a(inflate);
        ScreenCalendar screenCalendar = this.f1170b;
        ce ceVar = this.ab;
        screenCalendar.f1980a = this;
        screenCalendar.f1981b = this.aa;
        screenCalendar.f1981b.m2202a(3);
        screenCalendar.f1982c = this;
        screenCalendar.f1983d = (MonthView) screenCalendar.findViewById(2131624129);
        screenCalendar.f1983d.setOnDayClickListener(screenCalendar.f1987i);
        screenCalendar.f1983d.setParent(screenCalendar);
        screenCalendar.f1985f = ceVar;
        screenCalendar.f1985f.f1286f = 16;
        screenCalendar.f1984e = new ArrayList[32];
        for (int i = 0; i < screenCalendar.f1984e.length; i++) {
            screenCalendar.f1984e[i] = new ArrayList();
        }
        screenCalendar.f1983d.setMonthNotes(screenCalendar.f1984e);
        this.f1171c = screenCalendar.getTime();
        screenCalendar.setMainTitle();
        m1353O();
        m1353O();
        this.f1169a = null;
        if (NoteProvider.m880a(this.f48C) != null) {
            NoteProvider.m880a(this.f48C).m891a((C0235y) this);
        }
        return inflate;
    }

    public final void m1379e() {
        super.m68e();
    }

    public final void m1378d(Bundle bundle) {
        super.m67d(bundle);
        if (bundle != null && bundle.containsKey("selected_time")) {
            long j = bundle.getLong("selected_time");
            this.ag = new Time();
            this.ag.set(j);
        }
    }

    public final void m1381e(Bundle bundle) {
        super.m69e(bundle);
        if (this.ag != null) {
            bundle.putLong("selected_time", C0147f.m661a(this.ag, true));
        }
    }

    public final void m1382o() {
        super.m78o();
        if (this.ar.m684a((C0015f) this)) {
            m1352N();
        }
        m1356b(this.f48C);
        ScreenCalendar screenCalendar = this.f1170b;
        screenCalendar.f1983d.m2104b();
        screenCalendar.f1983d.m2106d();
    }

    public final void m1383q() {
        super.m80q();
        if (NoteProvider.m880a(this.f48C) != null) {
            NoteProvider.m880a(this.f48C).m893b((C0235y) this);
        }
    }

    private void m1352N() {
        this.ar.m683a(this.aq);
    }

    public final void m1386v() {
        if (m74h()) {
            m1353O();
        }
    }

    public final void m1387w() {
        if (m74h()) {
            m1211a(this.f48C);
            m1352N();
        }
    }

    public final boolean m1388x() {
        return this.ab.f1283c != 0;
    }

    public final boolean m1389y() {
        m1372b(0);
        return true;
    }

    public final void m1360D() {
        if (this.f1172d) {
            this.f1172d = false;
            if (this.ag != null) {
                m1380e(17);
            }
        } else if (this.f1173e != null && this.ag != null && this.f1173e.m74h()) {
            ScreenCalendar screenCalendar = this.f1170b;
            this.f1173e.m1106a(screenCalendar.f1984e[this.ag.monthDay], this.ag);
        }
    }

    public final void m1370a(String str) {
    }

    public final void m1375b(String str) {
    }

    public final void m1376c(int i) {
        switch (i) {
            case 2131624076:
                m1355Q();
            case 2131624077:
                m1380e(19);
            case 2131624078:
                m1354P();
            default:
        }
    }

    private void m1356b(Context context) {
        String i = C0212b.m949i(context);
        if (this.f1169a == null || !this.f1169a.equals(i)) {
            this.f1169a = i;
            C0209d.m875a(context);
            this.aa.m2206b();
            ScreenCalendar screenCalendar = this.f1170b;
            screenCalendar.setBackgroundColor(C0209d.m875a(screenCalendar.getContext()).m1145n(3));
            screenCalendar.f1983d.m2105c();
        }
    }

    private void m1353O() {
        int i;
        ScreenCalendar screenCalendar;
        Time time;
        if (this.f1170b.f1985f.f1281a != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            screenCalendar = this.f1170b;
            time = new Time();
            time.set(System.currentTimeMillis());
            time.monthDay = 1;
            C0147f.m660a(time);
            Time time2 = screenCalendar.f1983d.getTime();
            if (time2.year == time.year && time2.month == time.month) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                return;
            }
        }
        screenCalendar = this.f1170b;
        time = new Time();
        time.set(System.currentTimeMillis());
        time.monthDay = 1;
        time.hour = 0;
        time.minute = 0;
        time.second = 0;
        C0147f.m660a(time);
        screenCalendar.f1983d.setTime(time);
        screenCalendar.setMainTitle();
        this.f1171c = time;
        this.f1170b.m2128a();
    }

    public final void m1368a(Time time) {
        if (C0147f.m661a(time, true) < C0147f.m661a(this.f1171c, true)) {
            m1355Q();
        } else {
            m1354P();
        }
    }

    public final void m1358B() {
    }

    public final ScreenGridList m1357A() {
        return null;
    }

    public final Uri m1390z() {
        return C0228r.f997a;
    }

    public final String m1359C() {
        return "CALENDAR";
    }

    public final void m1373b(Time time) {
        this.ag = time;
        m1380e(17);
    }

    public final void m1361E() {
        int i = this.ag.month;
        Time time = this.ag;
        time.monthDay++;
        C0147f.m660a(this.ag);
        if (this.ag.month != i) {
            this.f1172d = true;
            m1354P();
            return;
        }
        m1380e(17);
    }

    public final void m1362F() {
        int i = this.ag.month;
        Time time = this.ag;
        time.monthDay--;
        C0147f.m660a(this.ag);
        if (this.ag.month != i) {
            this.f1172d = true;
            m1355Q();
            return;
        }
        m1380e(17);
    }

    public final void m1369a(C0326m c0326m) {
        int i = c0326m.f1435g;
        c0326m.f1434f = m50a(2131230741);
        if (i == 2) {
            c0326m.m1703b(2131624182, 2130837587, 2131230818);
            c0326m.m1703b(2131624155, 2130837613, 2131230970);
            c0326m.m1698a(2131624091, 2130837592, 2131230823);
            c0326m.m1698a(2131624180, 2130837616, 2131231074);
            c0326m.m1698a(2131624159, 2130837605, 2131231010);
            c0326m.m1698a(2131624182, 2130837587, 2131230818);
            c0326m.m1698a(2131624183, 2130837612, 2131231071);
            c0326m.m1698a(2131624184, 2130837609, 2131231075);
            c0326m.m1698a(2131624185, 2130837608, 2131230976);
        } else if (i == 1) {
            c0326m.m1703b(2131624182, 2130837587, 2131230818);
            c0326m.m1705c(2131624159, 2130837605, 2131231010);
            c0326m.m1705c(2131624091, 2130837592, 2131230823);
            c0326m.m1705c(2131624155, 2130837613, 2131230970);
            c0326m.m1705c(2131624183, 2130837612, 2131231071);
            c0326m.m1705c(2131624184, 2130837609, 2131231075);
            c0326m.m1705c(2131624185, 2130837608, 2131230976);
        } else if (i == 3) {
            c0326m.m1703b(2131624182, 2130837587, 2131230818);
            c0326m.m1703b(2131624155, 2130837613, 2131230970);
            c0326m.m1705c(2131624159, 2130837605, 2131231010);
            c0326m.m1705c(2131624091, 2130837592, 2131230823);
            c0326m.m1705c(2131624155, 2130837613, 2131230970);
            c0326m.m1705c(2131624183, 2130837612, 2131231071);
            c0326m.m1705c(2131624184, 2130837609, 2131231075);
            c0326m.m1705c(2131624185, 2130837608, 2131230976);
        }
    }

    public final void m1374b(C0326m c0326m) {
        Iterator it = c0326m.m1702b(2131624180).iterator();
        while (it.hasNext()) {
            ((C0329p) it.next()).f1448i = false;
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
            C0329p c0329p = (C0329p) it2.next();
            if (a) {
                z = false;
            } else {
                z = true;
            }
            c0329p.f1447h = z;
        }
    }

    public final boolean m1371a(int i, String str) {
        switch (i) {
            case 2131624091:
                m1380e(1020);
                return true;
            case 2131624117:
                m1380e(19);
                return true;
            case 2131624155:
                this.f48C.onSearchRequested();
                return true;
            case 2131624159:
                m1353O();
                Toast.makeText(this.f48C, m50a(2131231010) + " : " + DateUtils.formatDateTime(this.f48C, System.currentTimeMillis(), 32786), 1).show();
                return false;
            case 2131624182:
                this.ag = new Time();
                this.ag.set(System.currentTimeMillis());
                m1365a(10, false);
                return true;
            case 2131624183:
                m54a(new Intent(this.f48C, SyncLogIn.class));
                return true;
            case 2131624184:
                ((Main) this.f48C).m714a(true, true, "MENU");
                return true;
            case 2131624185:
                m54a(new Intent(this.f48C, Settings.class));
                return true;
            default:
                return false;
        }
    }

    public final void m1365a(int i, boolean z) {
        switch (i) {
            case 10:
                C0330r.m1710a(this.f48C, new C0301y(this), m50a(2131230818) + " [" + DateUtils.formatDateTime(this.f48C, C0147f.m661a(this.ag, true), 32786) + "]").m1682a(this, this.f47B, this.ar.m685b().f2130f[0], z);
            default:
                super.m1304a(i, z);
        }
    }

    final DialogFragment m1377d(int i) {
        switch (i) {
            case 17:
                ScreenCalendar screenCalendar = this.f1170b;
                this.f1173e = new MonthDayDialogFragment(this, screenCalendar.f1984e[this.ag.monthDay], this.ag);
                return this.f1173e;
            case 19:
                return new DatePickerDialogFragment(this.f1174f, this.f1171c.year, this.f1171c.month);
            default:
                return super.m1315d(i);
        }
    }

    final void m1380e(int i) {
        this.Y.post(new C0302z(this, m1377d(i)));
    }

    public final void m1385u() {
        m1356b(this.f48C);
    }

    public final void m1364a() {
        this.f1170b.m2128a();
    }

    private void m1354P() {
        ScreenCalendar screenCalendar = this.f1170b;
        Time time = new Time();
        time.set(screenCalendar.f1983d.getTime());
        time.month++;
        time.monthDay = 1;
        C0147f.m660a(time);
        screenCalendar.f1983d.setTime(time);
        screenCalendar.setMainTitle();
        this.f1171c = time;
        screenCalendar.m2128a();
    }

    private void m1355Q() {
        ScreenCalendar screenCalendar = this.f1170b;
        Time time = new Time();
        time.set(screenCalendar.f1983d.getTime());
        time.month--;
        time.monthDay = 1;
        C0147f.m660a(time);
        screenCalendar.f1983d.setTime(time);
        screenCalendar.setMainTitle();
        this.f1171c = time;
        screenCalendar.m2128a();
    }

    public final void m1372b(int i) {
        ScreenCalendar screenCalendar = this.f1170b;
        screenCalendar.f1985f.f1283c = i;
        screenCalendar.m2128a();
        screenCalendar.setMainTitle();
        ColorNote.m648a(this.f48C, "LIST", "COLOR_FILTER", "COLOR", String.valueOf(i), "FROM", "CALENDAR");
    }
}
