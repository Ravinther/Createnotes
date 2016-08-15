package com.socialnmobile.colornote;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import com.socialnmobile.colornote.p006a.C0147f;

/* renamed from: com.socialnmobile.colornote.a */
public final class C0151a {
    private static C0151a f624b;
    int f625a;

    public static C0151a m676a() {
        if (f624b == null) {
            f624b = new C0151a();
        }
        return f624b;
    }

    public final void m677a(Context context, int i, long j, PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(pendingIntent);
        alarmManager.set(i, j, pendingIntent);
        m679b();
    }

    public final void m678a(Context context, long j, PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(pendingIntent);
        C0147f.m664a(alarmManager, j, pendingIntent);
        m679b();
    }

    public final void m679b() {
        this.f625a++;
        if (this.f625a == 450) {
            C0311h.f1370a.m1623a("ALARM SET EXCEED", "ALARM SET EXCEED", "450");
        }
        if (this.f625a == 2000) {
            C0311h.f1370a.m1623a("ALARM SET EXCEED", "ALARM SET EXCEED", "2000");
        }
    }
}
