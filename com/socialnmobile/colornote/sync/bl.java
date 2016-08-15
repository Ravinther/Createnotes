package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.C0312i;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.sync.p015a.C0336b;
import com.socialnmobile.colornote.sync.p018b.C0361e;

public final class bl {
    public final String f1562a;
    public final String f1563b;
    public final String f1564c;
    public final String f1565d;

    public static bl m1902a(Context context) {
        String str;
        String a = C0336b.m1749a(context);
        int a2 = C0312i.m1627a(context);
        if (a2 >= 720) {
            str = "tablet-large";
        } else if (a2 >= 600) {
            str = "tablet-small";
        } else if (a2 >= 320) {
            str = "phone";
        } else {
            str = "wearable";
        }
        return new bl("android", str, a, C0336b.m1750a(a));
    }

    private bl(String str, String str2, String str3, String str4) {
        this.f1562a = str;
        this.f1563b = str2;
        this.f1564c = str3;
        this.f1565d = str4;
    }

    public final C0361e m1903a() {
        C0361e c0361e = new C0361e();
        c0361e.m1833a("platform", this.f1562a);
        c0361e.m1833a(NoteMinorColumns.TYPE, this.f1563b);
        c0361e.m1833a("colornote_version", this.f1564c);
        c0361e.m1833a("user_agent", this.f1565d);
        return c0361e;
    }
}
