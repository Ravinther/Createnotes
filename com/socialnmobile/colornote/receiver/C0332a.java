package com.socialnmobile.colornote.receiver;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.widget.RemoteViews;
import com.socialnmobile.colornote.C0151a;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.NoteWidgetConfigure;
import com.socialnmobile.colornote.activity.Today;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0220j;
import com.socialnmobile.colornote.data.C0223m;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.data.C0236z;
import com.socialnmobile.colornote.p012f.C0269a;
import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.receiver.a */
public final class C0332a {
    public static void m1730a(Context context, int[] iArr, int i, int i2) {
        if (iArr != null) {
            AppWidgetManager instance = AppWidgetManager.getInstance(context);
            Object obj = 1;
            for (int i3 : iArr) {
                RemoteViews remoteViews = null;
                try {
                    remoteViews = C0332a.m1723a(context, i3, i);
                } catch (SQLiteException e) {
                    obj = null;
                }
                if (remoteViews != null) {
                    instance.updateAppWidget(i3, remoteViews);
                } else {
                    Resources resources = context.getResources();
                    remoteViews = null;
                    if (i == 1) {
                        int i4 = C0209d.m875a(context).m1140i(8);
                        remoteViews = new RemoteViews(context.getPackageName(), 2130903099);
                        remoteViews.setImageViewBitmap(16908288, C0332a.m1722a(resources, 0, 0, i4, C0212b.m952l(context)));
                    } else if (i == 2) {
                        remoteViews = new RemoteViews(context.getPackageName(), 2130903101);
                        C0332a.m1728a(context, remoteViews, false, 8);
                    }
                    instance.updateAppWidget(i3, remoteViews);
                }
            }
            if (obj == null) {
                Object obj2;
                C0151a.m676a();
                if (SystemClock.uptimeMillis() < 300000) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    ColorNote.m651a("Schedule BuildWidgetReceiver " + i2);
                    if (i2 > 0) {
                        BuildWidgetReceiver.m1717a(context, iArr, i, i2);
                    }
                }
            }
        }
    }

    public static void m1725a(Context context, Uri uri) {
        C0223m a = C0223m.m1021a(context);
        long parseId = ContentUris.parseId(uri);
        Cursor query = a.f985a.getReadableDatabase().query("widget", null, "note_id = ?", new String[]{String.valueOf(parseId)}, null, null, null);
        C0236z[] c0236zArr = new C0236z[query.getCount()];
        int i = 0;
        while (query.moveToNext()) {
            c0236zArr[i] = new C0236z();
            c0236zArr[i].f1031a = query.getInt(query.getColumnIndex("_id"));
            c0236zArr[i].f1032b = query.getInt(query.getColumnIndex("widget_type"));
            i++;
        }
        query.close();
        if (c0236zArr.length != 0) {
            C0332a.m1731a(context, c0236zArr);
        }
    }

    public static void m1724a(Context context) {
        Cursor query = C0223m.m1021a(context).f985a.getReadableDatabase().query("widget", null, null, null, null, null, null);
        C0236z[] c0236zArr = new C0236z[query.getCount()];
        int i = 0;
        while (query.moveToNext()) {
            c0236zArr[i] = new C0236z();
            c0236zArr[i].f1031a = query.getInt(query.getColumnIndex("_id"));
            c0236zArr[i].f1032b = query.getInt(query.getColumnIndex("widget_type"));
            i++;
        }
        query.close();
        C0332a.m1731a(context, c0236zArr);
    }

    public static void m1731a(Context context, C0236z[] c0236zArr) {
        AppWidgetManager instance = AppWidgetManager.getInstance(context);
        for (C0236z c0236z : c0236zArr) {
            if (!(c0236z.f1031a == 0 || c0236z.f1032b == 0)) {
                instance.updateAppWidget(c0236z.f1031a, C0332a.m1723a(context, c0236z.f1031a, c0236z.f1032b));
            }
        }
    }

    public static void m1733b(Context context) {
        try {
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, TodayWidget2x2.class));
            if (appWidgetIds != null && appWidgetIds.length > 0) {
                C0332a.m1729a(context, appWidgetIds);
            }
        } catch (RuntimeException e) {
        }
    }

    private static RemoteViews m1723a(Context context, int i, int i2) {
        long j;
        int i3;
        int i4;
        long j2;
        String str;
        String str2;
        boolean z;
        int i5;
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        Resources resources;
        String str3 = "";
        String str4 = "";
        int i6 = 0;
        Cursor query = C0223m.m1021a(context).f985a.getReadableDatabase().query("widget", null, "_id = ?", new String[]{String.valueOf(i)}, null, null, null);
        if (query.moveToFirst()) {
            j = query.getLong(query.getColumnIndex("note_id"));
        } else {
            j = 0;
        }
        query.close();
        if (j != 0) {
            Cursor e = C0229s.m1053e(context, ContentUris.withAppendedId(C0228r.f997a, j));
            if (e != null) {
                String str5;
                String a;
                long j3;
                int i7;
                boolean a2;
                int i8;
                if (e.moveToFirst()) {
                    C0230t c0230t = new C0230t(e);
                    str5 = c0230t.f1008g;
                    a = c0230t.m1057a(context);
                    i3 = c0230t.f1011j;
                    j3 = c0230t.f1002a;
                    i7 = c0230t.f1007f;
                    a2 = c0230t.m1059a();
                    i4 = c0230t.f1004c;
                    i8 = c0230t.f1012k;
                } else {
                    a2 = false;
                    i7 = 0;
                    j3 = j;
                    i3 = 8;
                    a = str4;
                    i4 = 0;
                    i8 = 0;
                    str5 = str3;
                }
                e.close();
                i6 = i4;
                i4 = i8;
                boolean z2 = a2;
                j2 = j3;
                str = a;
                str2 = str5;
                z = z2;
                i5 = i7;
                if (i2 == 1) {
                    if (i5 != 16) {
                        remoteViews = new RemoteViews(context.getPackageName(), 2130903100);
                    } else {
                        remoteViews = new RemoteViews(context.getPackageName(), 2130903099);
                    }
                    C0332a.m1726a(context, remoteViews, j2, str2, str, i3, i5, z, i6);
                    return remoteViews;
                } else if (i2 != 2) {
                    if (i5 != 16) {
                        remoteViews2 = new RemoteViews(context.getPackageName(), 2130903101);
                    } else {
                        remoteViews2 = new RemoteViews(context.getPackageName(), 2130903101);
                    }
                    resources = context.getResources();
                    C0332a.m1728a(context, remoteViews2, z, i3);
                    if (z) {
                        remoteViews2.setTextViewText(16908310, str2);
                    } else {
                        remoteViews2.setTextViewText(16908310, C0313j.m1639a(str2));
                    }
                    if (i5 != 16) {
                        remoteViews2.setTextViewText(16908308, C0269a.m1202a(str));
                    } else {
                        remoteViews2.setTextViewText(16908308, str);
                    }
                    if (i4 == 0) {
                        remoteViews2.setViewVisibility(2131624066, 0);
                        remoteViews2.setTextViewText(16908308, "");
                    } else {
                        remoteViews2.setViewVisibility(2131624066, 4);
                    }
                    if (i6 == 32) {
                        remoteViews2.setTextViewText(16908308, resources.getString(2131230756));
                    }
                    remoteViews2.setOnClickPendingIntent(16908288, C0332a.m1720a(context, j2));
                    Intent intent = new Intent(context, NoteWidgetConfigure.class);
                    intent.setData(Uri.parse(String.valueOf(i)));
                    intent.putExtra("appWidgetId", i);
                    intent.setFlags(335544320);
                    remoteViews2.setOnClickPendingIntent(16908313, PendingIntent.getActivity(context, 0, intent, 134217728));
                    return remoteViews2;
                } else {
                    throw new RuntimeException("Invalid widgetType:" + i2);
                }
            }
        }
        i5 = 0;
        j2 = j;
        i3 = 8;
        str = str4;
        str2 = str3;
        i4 = 0;
        z = false;
        if (i2 == 1) {
            if (i5 != 16) {
                remoteViews = new RemoteViews(context.getPackageName(), 2130903099);
            } else {
                remoteViews = new RemoteViews(context.getPackageName(), 2130903100);
            }
            C0332a.m1726a(context, remoteViews, j2, str2, str, i3, i5, z, i6);
            return remoteViews;
        } else if (i2 != 2) {
            throw new RuntimeException("Invalid widgetType:" + i2);
        } else {
            if (i5 != 16) {
                remoteViews2 = new RemoteViews(context.getPackageName(), 2130903101);
            } else {
                remoteViews2 = new RemoteViews(context.getPackageName(), 2130903101);
            }
            resources = context.getResources();
            C0332a.m1728a(context, remoteViews2, z, i3);
            if (z) {
                remoteViews2.setTextViewText(16908310, str2);
            } else {
                remoteViews2.setTextViewText(16908310, C0313j.m1639a(str2));
            }
            if (i5 != 16) {
                remoteViews2.setTextViewText(16908308, str);
            } else {
                remoteViews2.setTextViewText(16908308, C0269a.m1202a(str));
            }
            if (i4 == 0) {
                remoteViews2.setViewVisibility(2131624066, 4);
            } else {
                remoteViews2.setViewVisibility(2131624066, 0);
                remoteViews2.setTextViewText(16908308, "");
            }
            if (i6 == 32) {
                remoteViews2.setTextViewText(16908308, resources.getString(2131230756));
            }
            remoteViews2.setOnClickPendingIntent(16908288, C0332a.m1720a(context, j2));
            Intent intent2 = new Intent(context, NoteWidgetConfigure.class);
            intent2.setData(Uri.parse(String.valueOf(i)));
            intent2.putExtra("appWidgetId", i);
            intent2.setFlags(335544320);
            remoteViews2.setOnClickPendingIntent(16908313, PendingIntent.getActivity(context, 0, intent2, 134217728));
            return remoteViews2;
        }
    }

    private static PendingIntent m1720a(Context context, long j) {
        Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(C0228r.f997a, j));
        intent.setFlags(335544320);
        intent.putExtra("EXTRA_VIEW_FROM", "WIDGET");
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    private static void m1726a(Context context, RemoteViews remoteViews, long j, String str, String str2, int i, int i2, boolean z, int i3) {
        int i4;
        Resources resources = context.getResources();
        int i5 = C0209d.m875a(context).m1140i(i);
        int j2 = C0209d.m875a(context).m1141j(i);
        if (z) {
            remoteViews.setTextViewText(16908308, C0313j.m1639a(str));
        } else {
            remoteViews.setTextViewText(16908308, str);
        }
        if (i3 == 32) {
            remoteViews.setTextViewText(16908308, resources.getString(2131230756));
        }
        remoteViews.setTextColor(16908308, j2);
        if (i2 == 16) {
            if (C0212b.m940a(context, "pref_show_item_count_on_widget", context.getResources().getBoolean(2131296265))) {
                Iterator it = C0269a.m1204b(str2).iterator();
                i4 = 0;
                while (it.hasNext()) {
                    if (((C0220j) it.next()).m1005a()) {
                        j2 = i4;
                    } else {
                        j2 = i4 + 1;
                    }
                    i4 = j2;
                }
                if (i4 <= 0 || i3 != 0) {
                    remoteViews.setViewVisibility(16908309, 8);
                } else {
                    remoteViews.setTextViewText(16908309, String.valueOf(i4));
                    remoteViews.setViewVisibility(16908309, 0);
                }
                remoteViews.setImageViewBitmap(16908288, C0332a.m1722a(resources, i2, i4, i5, C0212b.m952l(context)));
                remoteViews.setOnClickPendingIntent(16908288, C0332a.m1720a(context, j));
            }
            remoteViews.setViewVisibility(16908309, 8);
        }
        i4 = 0;
        remoteViews.setImageViewBitmap(16908288, C0332a.m1722a(resources, i2, i4, i5, C0212b.m952l(context)));
        remoteViews.setOnClickPendingIntent(16908288, C0332a.m1720a(context, j));
    }

    private static void m1728a(Context context, RemoteViews remoteViews, boolean z, int i) {
        remoteViews.setImageViewBitmap(2131624135, C0332a.m1732b(context, i, C0212b.m952l(context)));
        remoteViews.setImageViewBitmap(2131624136, C0332a.m1734c(context, i, C0212b.m952l(context)));
        int f = C0209d.m875a(context).m1137f(i);
        int g = C0209d.m875a(context).m1138g(i);
        if (z) {
            remoteViews.setTextColor(16908310, C0313j.m1632a(102, f));
            remoteViews.setTextColor(16908308, C0313j.m1632a(102, g));
            return;
        }
        remoteViews.setTextColor(16908310, f);
        remoteViews.setTextColor(16908308, g);
    }

    private static Bitmap m1732b(Context context, int i, int i2) {
        return C0332a.m1721a(C0209d.m875a(context).m1134c(i), i2);
    }

    private static Bitmap m1734c(Context context, int i, int i2) {
        return C0332a.m1721a(C0209d.m875a(context).m1133b(i), i2);
    }

    private static Bitmap m1721a(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, Config.ARGB_8888);
        createBitmap.eraseColor(C0313j.m1632a(i2, i));
        return createBitmap;
    }

    private static Bitmap m1722a(Resources resources, int i, int i2, int i3, int i4) {
        Bitmap decodeResource;
        int dimensionPixelSize = resources.getDimensionPixelSize(2131361831);
        Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        if (i == 16 && i2 == 0) {
            decodeResource = BitmapFactory.decodeResource(resources, 2130837505);
        } else {
            decodeResource = BitmapFactory.decodeResource(resources, 2130837510);
        }
        paint.setColorFilter(new PorterDuffColorFilter(C0313j.m1632a(i4, i3), Mode.MULTIPLY));
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    private static void m1727a(Context context, RemoteViews remoteViews, Cursor cursor, int i) {
        int identifier = context.getResources().getIdentifier("item" + i, "id", context.getPackageName());
        int identifier2 = context.getResources().getIdentifier("bg_item" + i, "id", context.getPackageName());
        int identifier3 = context.getResources().getIdentifier("text" + i, "id", context.getPackageName());
        C0230t c0230t = new C0230t(cursor);
        remoteViews.setViewVisibility(identifier, 0);
        remoteViews.setImageViewBitmap(identifier2, C0332a.m1721a(C0209d.m875a(context).m1133b(c0230t.f1011j), C0212b.m952l(context)));
        remoteViews.setOnClickPendingIntent(identifier3, C0332a.m1720a(context, c0230t.f1002a));
        identifier = C0209d.m875a(context).m1138g(c0230t.f1011j);
        if (c0230t.m1059a()) {
            remoteViews.setTextViewText(identifier3, C0313j.m1639a(c0230t.f1008g));
            remoteViews.setTextColor(identifier3, C0313j.m1632a(102, identifier));
            return;
        }
        remoteViews.setTextViewText(identifier3, c0230t.f1008g);
        remoteViews.setTextColor(identifier3, identifier);
    }

    public static void m1729a(Context context, int[] iArr) {
        AppWidgetManager instance = AppWidgetManager.getInstance(context);
        long currentTimeMillis = System.currentTimeMillis();
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2130903102);
        remoteViews.setImageViewBitmap(2131624137, C0332a.m1732b(context, 9, C0212b.m952l(context)));
        remoteViews.setImageViewBitmap(2131624139, C0332a.m1734c(context, 9, C0212b.m952l(context)));
        remoteViews.setTextViewText(16908310, DateUtils.formatDateTime(context, currentTimeMillis, 524314));
        Cursor a = C0229s.m1036a(context, currentTimeMillis);
        if (a != null) {
            if (a.moveToNext()) {
                C0332a.m1727a(context, remoteViews, a, 1);
            } else {
                remoteViews.setViewVisibility(2131624140, 4);
            }
            if (a.moveToNext()) {
                C0332a.m1727a(context, remoteViews, a, 2);
            } else {
                remoteViews.setViewVisibility(2131624143, 4);
            }
            if (a.moveToNext()) {
                C0332a.m1727a(context, remoteViews, a, 3);
            } else {
                remoteViews.setViewVisibility(2131624146, 4);
            }
            if (a.moveToNext()) {
                C0332a.m1727a(context, remoteViews, a, 4);
            } else {
                remoteViews.setViewVisibility(2131624149, 4);
            }
            if (a.moveToNext()) {
                C0332a.m1727a(context, remoteViews, a, 5);
            } else {
                remoteViews.setViewVisibility(2131624152, 4);
            }
            a.close();
        }
        Intent intent = new Intent(context, Today.class);
        intent.setFlags(335544320);
        remoteViews.setOnClickPendingIntent(16908313, PendingIntent.getActivity(context, 0, intent, 134217728));
        intent = new Intent("note.socialnmobile.intent.action.VIEW_CALENDAR");
        intent.setFlags(335544320);
        remoteViews.setOnClickPendingIntent(16908288, PendingIntent.getActivity(context, 0, intent, 268435456));
        instance.updateAppWidget(iArr, remoteViews);
    }
}
