package com.socialnmobile.colornote.sync;

import android.content.ContentValues;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.colornote.data.C0232v;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.data.aa;
import com.socialnmobile.colornote.p012f.C0268b;
import com.socialnmobile.colornote.p012f.C0269a;
import com.socialnmobile.colornote.p012f.C0270c;
import com.socialnmobile.colornote.p012f.C0271d;
import com.socialnmobile.colornote.sync.p018b.C0357a;
import com.socialnmobile.colornote.sync.p018b.C0360d;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p020d.C0380e;
import com.socialnmobile.util.p011b.C0473n;
import com.socialnmobile.util.service.C0479f;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class ba {
    final C0231u f1543a;
    final aa f1544b;
    final Cursor f1545c;
    final cq f1546d;
    final cn f1547e;
    final cp f1548f;
    final cs f1549g;
    final C0361e f1550h;
    final dm f1551i;

    public ba(C0231u c0231u, C0361e c0361e, Set set, cq cqVar) {
        this.f1548f = cp.f1636d;
        this.f1549g = cs.f1643a;
        this.f1551i = new dm();
        this.f1543a = c0231u;
        this.f1544b = new aa(c0231u);
        this.f1550h = c0361e;
        Number g = c0361e.m1841g("MAX_CHECKINS_PER_REQUEST");
        if (g != null) {
            this.f1544b.m905a(g.intValue(), set);
            this.f1545c = this.f1544b.m911a(null, aa.f926h);
            this.f1546d = cqVar;
            this.f1547e = new cn(cqVar);
            return;
        }
        throw new IllegalArgumentException("sessionParams: no MAX_CHECKINS_PER_REQUEST");
    }

    final C0360d m1883a(Cursor cursor, cq cqVar) {
        if (cursor == null) {
            throw new IllegalArgumentException("c is null");
        }
        C0360d c0360d = new C0360d();
        co coVar = new co();
        coVar.m1851c(cursor);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            c0360d.add(m1882a(coVar, cqVar));
        }
        return c0360d;
    }

    private C0361e m1882a(co coVar, cq cqVar) {
        if (cqVar == null) {
            throw new IllegalArgumentException("nek is null");
        }
        Object obj;
        C0361e c0361e = new C0361e();
        Object c0361e2 = new C0361e();
        cp cpVar = this.f1548f;
        c0361e.m1833a("cid", coVar.f1634e);
        dk.m1994a(coVar.a, c0361e);
        cy cyVar = cpVar.f1638b;
        cw cwVar = coVar.b;
        c0361e.m1833a("color", Integer.valueOf(((Integer) cwVar.f1661g.m2010c()).intValue()));
        c0361e.m1834a("created", (bg) cwVar.f1662h.m2010c(), bg.f1556d);
        c0361e.m1833a("flags", Integer.valueOf(((Integer) cwVar.f1656b.m2010c()).intValue()));
        c0361e.m1833a("folder", Integer.valueOf(((Integer) cwVar.f1657c.m2010c()).intValue()));
        c0361e.m1834a("modified_minor", (bg) cwVar.f1663i.m2010c(), bg.f1556d);
        c0361e.m1833a("state", cy.m1979a(((Integer) cwVar.f1659e.m2010c()).intValue(), ((Integer) cwVar.f1655a.m2010c()).intValue()));
        c0361e.m1833a(NoteMinorColumns.TYPE, cy.m1978a(((Integer) cwVar.f1660f.m2010c()).intValue()));
        c0361e.m1833a("version", Integer.valueOf(((Integer) cwVar.f1664j.m2010c()).intValue()));
        c0361e.m1833a("reminder", cy.m1977a(cwVar.f1665k));
        if ((((Integer) coVar.f1635f.f1770b.m2010c()).intValue() & 1) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null || ((Long) coVar.a.f1734b.m2010c()).longValue() == 0) {
            cv cvVar = cpVar.f1639c;
            ct ctVar = coVar.c;
            obj = (String) ctVar.f1645b.m2010c();
            c0361e.m1833a("content", obj);
            Object obj2 = (String) ctVar.f1644a.m2010c();
            c0361e.m1833a(NoteMajorColumns.TITLE, obj2);
            bg bgVar = (bg) ctVar.f1647d.m2010c();
            c0361e.m1834a("modified", bgVar, bg.f1556d);
            cv.m1976a(c0361e, "locked", ((Integer) ctVar.f1646c.m2010c()).intValue());
            if (obj == null) {
                C0311h.f1370a.m1622a("NoteMajorFormatV1.format problem", "content is null", c0361e);
            }
            if (obj2 == null) {
                C0311h.f1370a.m1622a("NoteMajorFormatV1.format problem", "title is null", c0361e);
            }
            if (bgVar == null) {
                C0311h.f1370a.m1622a("NoteMajorFormatV1.format problem", "modified is null", c0361e);
            }
        }
        try {
            cn cnVar = this.f1547e;
            String h = c0361e.m1842h(NoteMajorColumns.TITLE);
            if (h != null) {
                c0361e.m1833a(NoteMajorColumns.TITLE, cnVar.m1967a(h));
            }
            h = c0361e.m1842h("content");
            if (h != null) {
                c0361e.m1833a("content", cnVar.m1967a(h));
            }
            Object h2 = c0361e.m1842h(SyncIndexColumns.UUID);
            if (h2 == null) {
                c0361e2.m1833a("cursorinfo", m1881a(this.f1545c));
                Object c0361e3 = new C0361e();
                int columnIndexOrThrow = this.f1545c.getColumnIndexOrThrow(SyncIndexColumns.UUID);
                Object string = this.f1545c.getString(columnIndexOrThrow);
                UUID uuid = (UUID) coVar.a.f1733a.m2010c();
                if (uuid != null) {
                    obj = uuid.toString();
                } else {
                    obj = null;
                }
                c0361e3.m1833a("InCursorColumnIndex", Integer.valueOf(columnIndexOrThrow));
                c0361e3.m1833a("inCursor", string);
                c0361e3.m1833a("inField", obj);
                c0361e3.m1833a("inMap", h2);
                c0361e2.m1833a(SyncIndexColumns.UUID, c0361e3);
            }
        } catch (Throwable e) {
            C0311h.f1370a.m1625a("CommitStage.buildCommitMap()", e, c0361e);
            c0361e2.m1833a("exception", (C0361e) C0479f.f2283a.m1782c(e));
        }
        if (c0361e2.size() > 0) {
            c0361e.m1833a("z_debuginfo", c0361e2);
        }
        return c0361e;
    }

    private static C0361e m1881a(Cursor cursor) {
        C0361e c0361e = new C0361e();
        try {
            c0361e.m1833a("class", cursor.getClass().getName());
            c0361e.m1833a("isClosed", Boolean.valueOf(cursor.isClosed()));
            c0361e.m1833a("rowcount", Integer.valueOf(cursor.getCount()));
            c0361e.m1833a("rowposition", Integer.valueOf(cursor.getPosition()));
            c0361e.m1833a("columnscount", Integer.valueOf(cursor.getColumnCount()));
            c0361e.m1833a("columns", TextUtils.join(" ", cursor.getColumnNames()));
        } catch (Throwable e) {
            C0311h.f1370a.m1624a("CommitStage.createCursorInfo", e);
        }
        return c0361e;
    }

    public final void m1884a() {
        this.f1545c.close();
        aa aaVar = this.f1544b;
        String[] strArr = new String[]{"dirty=(dirty|staged)", "staged=0"};
        aaVar.f927a.m1074f().m1077a("UPDATE notes SET " + TextUtils.join(", ", strArr) + " WHERE " + new C0473n("staged!=0", new String[0]).f2273a, aa.f920b);
    }

    public final void m1885a(C0380e c0380e, HashSet hashSet) {
        C0361e c0361e = c0380e.f1713c;
        C0232v f = this.f1543a.m1074f();
        f.f1027a.beginTransaction();
        for (String str : c0361e.keySet()) {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            C0360d c0360d = (C0360d) C0357a.m1818a(str, C0357a.m1827e(str, c0361e.m1835b(str)));
            int intValue = ((Number) c0360d.get(0)).intValue();
            Object obj = c0360d.get(1);
            dm dmVar;
            switch (intValue) {
                case 200:
                    try {
                        long longValue = ((Number) obj).longValue();
                        long longValue2 = valueOf.longValue();
                        co coVar = new co();
                        ContentValues contentValues = new ContentValues();
                        coVar.m1850c(contentValues);
                        coVar.a.f1734b.m2008a(Long.valueOf(longValue));
                        this.f1544b.m915b(contentValues, aa.m902a(longValue2));
                        dmVar = this.f1551i;
                        dmVar.f1738a++;
                        continue;
                    } catch (Throwable e) {
                        C0311h.f1370a.m1625a("CommitStage.onResult()", e, c0361e);
                        throw new dl("Bad commit result", e);
                    } catch (Throwable th) {
                        f.f1027a.endTransaction();
                    }
                case 400:
                    dmVar = this.f1551i;
                    dmVar.f1741d++;
                    break;
                case 409:
                    C0361e c = C0357a.m1824c(obj);
                    try {
                        C0268b c0271d;
                        valueOf.longValue();
                        cm cmVar = new cm();
                        cmVar.m1850c(new ContentValues());
                        this.f1547e.m1968a(c);
                        cs.m1973a(cmVar, c);
                        if (!PreferenceManager.getDefaultSharedPreferences(ColorNote.m644a()).contains("pref_sync_on_launch")) {
                            Editor edit = PreferenceManager.getDefaultSharedPreferences(ColorNote.m644a()).edit();
                            edit.putBoolean("pref_sync_on_launch", true);
                            edit.commit();
                        }
                        UUID uuid = (UUID) cmVar.f1627a.f1733a.m2010c();
                        intValue = ((Integer) cmVar.f1628b.f1660f.m2010c()).intValue();
                        switch (intValue) {
                            case 0:
                                c0271d = new C0271d();
                                break;
                            case 16:
                                c0271d = new C0269a();
                                break;
                            case 256:
                                c0271d = new C0270c();
                                break;
                            default:
                                throw new RuntimeException("Unknown note type : " + intValue);
                        }
                        cm cmVar2 = new cm();
                        C0473n b = aa.m904b(uuid);
                        cmVar2.m1850c(this.f1544b.m916b(null, b));
                        switch (c0271d.m1201a(cmVar2, cmVar)) {
                            case 1:
                                aa aaVar = this.f1544b;
                                C0473n a = new C0473n("uuid = \"" + uuid + "\"", new String[0]).m2324a(new C0473n("type != 256", new Object[0]));
                                UUID randomUUID = UUID.randomUUID();
                                aaVar.f927a.m1074f().m1077a("UPDATE notes SET " + TextUtils.join(", ", new String[]{"uuid=\"" + randomUUID + "\"", "revision=0", "dirty=1", "status=status|4096"}) + " WHERE " + a.f2273a, aa.f920b);
                                break;
                            case 2:
                                cmVar2.m1850c(new ContentValues());
                                cmVar2.f1627a.f1734b.m2008a(cmVar.f1627a.f1734b.m2010c());
                                this.f1544b.m907a(cmVar2.m1852n(), uuid);
                                break;
                            case 3:
                                cmVar.m1965a(false);
                                this.f1544b.m915b(cmVar.m1852n(), b);
                                break;
                        }
                        dmVar = this.f1551i;
                        dmVar.f1740c++;
                        continue;
                    } catch (Throwable e2) {
                        C0311h.f1370a.m1625a("CommitStage.onResult()", e2, c);
                        dmVar = this.f1551i;
                        dmVar.f1741d++;
                        hashSet.add(valueOf);
                        break;
                    }
            }
            hashSet.add(valueOf);
        }
        f.f1027a.setTransactionSuccessful();
        f.f1027a.endTransaction();
    }
}
