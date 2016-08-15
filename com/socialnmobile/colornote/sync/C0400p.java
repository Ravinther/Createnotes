package com.socialnmobile.colornote.sync;

import android.content.Context;
import android.content.SharedPreferences;
import com.socialnmobile.util.p011b.p017b.C0462e;

/* renamed from: com.socialnmobile.colornote.sync.p */
public final class C0400p {
    final long f1801a;
    final Context f1802b;

    public C0400p(long j, Context context) {
        this.f1801a = j;
        this.f1802b = context;
    }

    public final cq m2045a() {
        SharedPreferences sharedPreferences = this.f1802b.getSharedPreferences("Account-" + this.f1801a + ".prefs", 0);
        if (sharedPreferences == null) {
            return null;
        }
        try {
            return new cq((byte[]) C0462e.f2255b.m1783d(sharedPreferences.getString("key128", null)), (byte[]) C0462e.f2255b.m1783d(sharedPreferences.getString("key256", null)));
        } catch (Exception e) {
            return null;
        }
    }
}
