package com.socialnmobile.colornote;

import android.content.Context;
import java.text.DateFormat;
import java.util.Date;

/* renamed from: com.socialnmobile.colornote.e */
public final class C0267e {
    private static DateFormat f1143a;
    private static DateFormat f1144b;
    private static Date f1145c;

    public C0267e(Context context) {
        f1143a = android.text.format.DateFormat.getDateFormat(context);
        f1144b = android.text.format.DateFormat.getTimeFormat(context);
        f1145c = new Date();
    }

    public final synchronized String m1198a(long j) {
        f1145c.setTime(j);
        return f1143a.format(f1145c);
    }

    public final synchronized String m1199b(long j) {
        f1145c.setTime(j);
        return f1143a.format(f1145c) + " " + f1144b.format(f1145c);
    }

    public static String m1196a(Context context, long j) {
        return android.text.format.DateFormat.getDateFormat(context).format(new Date(j));
    }

    public static String m1197b(Context context, long j) {
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        Date date = new Date(j);
        return dateFormat.format(date) + " " + timeFormat.format(date);
    }
}
