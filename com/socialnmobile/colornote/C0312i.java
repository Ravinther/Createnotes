package com.socialnmobile.colornote;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: com.socialnmobile.colornote.i */
public final class C0312i {
    public static int m1627a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        return Math.min((int) (((float) displayMetrics.widthPixels) / f), (int) (((float) displayMetrics.heightPixels) / f));
    }

    public static int m1628b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    public static int m1629c(Context context) {
        int b = C0312i.m1628b(context);
        if (C0312i.m1627a(context) <= 400 && C0313j.m1663b(context)) {
            return 2;
        }
        if (b < 400) {
            return 1;
        }
        return 3;
    }

    public static int m1630d(Context context) {
        return (int) (context.getResources().getDisplayMetrics().density * 56.0f);
    }
}
