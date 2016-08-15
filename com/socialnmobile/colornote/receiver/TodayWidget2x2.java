package com.socialnmobile.colornote.receiver;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;

public class TodayWidget2x2 extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        C0332a.m1729a(context, iArr);
    }

    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
    }
}
