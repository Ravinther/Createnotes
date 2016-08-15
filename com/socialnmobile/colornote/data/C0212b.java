package com.socialnmobile.colornote.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.C0272f;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.p006a.C0150i;
import java.util.Locale;

/* renamed from: com.socialnmobile.colornote.data.b */
public final class C0212b {
    private static int f948a;

    public static void m937a(Context context) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove("BACKUP_SECRET_KEY");
        edit.remove("BACKUP_ENCRYPTED_DATA");
        edit.remove("CRYPTO_ENCRYPTED_USER_KEY");
        edit.remove("PREF_LAST_AUTO_SYNC_TIME");
        edit.remove("LAST_SYNC_TIME_MILLIS");
        edit.remove("LAST_SYNC_CHECKOUT_TIME_MILLIS");
        edit.remove("SYNC_ERROR_TIME_MILLIS");
        edit.remove("PREF_LAST_AUTO_SDBACKUP_TIME");
        edit.remove("PREF_RESERVED_AUTO_SYNC_TIME");
        edit.remove("SYNC_ERROR_MESSAGE");
        edit.remove("SYNC_ERROR_EXCEPTION_NAME");
        edit.remove("SYNC_ERROR_EXCEPTION_MSG");
        edit.remove("SYNC_NOTE_COUNT");
        edit.commit();
    }

    public static int m934a(Context context, String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i);
    }

    public static long m935a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, 0);
    }

    public static String m936a(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    private static void m942b(Context context, String str, String str2) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static boolean m940a(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static int m941b(Context context) {
        return Integer.valueOf(C0212b.m936a(context, "pref_list_item_height", context.getString(2131231061))).intValue();
    }

    public static void m943c(Context context) {
        int b = C0212b.m941b(context);
        if (b == 2) {
            f948a = context.getResources().getDimensionPixelSize(2131361820);
        } else if (b == 1) {
            f948a = context.getResources().getDimensionPixelSize(2131361827);
        } else {
            f948a = context.getResources().getDimensionPixelSize(2131361814);
        }
    }

    public static int m944d(Context context) {
        if (f948a == 0) {
            C0212b.m943c(context);
        }
        return f948a;
    }

    public static boolean m945e(Context context) {
        boolean z;
        try {
            z = context.getResources().getBoolean(2131296264);
        } catch (RuntimeException e) {
            z = true;
        }
        return C0212b.m940a(context, "pref_show_all_day_reminder", z);
    }

    public static boolean m946f(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences.contains("pref_use_colordict_in_editor")) {
            return defaultSharedPreferences.getBoolean("pref_use_colordict_in_editor", context.getResources().getBoolean(2131296268));
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName("com.socialnmobile.colordict", "com.socialnmobile.colordict.activity.Main");
        if (C0313j.m1650a(context, intent) && defaultSharedPreferences.getBoolean("pref_use_colordict", false)) {
            C0212b.m939a(context, true);
            return true;
        }
        C0212b.m939a(context, false);
        return false;
    }

    public static void m939a(Context context, boolean z) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("pref_use_colordict_in_editor", z);
        edit.commit();
    }

    public static int m947g(Context context) {
        return Integer.valueOf(C0212b.m936a(context, "pref_default_screen", context.getString(2131231062))).intValue();
    }

    public static int m948h(Context context) {
        return Integer.valueOf(C0212b.m936a(context, "pref_default_font_size", context.getString(2131231057))).intValue();
    }

    public static String m949i(Context context) {
        return C0212b.m936a(context, "PREF_THEME", "COLORTABLE/DEFAULT");
    }

    public static String m950j(Context context) {
        String a = C0212b.m936a(context, "pref_show_lunar_date_str", null);
        if (a != null) {
            return a;
        }
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) || Locale.getDefault().getCountry().equals(Locale.KOREA.getCountry())) {
            return "KR";
        }
        if (Locale.CHINA.getCountry().equals(Locale.getDefault().getCountry().toUpperCase())) {
            return "CN";
        }
        return "";
    }

    public static String m951k(Context context) {
        if ("KR".equals(C0212b.m950j(context))) {
            return "KR";
        }
        return "CN";
    }

    public static int m952l(Context context) {
        return Integer.parseInt(C0212b.m936a(context, "pref_widget_transparency", context.getString(2131231065)), 16);
    }

    public static void m938a(Context context, long j, Exception exception) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        String a = C0272f.m1209a(context, exception);
        String simpleName = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        edit.putLong("SYNC_ERROR_TIME_MILLIS", j);
        edit.putString("SYNC_ERROR_MESSAGE", a);
        edit.putString("SYNC_ERROR_EXCEPTION_NAME", simpleName);
        edit.putString("SYNC_ERROR_EXCEPTION_MSG", message);
        edit.commit();
    }

    public static long m953m(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("SYNC_ERROR_TIME_MILLIS", 0);
    }

    public static boolean m955o(Context context) {
        return C0212b.m940a(context, "pref_sync_on_launch", context.getResources().getBoolean(2131296266));
    }

    public static boolean m956p(Context context) {
        return C0212b.m940a(context, "pref_auto_sort_by_status", context.getResources().getBoolean(2131296257));
    }

    public static int m957q(Context context) {
        if (!C0150i.m675c()) {
            return 1;
        }
        if (VERSION.SDK_INT != 15 || !Build.BRAND.equals("NOOK")) {
            int i;
            if (VERSION.SDK_INT >= 21) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (!(i == 0 || C0212b.m940a(context, "pref_v21_base_style_set", false))) {
                Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit.putBoolean("pref_v21_base_style_set", true);
                edit.commit();
                C0212b.m942b(context, "pref_base_style", "2");
            }
        } else if (!PreferenceManager.getDefaultSharedPreferences(context).contains("pref_base_style")) {
            C0212b.m942b(context, "pref_base_style", "2");
        }
        return Integer.valueOf(C0212b.m936a(context, "pref_base_style", context.getString(2131231060))).intValue();
    }

    public static boolean m958r(Context context) {
        return C0212b.m940a(context, "pref_gpu_rendering", context.getResources().getBoolean(2131296261));
    }

    public static boolean m954n(Context context) {
        if (C0212b.m953m(context) > C0212b.m935a(context, "LAST_SYNC_TIME_MILLIS")) {
            return true;
        }
        return false;
    }
}
