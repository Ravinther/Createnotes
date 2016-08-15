package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

public final class bo extends C0354c {
    public final at f1574a;
    public final ar f1575b;

    public bo() {
        this.f1574a = new at();
        this.f1575b = new ar();
    }

    public final void m1909a(bm bmVar, C0361e c0361e) {
        Object obj;
        int i = bmVar.f1568c;
        if (i == 0) {
            obj = "active";
        } else if (i == 1) {
            obj = "logout";
        } else if (i == 2) {
            obj = "wipeout-pending";
        } else if (i == 3) {
            obj = "wipeout-complete";
        } else {
            throw new IllegalArgumentException("invalid DeviceState.state: " + i);
        }
        c0361e.m1834a("created", bmVar.f1566a, bg.f1556d);
        c0361e.m1834a("last_synced", bmVar.f1567b, bg.f1556d);
        c0361e.m1833a("state", obj);
        c0361e.m1834a("authentication", bmVar.f1569d, this.f1574a);
        c0361e.m1834a("token", bmVar.f1570e, this.f1575b);
        c0361e.m1833a("realtimesync_token", bmVar.f1571f);
    }

    public final bm m1907a(C0361e c0361e) {
        int i;
        bg bgVar = (bg) c0361e.m1831a("created", bg.f1556d);
        bg bgVar2 = (bg) c0361e.m1831a("last_synced", bg.f1556d);
        String d = c0361e.m1838d("state");
        if (d.equals("active")) {
            i = 0;
        } else if (d.equals("logout")) {
            i = 1;
        } else if (d.equals("wipeout-pending")) {
            i = 2;
        } else if (d.equals("wipeout-complete")) {
            i = 3;
        } else {
            throw new IllegalArgumentException("invalid DeviceState.state" + d);
        }
        return new bm(bgVar, bgVar2, i, (as) c0361e.m1836b("authentication", this.f1574a), (aq) c0361e.m1832a("token", this.f1575b), c0361e.m1842h("realtimesync_token"));
    }
}
