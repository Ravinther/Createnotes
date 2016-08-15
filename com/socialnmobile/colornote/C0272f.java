package com.socialnmobile.colornote;

import android.content.Context;
import android.text.Html;
import android.text.format.DateUtils;
import com.socialnmobile.colornote.data.C0212b;
import java.io.IOException;

/* renamed from: com.socialnmobile.colornote.f */
public final class C0272f {
    public static CharSequence m1208a(Context context) {
        return Html.fromHtml(context.getString(2131230869, new Object[]{DateUtils.formatDateTime(context, C0212b.m953m(context), 524313)}) + "<br/><font color='red'>" + C0212b.m936a(context, "SYNC_ERROR_MESSAGE", "") + "</font>");
    }

    public static String m1209a(Context context, Exception exception) {
        if (exception instanceof IOException) {
            return context.getString(2131230797);
        }
        if (exception instanceof SecurityException) {
            return context.getString(2131231050);
        }
        if (exception instanceof RuntimeException) {
            return context.getString(2131230856);
        }
        return context.getString(2131230872);
    }
}
