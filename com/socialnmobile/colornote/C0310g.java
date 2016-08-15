package com.socialnmobile.colornote;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.format.Time;
import android.widget.RemoteViews;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p009c.C0200a;
import com.socialnmobile.colornote.p013g.C0309g;
import com.socialnmobile.colornote.receiver.C0332a;

/* renamed from: com.socialnmobile.colornote.g */
public final class C0310g {
    public static void m1613a(Context context, long j, boolean z) {
        long b = C0313j.m1655b(j) + 30000;
        if (b >= j) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("note.socialnmobile.intent.action.DAY_REMINDER"), 134217728);
            if (C0210a.m899b(context, "DAILY_UPDATE_SCHEDULE") != b || z) {
                try {
                    C0151a.m676a().m678a(context, b, broadcast);
                    C0210a.m898a(context, "DAILY_UPDATE_SCHEDULE", b);
                } catch (Throwable e) {
                    C0311h.f1370a.m1624a("GALAXY LOLLIPOP ALARM", e);
                }
            }
        }
    }

    public static PendingIntent m1609a(Context context, long j, long j2) {
        Intent intent = new Intent("note.socialnmobile.intent.action.TIME_REMINDER");
        intent.putExtra("alarm_id", j);
        intent.putExtra("alarm_time", j2);
        return PendingIntent.getBroadcast(context, 0, intent, 134217728);
    }

    public static void m1612a(Context context, long j, long j2, PendingIntent pendingIntent) {
        try {
            C0151a.m676a().m678a(context, j2, pendingIntent);
            C0210a.m898a(context, "TIME_ALARM_SCHEDULE", j2);
            C0210a.m898a(context, "TIME_ALARM_ID", j);
        } catch (Throwable e) {
            C0311h.f1370a.m1624a("GALAXY LOLLIPOP ALARM 2", e);
            ColorNote.m653b(context.getString(2131231050));
        }
    }

    public static void m1618b(Context context, long j) {
        C0310g.m1613a(context, j, false);
        Cursor query = context.getContentResolver().query(C0228r.f997a, null, "reminder_type = ? AND reminder_date > ? AND reminder_date < ?", new String[]{"16", "0", String.valueOf(C0313j.m1633a(j))}, null);
        int columnIndex = query.getColumnIndex("_id");
        int columnIndex2 = query.getColumnIndex(NoteMinorColumns.REMINDER_DATE);
        int columnIndex3 = query.getColumnIndex(NoteMinorColumns.REMINDER_REPEAT);
        int columnIndex4 = query.getColumnIndex(NoteMinorColumns.REMINDER_REPEAT_END);
        while (query.moveToNext()) {
            long j2 = query.getLong(columnIndex);
            long j3 = query.getLong(columnIndex2);
            long j4 = query.getLong(columnIndex4);
            Context context2 = context;
            j3 = j;
            C0229s.m1045a(context2, ContentUris.withAppendedId(C0228r.f997a, j2), j3, 16, query.getInt(columnIndex3), C0230t.m1055a(16, j3), C0230t.m1055a(16, j4), false, false);
        }
        query.close();
        Cursor a = C0229s.m1036a(context, j);
        int count = a.getCount();
        String str = "";
        String str2 = "";
        while (a.moveToNext()) {
            C0230t c0230t = new C0230t(a);
            long j5 = c0230t.f1002a;
            j4 = c0230t.f1013l;
            Uri withAppendedId = ContentUris.withAppendedId(C0228r.f997a, j5);
            j5 = C0313j.m1633a(j);
            if (c0230t.f1014m == 16 && j4 != j5) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(NoteMinorColumns.REMINDER_LAST, Long.valueOf(j5));
                context.getContentResolver().update(withAppendedId, contentValues, null, null);
            }
            String c = c0230t.m1061c();
            c = c.substring(0, Math.min(30, c.length()));
            if ("".equals(str2)) {
                str2 = c0230t.f1008g;
                str = c;
            } else {
                str = str + " / " + c;
                str2 = str2 + " / " + c0230t.f1008g;
            }
        }
        a.close();
        CharSequence charSequence = "[" + count + "] " + str2.substring(0, Math.min(30, str2.length()));
        String substring = str.substring(0, Math.min(100, str.length()));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (!C0212b.m945e(context)) {
            notificationManager.cancel(10);
        } else if (count > 0) {
            Intent intent = new Intent("note.socialnmobile.intent.action.TODAY");
            intent.setFlags(335544320);
            Notification notification = new Notification(2130837672, context.getString(2131230895), System.currentTimeMillis());
            notification.number = count;
            C0310g.m1614a(context, notification, charSequence, substring.replace('\n', ' '), PendingIntent.getActivity(context, 0, intent, 134217728), false);
            notification.flags |= 32;
            notificationManager.notify(10, notification);
        } else {
            notificationManager.cancel(10);
        }
        C0332a.m1733b(context);
    }

    public static void m1619c(Context context, long j) {
        Cursor query = context.getContentResolver().query(C0228r.f997a, null, "reminder_type = ? AND reminder_date > ?", new String[]{"32", String.valueOf(j)}, "reminder_date ASC");
        if (query == null) {
            throw new C0200a("Null cursor returned from provider");
        }
        if (query.moveToFirst()) {
            long j2 = query.getLong(query.getColumnIndex("_id"));
            long j3 = query.getLong(query.getColumnIndex(NoteMinorColumns.REMINDER_DATE));
            PendingIntent a = C0310g.m1609a(context, j2, j3);
            long b = C0210a.m899b(context, "TIME_ALARM_SCHEDULE");
            long b2 = C0210a.m899b(context, "TIME_ALARM_ID");
            if (!(b == j3 && b2 == j2)) {
                C0310g.m1612a(context, j2, j3, a);
            }
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("note.socialnmobile.intent.action.TIME_REMINDER"), 134217728);
            C0151a.m676a();
            ((AlarmManager) context.getSystemService("alarm")).cancel(broadcast);
        }
        query.close();
    }

    public static void m1620d(Context context, long j) {
        Uri withAppendedId = ContentUris.withAppendedId(C0228r.f997a, j);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor e = C0229s.m1053e(context, withAppendedId);
        if (e.moveToFirst()) {
            C0230t c0230t = new C0230t(e);
            String c = c0230t.m1061c();
            String substring = c.substring(0, Math.min(30, c.length()));
            e.close();
            if (c0230t.f1004c == 0) {
                int i = c0230t.f1014m;
                c0230t.m1065g();
                CharSequence charSequence = c0230t.f1008g;
                int i2 = c0230t.f1011j;
                Uri withAppendedId2 = ContentUris.withAppendedId(C0228r.f997a, j);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(335544320);
                intent.putExtra("EXTRA_VIEW_FROM", "NOTIFICATION");
                Notification notification = new Notification(context.getResources().getIdentifier("stat_textnote_" + i2, "drawable", context.getPackageName()), charSequence, System.currentTimeMillis());
                intent.setData(withAppendedId2);
                CharSequence replace = substring.replace('\n', ' ');
                if (i == 128) {
                    C0310g.m1614a(context, notification, charSequence, replace, PendingIntent.getActivity(context, 0, intent, 134217728), false);
                    notification.flags |= 32;
                } else if (i == 32) {
                    C0310g.m1614a(context, notification, charSequence, replace, PendingIntent.getActivity(context, 0, intent, 1073741824), true);
                    notification.defaults |= 3;
                    notification.flags |= 1;
                    notification.ledARGB = -256;
                    notification.ledOnMS = 500;
                    notification.ledOffMS = 5000;
                }
                if (c0230t.f1014m == 32) {
                    C0229s.m1045a(context, withAppendedId, currentTimeMillis, c0230t.f1014m, c0230t.f1015n, c0230t.m1065g(), c0230t.m1067i(), false, true);
                }
                ((NotificationManager) context.getSystemService("notification")).notify(((int) j) + 100, notification);
                return;
            }
            return;
        }
        e.close();
        ColorNote.m651a("Can't notify because note was deleted");
    }

    public static void m1615a(Context context, Uri uri) {
        ((NotificationManager) context.getSystemService("notification")).cancel(((int) ContentUris.parseId(uri)) + 100);
    }

    public static void m1610a(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C0310g.m1611a(context, currentTimeMillis);
            C0310g.m1619c(context, currentTimeMillis);
            C0310g.m1618b(context, currentTimeMillis);
            Cursor query = context.getContentResolver().query(C0228r.f997a, null, "reminder_type = 128 AND reminder_date <> 0", null, null);
            if (query == null) {
                throw new C0200a("Null cursor returned from provider");
            }
            while (query.moveToNext()) {
                C0310g.m1620d(context, query.getLong(query.getColumnIndex("_id")));
            }
            query.close();
        } catch (C0200a e) {
            ColorNote.m651a("Invalid State Exception thrown when renewTimeAlarms()");
        }
    }

    public static long m1607a(Context context, int i, long j, long j2, int i2) {
        switch (i) {
            case 16:
            case 48:
            case 64:
            case 144:
                Time time = new Time();
                if (i2 == 1) {
                    time.timezone = "UTC";
                }
                time.set(j);
                while (C0147f.m661a(time, true) < j2) {
                    switch (i) {
                        case 16:
                        case 144:
                            time.monthDay++;
                            break;
                        case 48:
                            time.monthDay += 7;
                            break;
                        case 64:
                            time.monthDay += 14;
                            break;
                        default:
                            break;
                    }
                    C0147f.m660a(time);
                }
                return C0147f.m661a(time, true);
            case 32:
                return C0310g.m1606a(j, j2, i2);
            case 80:
                return C0310g.m1617b(j, j2, i2);
            case 96:
            case 112:
                return C0310g.m1605a(i, j, j2, i2);
            case 128:
                return C0310g.m1608a(context, j, j2, i2);
            default:
                return 0;
        }
    }

    private static long m1605a(int i, long j, long j2, int i2) {
        Time time = new Time();
        Time time2 = new Time();
        if (i2 == 1) {
            time2.timezone = "UTC";
            time.timezone = "UTC";
        }
        time.set(j);
        int i3 = 1;
        while (true) {
            time2.set(j);
            switch (i) {
                case 96:
                    time2.month += i3;
                    break;
                case 112:
                    time2.year += i3;
                    break;
            }
            C0147f.m660a(time2);
            i3++;
            if (C0147f.m661a(time2, true) >= j2 && time.monthDay == time2.monthDay) {
                return C0147f.m661a(time2, true);
            }
        }
    }

    private static long m1606a(long j, long j2, int i) {
        Time time = new Time();
        if (i == 1) {
            time.timezone = "UTC";
        }
        time.set(j);
        while (true) {
            if (C0147f.m661a(time, true) >= j2 && time.weekDay != 0 && time.weekDay != 6) {
                return C0147f.m661a(time, true);
            }
            time.monthDay++;
            C0147f.m660a(time);
        }
    }

    private static long m1617b(long j, long j2, int i) {
        Time time = new Time();
        if (i == 1) {
            time.timezone = "UTC";
        }
        time.set(j);
        int i2 = ((time.monthDay - 1) / 7) + 1;
        if (i2 == 5) {
            i2 = -1;
        }
        int i3 = time.weekDay;
        boolean z = false;
        while (true) {
            if (C0147f.m661a(time, true) >= j2 && r1) {
                return C0147f.m661a(time, true);
            }
            time.month++;
            time.monthDay = 1;
            C0147f.m660a(time);
            int i4 = time.weekDay;
            int actualMaximum = time.getActualMaximum(4);
            i4 = (i3 - i4) + 1;
            if (i4 <= 0) {
                i4 += 7;
            }
            if (i2 > 0) {
                i4 += (i2 - 1) * 7;
                if (i4 <= actualMaximum) {
                    time.monthDay = i4;
                    z = true;
                }
                z = false;
            } else {
                while (i4 <= actualMaximum) {
                    i4 += 7;
                }
                i4 += i2 * 7;
                if (i4 > 0) {
                    time.monthDay = i4;
                    z = true;
                }
                z = false;
            }
            C0147f.m660a(time);
        }
    }

    private static long m1608a(Context context, long j, long j2, int i) {
        long j3 = j;
        while (j3 < j2) {
            C0309g c0309g = new C0309g(context);
            long j4 = j3 % 86400000;
            C0309g c0309g2 = new C0309g(context, j3, i);
            int a = c0309g.m1601a(c0309g2.f1365a);
            if (a > 0 && a == c0309g2.f1366b && !c0309g2.f1368d) {
                j3 = (c0309g.m1603a(c0309g2.f1365a, c0309g2.f1366b, false, i) + (((long) c0309g.m1602a(c0309g2.f1365a, c0309g2.f1366b)) * 86400000)) + (((long) (c0309g2.f1367c - 1)) * 86400000);
                C0309g c0309g3 = new C0309g(context, j3, i);
                if (c0309g3.f1366b == c0309g2.f1366b && c0309g3.f1367c == c0309g2.f1367c && c0309g3.f1365a > c0309g2.f1365a) {
                    j3 += j4;
                    if (j3 == 0) {
                        ColorNote.m651a("Can't calculate next lunar date. it may be > 2050");
                        break;
                    }
                }
            }
            for (a = c0309g2.f1365a + 1; a < 2050; a++) {
                long a2 = c0309g.m1603a(a, c0309g2.f1366b, false, i) + (((long) (c0309g2.f1367c - 1)) * 86400000);
                C0309g c0309g4 = new C0309g(context, a2, i);
                if (c0309g4.f1366b == c0309g2.f1366b && c0309g4.f1367c == c0309g2.f1367c && c0309g4.f1365a > c0309g2.f1365a) {
                    j3 = a2 + j4;
                    break;
                }
            }
            j3 = 0;
            if (j3 == 0) {
                ColorNote.m651a("Can't calculate next lunar date. it may be > 2050");
                break;
            }
        }
        return j3;
    }

    private static void m1614a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, boolean z) {
        if (!"Nokia".equals(Build.MANUFACTURER) || z) {
            notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
            return;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2130903078);
        if (notification.icon != 0) {
            remoteViews.setImageViewResource(2131624092, notification.icon);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(2131624096, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(2131624031, charSequence2);
        }
        notification.contentView = remoteViews;
        notification.contentIntent = pendingIntent;
    }

    public static boolean m1616a(C0230t c0230t) {
        if (c0230t.f1014m == 0 || c0230t.m1065g() == 0) {
            return false;
        }
        return true;
    }

    public static void m1611a(Context context, long j) {
        Cursor query = context.getContentResolver().query(C0228r.f997a, null, "reminder_type = ? AND reminder_date > ? AND reminder_date < ?", new String[]{"32", "0", String.valueOf(j)}, "reminder_date ASC");
        if (query == null) {
            throw new C0200a("Null cursor returned from provider");
        }
        while (query.moveToNext()) {
            C0310g.m1620d(context, query.getLong(query.getColumnIndex("_id")));
        }
        query.close();
    }
}
