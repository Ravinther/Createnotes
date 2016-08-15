package com.socialnmobile.colornote.sync.p020d;

import com.socialnmobile.colornote.data.NoteColumns.NoteLocalColumns;
import com.socialnmobile.colornote.sync.AccountColumns;
import com.socialnmobile.colornote.sync.bg;
import com.socialnmobile.colornote.sync.p018b.C0360d;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0373f;
import com.socialnmobile.util.p011b.p017b.C0466i;
import java.util.UUID;

/* renamed from: com.socialnmobile.colornote.sync.d.d */
public final class C0379d extends C0373f {
    public C0379d(UUID uuid, C0361e c0361e, long j, C0361e c0361e2, UUID uuid2, bg bgVar, C0361e c0361e3, long j2, C0360d c0360d, C0360d c0360d2) {
        String str = "sync";
        C0361e c0361e4 = new C0361e();
        c0361e4.m1833a("apiversion", (Object) "1.1");
        c0361e4.m1833a(NoteLocalColumns.ACCOUNT_ID, Long.valueOf(j));
        c0361e4.m1833a("device", (Object) c0361e2);
        c0361e4.m1833a("session_id", uuid.toString());
        c0361e4.m1834a("client_id", uuid2, C0466i.f2261a);
        c0361e4.m1834a(AccountColumns.REPOSITORY_BUILT, bgVar, bg.f1556d);
        c0361e4.m1833a("identities_etags", (Object) c0361e3);
        c0361e4.m1833a("checkout", Long.valueOf(j2));
        c0361e4.m1833a("checkin", (Object) c0360d);
        c0361e4.m1833a("properties", (Object) c0361e);
        if (c0360d2 != null && c0360d2.size() > 0) {
            c0361e4.m1833a("indications", (Object) c0360d2);
        }
        super(str, c0361e4);
    }
}
