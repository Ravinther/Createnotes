package com.socialnmobile.colornote.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.security.GeneralSecurityException;

/* renamed from: com.socialnmobile.colornote.data.c */
public final class C0213c {
    public static void m960a(Context context, int i, int i2, String str) {
        Editor edit = ad.m920a(context, "name_label_" + i).edit();
        edit.putString("USER_COLOR_LABEL" + i2, str);
        edit.commit();
    }

    public static String m959a(Context context, int i, int i2) {
        if (i == -1) {
            return "";
        }
        return ad.m920a(context, "name_label_" + i).getString("USER_COLOR_LABEL" + i2, "");
    }

    public static boolean m961a(Context context) {
        return (C0213c.m963b(context) == null || C0213c.m966e(context) == null) ? false : true;
    }

    public static boolean m962a(Context context, String str) {
        String e = C0213c.m966e(context);
        String b = C0213c.m963b(context);
        C0222l b2 = C0222l.m1009b(30);
        b2.m1016a(str);
        b2.m1019c(2);
        try {
            if (b2.m1020d(e).equals(b)) {
                return true;
            }
        } catch (GeneralSecurityException e2) {
        }
        return false;
    }

    public static String m963b(Context context) {
        SharedPreferences a = ad.m920a(context, "name_master_password");
        String string = a.getString("BACKUP_SECRET_KEY", null);
        if (string == null) {
            String a2 = C0212b.m936a(context, "BACKUP_SECRET_KEY", null);
            String a3 = C0212b.m936a(context, "BACKUP_ENCRYPTED_DATA", null);
            if (!(a2 == null || a3 == null)) {
                Editor edit = a.edit();
                edit.putString("BACKUP_SECRET_KEY", a2);
                edit.putString("BACKUP_ENCRYPTED_DATA", a3);
                edit.commit();
                return a2;
            }
        }
        return string;
    }

    private static String m966e(Context context) {
        SharedPreferences a = ad.m920a(context, "name_master_password");
        String string = a.getString("BACKUP_ENCRYPTED_DATA", null);
        if (string == null) {
            String a2 = C0212b.m936a(context, "BACKUP_SECRET_KEY", null);
            String a3 = C0212b.m936a(context, "BACKUP_ENCRYPTED_DATA", null);
            if (!(a2 == null || a3 == null)) {
                Editor edit = a.edit();
                edit.putString("BACKUP_SECRET_KEY", a2);
                edit.putString("BACKUP_ENCRYPTED_DATA", a3);
                edit.commit();
                return a3;
            }
        }
        return string;
    }

    public static String m964c(Context context) {
        String str = null;
        SharedPreferences a = ad.m920a(context, "name_master_password");
        String b = C0213c.m963b(context);
        if (b != null) {
            C0222l b2 = C0222l.m1009b(30);
            b2.m1017b(b);
            String string = a.getString("CRYPTO_ENCRYPTED_USER_KEY", str);
            b2.m1019c(2);
            try {
                str = b2.m1020d(string);
            } catch (GeneralSecurityException e) {
            }
        }
        return str;
    }

    public static boolean m965d(Context context) {
        return ad.m920a(context, "name_master_password").getString("CRYPTO_ENCRYPTED_USER_KEY", null) != null;
    }
}
