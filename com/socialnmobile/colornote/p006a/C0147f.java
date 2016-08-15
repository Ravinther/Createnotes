package com.socialnmobile.colornote.p006a;

import android.app.AlarmManager;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.format.Time;
import android.view.View;
import android.view.ViewConfiguration;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: com.socialnmobile.colornote.a.f */
public final class C0147f {
    static Method f605a;
    static Method f606b;
    static Method f607c;
    static Method f608d;
    static Method f609e;

    static {
        try {
            f605a = ViewConfiguration.class.getMethod("hasPermanentMenuKey", new Class[0]);
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e2) {
        }
        try {
            f606b = View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
        } catch (SecurityException e3) {
        } catch (NoSuchMethodException e4) {
        }
        try {
            f607c = Builder.class.getMethod("getContext", new Class[0]);
        } catch (SecurityException e5) {
        } catch (NoSuchMethodException e6) {
        }
        try {
            f608d = Environment.class.getMethod("getExternalStoragePublicDirectory", new Class[]{String.class});
        } catch (SecurityException e7) {
        } catch (NoSuchMethodException e8) {
        }
        try {
            f609e = AlarmManager.class.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class});
        } catch (SecurityException e9) {
        } catch (NoSuchMethodException e10) {
        }
    }

    public static File m663a(String str) {
        if (f608d != null) {
            try {
                return (File) f608d.invoke(null, new Object[]{str});
            } catch (Exception e) {
            }
        }
        return new File(Environment.getExternalStorageState() + "/Download");
    }

    public static boolean m666a(ViewConfiguration viewConfiguration) {
        if (f605a != null) {
            try {
                return ((Boolean) f605a.invoke(viewConfiguration, new Object[0])).booleanValue();
            } catch (Exception e) {
            }
        }
        if (VERSION.SDK_INT <= 10) {
            return true;
        }
        if (VERSION.SDK_INT < 14) {
            return false;
        }
        return false;
    }

    public static void m665a(View view) {
        if (f606b != null) {
            try {
                f606b.invoke(view, new Object[]{Integer.valueOf(1), null});
            } catch (Exception e) {
            }
        }
    }

    public static Context m662a(Builder builder) {
        if (f607c != null) {
            try {
                return (Context) f607c.invoke(builder, new Object[0]);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static void m664a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        if (VERSION.SDK_INT < 19 || f609e == null) {
            alarmManager.set(0, j, pendingIntent);
            return;
        }
        try {
            f609e.invoke(alarmManager, new Object[]{Integer.valueOf(0), Long.valueOf(j), pendingIntent});
        } catch (Exception e) {
        }
    }

    public static long m661a(Time time, boolean z) {
        if (!z) {
            return time.toMillis(false);
        }
        try {
            long toMillis = time.toMillis(true);
            if (toMillis != -1) {
                return toMillis;
            }
        } catch (IllegalArgumentException e) {
        }
        return C0147f.m667b(time);
    }

    public static long m660a(Time time) {
        long normalize = time.normalize(true);
        if (normalize != -1) {
            return normalize;
        }
        normalize = C0147f.m667b(time);
        time.set(normalize);
        return normalize;
    }

    private static long m667b(Time time) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(time.timezone));
        instance.clear();
        instance.set(time.year, time.month, time.monthDay, time.hour, time.minute, time.second);
        return instance.getTimeInMillis();
    }
}
