package com.socialnmobile.colornote.data;

import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.socialnmobile.colornote.data.u */
public final class C0231u {
    static ReentrantReadWriteLock f1024a;
    private C0232v f1025b;
    private C0234x f1026c;

    static {
        f1024a = new ReentrantReadWriteLock();
    }

    public static void m1069a() {
        f1024a.readLock().lock();
    }

    public static void m1070b() {
        f1024a.readLock().unlock();
    }

    public static void m1071c() {
        f1024a.writeLock().lock();
    }

    public static void m1072d() {
        f1024a.writeLock().unlock();
    }

    C0231u(C0232v c0232v) {
        this.f1025b = c0232v;
    }

    C0231u(C0234x c0234x) {
        this.f1026c = c0234x;
    }

    private C0232v m1068a(SQLiteDatabase sQLiteDatabase) {
        if (this.f1025b == null || this.f1025b.f1027a != sQLiteDatabase) {
            this.f1025b = new C0232v(sQLiteDatabase);
        }
        return this.f1025b;
    }

    public final C0232v m1073e() {
        if (this.f1026c != null) {
            return m1068a(this.f1026c.getReadableDatabase());
        }
        return this.f1025b;
    }

    public final C0232v m1074f() {
        if (this.f1026c != null) {
            return m1068a(this.f1026c.getWritableDatabase());
        }
        return this.f1025b;
    }
}
