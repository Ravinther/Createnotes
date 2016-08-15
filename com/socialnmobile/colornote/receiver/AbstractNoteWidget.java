package com.socialnmobile.colornote.receiver;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import com.socialnmobile.colornote.data.C0223m;

public abstract class AbstractNoteWidget extends AppWidgetProvider {
    public abstract int m1712a();

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        C0332a.m1730a(context, iArr, m1712a(), 2);
    }

    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    public void onDeleted(Context context, int[] iArr) {
        C0223m a = C0223m.m1021a(context);
        for (int i : iArr) {
            a.f985a.getWritableDatabase().delete("widget", "_id = ?", new String[]{String.valueOf(i)});
        }
        super.onDeleted(context, iArr);
    }
}
