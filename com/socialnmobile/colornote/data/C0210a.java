package com.socialnmobile.colornote.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.socialnmobile.colornote.sync.ay;
import com.socialnmobile.colornote.sync.az;
import com.socialnmobile.colornote.sync.cl;

/* renamed from: com.socialnmobile.colornote.data.a */
public final class C0210a {
    public static int m894a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("INTERNAL_PREF", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getInt(str, 0);
        }
        return C0212b.m934a(context, str, 0);
    }

    public static void m897a(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences("INTERNAL_PREF", 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static long m899b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("INTERNAL_PREF", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getLong(str, 0);
        }
        return C0212b.m935a(context, str);
    }

    public static void m898a(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences("INTERNAL_PREF", 0).edit();
        edit.putLong(str, j);
        edit.commit();
    }

    public static String m901c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("INTERNAL_PREF", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getString(str, null);
        }
        return C0212b.m936a(context, str, null);
    }

    public static void m896a(Context context, ay ayVar) {
        Editor edit = context.getSharedPreferences("INTERNAL_PREF", 0).edit();
        edit.putString("CLIENT_RELEASES", (String) new az().m1782c(ayVar));
        edit.putLong("CLIENT_RELEASES_SAVE_TIME", System.currentTimeMillis());
        edit.commit();
    }

    public static ay m895a(Context context) {
        try {
            return (ay) new az().m1783d(C0210a.m901c(context, "CLIENT_RELEASES"));
        } catch (cl e) {
            return null;
        }
    }

    public static boolean m900b(Context context) {
        return C0210a.m894a(context, "WIPE_OUT_MARK") == 1;
    }
}
